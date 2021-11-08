package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @ApiModelProperty(value = "ID")
    private Integer idEndereco;

}
