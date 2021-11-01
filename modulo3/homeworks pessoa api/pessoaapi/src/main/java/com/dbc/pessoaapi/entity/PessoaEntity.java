package com.dbc.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {

    private Integer idPessoa;


    private String nome;


    private LocalDate dataNascimento;


    private String cpf;

    private String email;


}