package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class MedVetModel extends PessoaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String specialist;
    private String crmv;

    @OneToOne
    @JsonIgnore
    private UsuarioModel usuarioModel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "medVet")
    private Set<ContatoModel> contatos = new HashSet<>();


    public MedVetModel(){}

    public MedVetModel(Long id, String firstName, String middleName, String cpf, char sex,
                       Date birthDate,String specialist, String crmv, Set<ContatoModel> contatos){
        super.id = id;
        super.firstName = firstName;
        super.middleName = middleName;
        super.cpf = cpf;
        super.sex = sex;
        super.birthDate = birthDate;
        this.specialist = specialist;
        this.crmv = crmv;
        this.contatos = contatos;

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

    public Set<ContatoModel> getContatos() {
        return contatos;
    }

    public void setContatos(Set<ContatoModel> contatos) {
        this.contatos = contatos;
    }
}
