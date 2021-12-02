package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PessoaComContatoDTO extends PessoaDTO {

    private Integer idPessoa;
    private Set<ContatoDTO> contatos;
}
