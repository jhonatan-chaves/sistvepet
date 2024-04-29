package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class TutorModel extends PessoaModel implements Serializable {
    private static final Long serialVersionUID = 1L;

   @OneToMany(mappedBy = "tutor",  orphanRemoval = true, cascade = CascadeType.ALL)
   private List<PetModel> pets = new ArrayList<PetModel>();



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
}

