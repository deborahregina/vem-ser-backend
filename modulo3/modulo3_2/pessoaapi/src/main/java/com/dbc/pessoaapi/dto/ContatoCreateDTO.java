package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoCreateDTO {

    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;

    @NotNull
    @Max(1)
    @Min(0)
    @ApiModelProperty(value = "Tipo de contato \n[0:Residencial 1:Comercial]")
    private Integer tipoContato;

    @NotBlank
    @Size(min = 0, max = 13)
    @ApiModelProperty(value = "Número do telefone")
    private String numero;

    @ApiModelProperty(value = "Descrição do contato")
    private String descricao;


}
