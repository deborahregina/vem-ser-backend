package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class EnderecoCreateDTO {

    @NotNull
    @ApiModelProperty(value = "Tipo de endereço \n[0:Residencial 1:Comercial]")
    private Integer tipoEndereco;


    @NotBlank
    @NotNull
    @ApiModelProperty(value = "Logradouro")
    @Size(max = 250)
    private String logradouro;


    @NotNull
    @ApiModelProperty(value = "Número")
    private Integer numero;

    @ApiModelProperty(value = "Complemento")
    private String complemento;

    @NotBlank
    @NotNull
    @ApiModelProperty(value = "CEP")
    @Size(max = 8)
    private String cep;


    @NotBlank
    @NotNull
    @ApiModelProperty(value = "Cidade")
    @Size(max = 250)
    private String cidade;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "Estado")
    private String estado;

    @NotNull
    @NotBlank
    @ApiModelProperty(value = "País")

    private String pais;
}
