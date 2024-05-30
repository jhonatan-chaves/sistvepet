package com.jhonchaves.domain;

public enum TipoContato {

    EMAIL("email"),
    CELULAR("celular");

    private final String tipo;

    TipoContato(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public static TipoContato fromString(String tipo) {
        for (TipoContato t : TipoContato.values()) {
            if (t.getTipo().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Tipo de contato não suportado: " + tipo);
    }
}
