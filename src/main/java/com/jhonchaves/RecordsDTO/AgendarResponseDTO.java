package com.jhonchaves.RecordsDTO;

import com.jhonchaves.enums.StatusEnum;
import com.jhonchaves.models.*;

import java.util.Date;

public record AgendarResponseDTO(Long idAgendar, Date dataHoraCriacao,
                                 Date dataHoraConsulta, TutorModel tutor, PetModel pet,
                                 StatusEnum status, MedVetModel medVet, String tipo) {
    public AgendarResponseDTO(AgendarModel agendarModel){
        this(agendarModel.getIdAgendar(), agendarModel.getDataHoraCriacao(), agendarModel.getDataHoraConsulta()
        ,agendarModel.getTutor(), agendarModel.getPet(), agendarModel.getStatus(), agendarModel.getMedVet(), agendarModel.getTipo());

    }
}
