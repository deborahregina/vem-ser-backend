package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.PessoaEntity;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaDTO extends PessoaCreateDTO {

    private Integer idPessoa;


}
