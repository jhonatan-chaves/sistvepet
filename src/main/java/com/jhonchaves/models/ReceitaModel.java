package com.jhonchaves.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class ReceitaModel  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReceita;

    @ManyToOne
    private PetModel pet;

    @ManyToOne
    private MedVetModel medVet;

    private String crmv;

    private String prescricao;

    private Date dataHoraEmissao;

    public ReceitaModel(){}

    public ReceitaModel(Long idReceita, PetModel pet, MedVetModel medVet, String crmv, String prescricao, Date dataHoraEmissao) {
        this.idReceita = idReceita;
        this.pet = pet;
        this.medVet = medVet;
        this.crmv = crmv;
        this.prescricao = prescricao;
        this.dataHoraEmissao = dataHoraEmissao;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public PetModel getPet() {
        return pet;
    }

    public void setPet(PetModel pet) {
        this.pet = pet;
    }

    public MedVetModel getMedVet() {
        return medVet;
    }

    public void setMedVet(MedVetModel medVet) {
        this.medVet = medVet;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public Date getDataHoraEmissao() {
        return dataHoraEmissao;
    }

    public void setDataHoraEmissao(Date dataHoraEmissao) {
        this.dataHoraEmissao = dataHoraEmissao;
    }
}
