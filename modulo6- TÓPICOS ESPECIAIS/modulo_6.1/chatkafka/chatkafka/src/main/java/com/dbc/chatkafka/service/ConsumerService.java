package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Formatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final ObjectMapper objectMapper;



    @KafkaListener(
            topics = "${kafka.topic.string}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryEarliest"
    )
    public void consumeDto(@Payload String mensagem,
                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        log.info("DATA CRIACAO: {} [{}]: {}",formatter.format(mensagemDTO.getDataCriacao()) ,mensagemDTO.getUsuario(), mensagemDTO.getMensagem());

    }

    @KafkaListener(
            topics = "${kafka.topic.reservado}",
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactoryEarliest"
    )
    public void consume(@Payload String mensagem,
                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        log.info("DATA CRIACAO: {} [{}](privado): {}",formatter.format(mensagemDTO.getDataCriacao()), mensagemDTO.getUsuario(), mensagemDTO.getMensagem());

    }
}
