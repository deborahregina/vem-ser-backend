package com.dbc.pessoaapi.kafka;

import com.dbc.pessoaapi.dto.EmailDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;

    @Value(value = "${kafka.topic.string}")
    private String topico;


    private void send(String mensagem, String topico) {
        Message<String> message = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topico)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> send = stringKafkaTemplate.send(message);

        send.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao enviar mensagem ao kafka, texto: {}", mensagem);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info(" Mensagem enviada com sucesso para o kafka com o texto: {}", mensagem);
            }
        });
    }

    @Scheduled(cron = "0 0 0 25 12 ?", zone = "GMT-3")
    //@Scheduled(fixedDelay = 5)
    public void sendMessageEnderecos() throws JsonProcessingException {
        List<PessoaEntity> pessoasEntity = pessoaRepository.findPessoasComEndNull();

        for(PessoaEntity pessoaEntity: pessoasEntity) {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setTexto("    \"Olá,"  + pessoaEntity.getNome()+ "\nEstamos felizes em ter você em nosso sistema!!\n "+
                    "Para que possamos enviá-los um brinde exclusivo, por gentileza, adicione ou atualize o seu endereço no seu cadastro.\n");
            emailDTO.setAssunto("E-Mail para alterações cadastrais");
            emailDTO.setDestinatario("deborah.regina@dbccompany.com.br");
            String payload = objectMapper.writeValueAsString(emailDTO);
            send(payload, topico);
        }

    }

    @Scheduled(cron = "0 0 8,20 * * *", zone = "GMT-3")
    public void sendMessagePromocoes() throws JsonProcessingException {
        List<PessoaEntity> pessoaEntities = pessoaRepository.findAll();

        for (PessoaEntity pessoa : pessoaEntities) {
            EmailDTO emailDTO = new EmailDTO();
            emailDTO.setTexto("Olá"+ pessoa.getNome()+ "\nSelecionamos algumas das nossas super promoções de natal\n na nossa plataorma" +
                    "\nNa compra de 1CDs do Chitãozinho e Xoxoró, ganhe 1 do Milionário e José Rico\n Aproveite... \n Magazine OldsSchool");
            emailDTO.setAssunto("E-Mail Promocional");
            emailDTO.setDestinatario("deborah.regina@dbccompany.com.br");
            String payload = objectMapper.writeValueAsString(emailDTO);
            send(payload, topico);
        }

    }

}