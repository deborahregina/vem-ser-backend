package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull
    @Max(1)
    @Min(0)
    private Integer tipoContato;

    @NotBlank
    @Size(min = 0, max = 13)
    private String numero;

    private String descricao;


}
