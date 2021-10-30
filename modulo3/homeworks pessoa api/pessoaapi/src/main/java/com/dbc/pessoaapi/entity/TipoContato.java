package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.Arrays;
@Getter
public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);


    @JsonValue
    public int toValue() {
        return ordinal();
    }

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }

}
