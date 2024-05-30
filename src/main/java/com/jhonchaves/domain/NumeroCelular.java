package com.jhonchaves.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class NumeroCelular {

    @NotBlank(message = "O número de celular não pode estar vazio.")
    private String valor;


    public NumeroCelular() {}

    public NumeroCelular(String valor) {
        if (!valor.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new IllegalArgumentException("Número de celular inválido");
        }
        this.valor = valor;
    }


    public void sendNotification(String message) {

        System.out.println("Enviando SMS para " + valor + ": " + message);
    }


    public void sendPasswordResetLink() {

        System.out.println("Enviando link de troca de senha para " + valor);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
