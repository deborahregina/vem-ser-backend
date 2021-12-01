package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PessoaComEnderecoDTO extends PessoaDTO {

    private Set<EnderecoDTO> enderecos;
}
