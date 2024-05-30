package com.jhonchaves.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Email {


    @NotBlank(message = "O email não pode estar vazio.")
    private String valor;

    public Email(){}

    public Email(String valor){
        if (!valor.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.valor = valor;
    }

    public void sendNotification(String message) {

        System.out.println("Enviando email para " + valor + ": " + message);
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
