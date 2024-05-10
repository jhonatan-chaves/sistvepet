package com.jhonchaves.enums;

public enum StatusEnum {

    PENDENTE(0),
    CONFIRMADO(1),
    CANCELADO_PELO_TUTOR(2),
    CANCELADO_PELO_MEDICO(3),
    CONCLUIDO(4),
    REAGENDADO(5);


    private final int valorNumerico;

    StatusEnum(int valorNumerico){
        this.valorNumerico = valorNumerico;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    public static StatusEnum fromValorNumerico(int valorNumerico) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getValorNumerico() == valorNumerico) {
                return status;
            }
        }
        throw new IllegalArgumentException("Número de status inválido: " + valorNumerico);
    }

}
