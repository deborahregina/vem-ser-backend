package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoEntity {

    private Integer idEndereco;

}
