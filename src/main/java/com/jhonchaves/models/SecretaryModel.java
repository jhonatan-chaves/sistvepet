package com.jhonchaves.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
public class SecretaryModel extends PessoaModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    private Long registration;
    private String office;

    @OneToOne
    private UsuarioModel usuarioModel;


    public SecretaryModel(){}


    public SecretaryModel(Long id, String firstName, String middleName, String cpf, char sex,
                          Date birthDate, Long registration, String office, UsuarioModel usuarioModel){
        super.id = id;
        super.firstName = firstName;
        super.middleName = middleName;
        super.cpf = cpf;
        super.sex = sex;
        super.birthDate = birthDate;
        this.registration = registration;
        this.office = office;
        this.usuarioModel = usuarioModel;

    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
}
