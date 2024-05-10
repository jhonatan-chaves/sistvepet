package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.models.PetModel;
import com.jhonchaves.models.TutorModel;

import java.util.Date;

public record AgendarRequestDTO(Date dataHoraCriacao,
                                Date dataHoraConsulta, Long tutor, Long pet,
                                String status, Long medVet, String tipo) {
}
