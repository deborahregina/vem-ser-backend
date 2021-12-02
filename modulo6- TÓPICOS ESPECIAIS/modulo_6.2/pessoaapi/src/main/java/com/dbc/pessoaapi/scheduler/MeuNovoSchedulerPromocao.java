/*
package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MeuNovoSchedulerPromocao {

    private final EmailService emailService;
    private final ObjectMapper objectMapper;
    private final PessoaRepository pessoaRepository;


    @Scheduled(cron = "0 0 0 25 12 ?", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException, MessagingException, TemplateException, IOException {
//
        List<PessoaEntity> pessoaEntities = pessoaRepository.findAll();

        for (PessoaEntity pessoa : pessoaEntities) {
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
            emailService.enviarEmailPromocao(pessoaDTO);
        }
    }
}*/
