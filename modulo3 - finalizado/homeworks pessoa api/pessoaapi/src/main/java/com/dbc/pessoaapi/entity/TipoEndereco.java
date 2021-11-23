package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;
@Getter
public enum TipoEndereco {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    @JsonValue
    public int toValue() {
        return ordinal();
    }

    TipoEndereco(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoEndereco ofTipo(Integer tipo){
        return Arrays.stream(TipoEndereco.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
