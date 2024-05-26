package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class ContatoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContato;


    private String numeroCelular;

    private String email;


    @ManyToOne
    @JoinColumn(name = "medVet_id")
    @JsonIgnore
    private MedVetModel medVet;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    @JsonIgnore
    private TutorModel tutor;

    @ManyToOne
    @JoinColumn(name = "secretary_id")
    @JsonIgnore
    private SecretaryModel secretary;




    public ContatoModel(){}

    public ContatoModel(Long idContato, String numeroCelular, String email, MedVetModel medVet) {
        this.idContato = idContato;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.medVet = medVet;

    }

    public ContatoModel(Long idContato, String numeroCelular, String email, TutorModel tutor) {
        this.idContato = idContato;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.tutor = tutor;

    }

    public ContatoModel(Long idContato, String numeroCelular, String email, SecretaryModel secretary) {
        this.idContato = idContato;
        this.numeroCelular = numeroCelular;
        this.email = email;
        this.secretary = secretary;

    }

    public static ContatoModel createForMedVet(String numeroCelular, String email, MedVetModel medVet) {
        return new ContatoModel(null, numeroCelular, email, medVet);
    }

    public static ContatoModel createForTutor(String numeroCelular, String email, TutorModel tutor) {
        return new ContatoModel(null, numeroCelular, email, tutor);
    }

    public static ContatoModel createForSecretary(String numeroCelular, String email, SecretaryModel secretary) {
        return new ContatoModel(null, numeroCelular, email, secretary);
    }


    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MedVetModel getMedVet() {
        return medVet;
    }

    public void setMedVet(MedVetModel medVet) {
        this.medVet = medVet;
    }

    public TutorModel getTutor() {
        return tutor;
    }

    public void setTutor(TutorModel tutor) {
        this.tutor = tutor;
    }

    public SecretaryModel getSecretary() {
        return secretary;
    }

    public void setSecretary(SecretaryModel secretary) {
        this.secretary = secretary;
    }
}
