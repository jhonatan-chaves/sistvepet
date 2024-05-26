package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class TutorModel extends PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;

   @OneToMany(mappedBy = "tutor",  orphanRemoval = true, cascade = CascadeType.ALL)
   @JsonIgnore
   private List<PetModel> pets = new ArrayList<PetModel>();

   @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tutor")
   private Set<ContatoModel> contatos = new HashSet<>();



    public TutorModel(){}

    public TutorModel(Long id, String firstName, String middleName, String cpf, char sex, Date birthDate, List<PetModel> pets){
        super.id = id;
        super.firstName = firstName;
        super.middleName = middleName;
        super.cpf = cpf;
        super.sex = sex;
        super.birthDate = birthDate;
        this.pets = pets;
    }

    public List<PetModel> getPets() {
        return pets;
    }

    public void setPets(List<PetModel> pets) {
        this.pets = pets;
    }

    public Set<ContatoModel> getContatos() {
        return contatos;
    }

    public void setContatos(Set<ContatoModel> contatos) {
        this.contatos = contatos;
    }
}

