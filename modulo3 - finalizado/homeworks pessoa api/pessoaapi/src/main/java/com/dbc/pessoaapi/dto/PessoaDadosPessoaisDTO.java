package com.dbc.pessoaapi.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDadosPessoaisDTO {

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String CPF;

    @NotEmpty
    @NotBlank
    @ApiModelProperty(value = "Nome")
    private String nome;

    @NotNull
    @NotBlank
    @Email
    @ApiModelProperty(value = "E-mail")
    private String email;
    private String rg;
    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String tituloEleitor;
    private Sexo sexo;

    @NotNull
    @Past
    private LocalDate dataNascimento;

}
