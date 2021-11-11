package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @NotNull
    private Integer idPessoa;

    @ApiModelProperty(value = "ID")
    private Integer idEndereco;

}
