package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO {
        @ApiModelProperty(value = "Id do contato")
        private Integer idContato;

}