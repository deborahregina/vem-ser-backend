package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaCreateDTO {
    @NotEmpty
    @NotBlank
    @ApiModelProperty(value = "Nome")
    private String nome;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;

    @NotNull
    @NotBlank
    @Email
    @ApiModelProperty(value = "E-mail")
    private String email;

}
