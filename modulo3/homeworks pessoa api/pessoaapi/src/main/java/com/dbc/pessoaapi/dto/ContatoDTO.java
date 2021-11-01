package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import lombok.Data;
import lombok.ToString;


import javax.validation.constraints.*;

@Data
public class ContatoDTO extends ContatoCreateDTO {
    private Integer idContato;

}



