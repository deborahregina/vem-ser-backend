package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.dto.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.sql.DataSourceDefinition;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDadosPessoaisEntity {

    private Integer id;
    private String CPF;
    private String nome;
    private String email;
    private String rg;
    private String cnh;
    private String nomeMae;
    private String nomePai;
    private String tituloEleitor;
    private Sexo sexo;
    private LocalDate dataNascimento;

}
