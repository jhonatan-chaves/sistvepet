package com.jhonchaves.models;

import com.jhonchaves.RecordsDTO.AgendarRequestDTO;
import com.jhonchaves.enums.StatusEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class AgendarModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAgendar;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private Date dataHoraCriacao;
    private Date dataHoraConsulta;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private TutorModel tutor;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetModel pet;


    @ManyToOne
    @JoinColumn(name = "med_vet_id")
    private MedVetModel medVet;

    private String tipo;

    public AgendarModel(){}

    public AgendarModel(Long idAgendar, Date dataHoraCriacao, Date dataHoraConsulta,
                        TutorModel tutor, PetModel pet, StatusEnum status, MedVetModel medVet, String tipo) {
        this.idAgendar = idAgendar;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraConsulta = dataHoraConsulta;
        this.tutor = tutor;
        this.pet = pet;
        this.status = status;
        this.medVet = medVet;
        this.tipo = tipo;
    }





    public Long getIdAgendar() {
        return idAgendar;
    }

    public void setIdAgendar(Long idAgendar) {
        this.idAgendar = idAgendar;
    }

    public Date getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Date dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Date getDataHoraConsulta() {
        return dataHoraConsulta;
    }

    public void setDataHoraConsulta(Date dataHoraConsulta) {
        this.dataHoraConsulta = dataHoraConsulta;
    }

    public TutorModel getTutor() {
        return tutor;
    }

    public void setTutor(TutorModel tutor) {
        this.tutor = tutor;
    }

    public PetModel getPet() {
        return pet;
    }

    public void setPet(PetModel pet) {
        this.pet = pet;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public MedVetModel getMedVet() {
        return medVet;
    }

    public void setMedVet(MedVetModel medVet) {
        this.medVet = medVet;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
