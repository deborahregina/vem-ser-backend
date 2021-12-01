package com.dbc.pessoaapi.Scheduler;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MeuNovoSchedulerCron {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");
    private final EmailService emailService;
    private final PessoaService pessoaService;
    private final

    @Scheduled(cron = "0 18-21 15,20 * * *", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException {
//
        List<PessoaDTO> pessoasDTO = pessoaService.list();

        for(PessoaDTO pessoa : pessoasDTO) {
            if (pessoa.ge)
        }
        emailService.enviarEmailPessoSemEndereco(PessoaDTO pessoaDTO)

    }
}
