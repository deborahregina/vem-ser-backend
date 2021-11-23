package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoEntity {
    private Integer idEndereco;

    private Integer idPessoa;


    private TipoEndereco tipoEndereco;


    private String logradouro;


    private Integer numero;


    private String complemento;


    private String cep;


    private String cidade;


    private String estado;


    private String pais;

}
