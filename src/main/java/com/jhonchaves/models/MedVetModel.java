package com.jhonchaves.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
public class MedVetModel extends PessoaModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String specialist;
    private String crmv;

    @OneToOne
    private UsuarioModel usuarioModel;

    public MedVetModel(){}

    public MedVetModel(Long id, String firstName, String middleName, String cpf, char sex,
                       Date birthDate,String specialist, String crmv){
        super.id = id;
        super.firstName = firstName;
        super.middleName = middleName;
        super.cpf = cpf;
        super.sex = sex;
        super.birthDate = birthDate;
        this.specialist = specialist;
        this.crmv = crmv;

    }


    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
}
