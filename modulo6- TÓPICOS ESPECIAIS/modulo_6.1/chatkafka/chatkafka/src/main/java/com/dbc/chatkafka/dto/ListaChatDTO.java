package com.dbc.chatkafka.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListaChatDTO {

    private List<String> nomeUsuario;
    private MensagemDTO mensagemDTO;
}
