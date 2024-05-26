package com.jhonchaves.models;

import com.jhonchaves.enums.StatusEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class ConsultarModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultar;

    @ManyToOne
    private TutorModel tutor;

    @ManyToOne
    private PetModel pet;

    @ManyToOne
    private MedVetModel medVet;

    private Date dataHoraConsulta;

    private String anotacoes;

    private String tipo;


}
