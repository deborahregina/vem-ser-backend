package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull
    private Integer tipoEndereco;


    @NotBlank
    @NotNull
    @Size(max = 250)
    private String logradouro;


    @NotNull
    private Integer numero;


    private String complemento;

    @NotBlank
    @NotNull
    @Size(max = 8)
    private String cep;


    @NotBlank
    @NotNull
    @Size(max = 250)
    private String cidade;

    @NotNull
    @NotBlank
    private String estado;

    @NotNull
    @NotBlank
    private String pais;
}
