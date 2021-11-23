package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


import javax.validation.constraints.*;

@Data
public class ContatoDTO extends ContatoCreateDTO {

    @ApiModelProperty(value = "ID do contato")
    private Integer idContato;

}



