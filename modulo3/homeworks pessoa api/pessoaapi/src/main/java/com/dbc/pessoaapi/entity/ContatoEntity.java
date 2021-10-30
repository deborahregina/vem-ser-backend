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
public class ContatoEntity {

    private Integer idContato;

    private Integer idPessoa;

    private TipoContato tipoContato;

    private String numero;

    private String descricao;

}
