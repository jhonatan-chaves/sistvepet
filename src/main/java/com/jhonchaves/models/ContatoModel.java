package com.jhonchaves.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jhonchaves.domain.EntidadeRelacionada;
import com.jhonchaves.domain.TipoContato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


@Entity
public class ContatoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContato;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de contato não pode estar vazio.")
    private TipoContato tipo;

    private String valor;

    private Boolean principal;


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

    public ContatoModel(Long idContato, TipoContato tipo, String valor, Boolean principal, MedVetModel medVet) {
        this.idContato = idContato;
        this.tipo = tipo;
        this.valor = valor;
        this.principal = principal;
        this.medVet = medVet;

    }

    public ContatoModel(Long idContato, TipoContato tipo, String valor, Boolean principal, TutorModel tutor) {
        this.idContato = idContato;
        this.tipo = tipo;
        this.valor = valor;
        this.principal = principal;
        this.tutor = tutor;

    }

    public ContatoModel(Long idContato, TipoContato tipo, String valor, Boolean principal, SecretaryModel secretary) {
        this.idContato = idContato;
        this.tipo = tipo;
        this.valor = valor;
        this.principal = principal;
        this.secretary = secretary;

    }

    public void setEntidadeRelacionada(EntidadeRelacionada entidade) {
        entidade.adicionarContato(this);
    }

    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
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
