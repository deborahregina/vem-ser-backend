package com.dbc.pessoaapi.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorPk implements Serializable {

    @Column(name = "id_professor")
    private Integer idProfessor;

    @Column(name = "id_universidade")
    private Integer idUniversidade;

}
