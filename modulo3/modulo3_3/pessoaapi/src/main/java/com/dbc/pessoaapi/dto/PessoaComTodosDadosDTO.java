package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PessoaComTodosDadosDTO extends PessoaDTO {

    Set<EnderecoDTO> enderecos;
    Set<ContatoDTO> contatos;
}
