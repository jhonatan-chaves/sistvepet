package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class PetModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPet;
    private String nomePet;
    private String raca;
    private String cor;
    private Date dataNascimentoPet;
    private String type;
    private char sexoAnimal;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private TutorModel tutor;

    public PetModel(){}

    public PetModel(Long idPet, String nomePet, String raca, String cor, Date dataNascimentoPet,
                    String type,char sexoAnimal, TutorModel tutor) {
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.raca = raca;
        this.cor = cor;
        this.dataNascimentoPet = dataNascimentoPet;
        this.type = type;
        this.sexoAnimal = sexoAnimal;
        this.tutor = tutor;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getDataNascimentoPet() {
        return dataNascimentoPet;
    }

    public void setDataNascimentoPet(Date dataNascimentoPet) {
        this.dataNascimentoPet = dataNascimentoPet;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }


    public char getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(char sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public TutorModel getTutor() {
        return tutor;
    }

    public void setTutor(TutorModel tutor) {
        this.tutor = tutor;
    }
}
