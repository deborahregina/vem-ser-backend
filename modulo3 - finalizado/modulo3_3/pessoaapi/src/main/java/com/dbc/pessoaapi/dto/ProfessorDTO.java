package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.pk.ProfessorPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private ProfessorPkDTO professorPkDTO;

    private String nome;

    private Double salario;



}
