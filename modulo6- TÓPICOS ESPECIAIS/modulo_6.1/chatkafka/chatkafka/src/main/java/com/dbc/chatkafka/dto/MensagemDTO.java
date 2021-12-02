package com.dbc.chatkafka.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MensagemDTO {

    private LocalDateTime dataCriacao;
    private String mensagem;
    private String usuario;

}
