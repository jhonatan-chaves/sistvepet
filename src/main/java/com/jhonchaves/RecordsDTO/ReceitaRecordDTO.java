package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.models.PetModel;

import java.util.Date;

public record ReceitaRecordDTO(Long pet, Long medVet,
                               String prescricao, Date dataHoraEmissao) {
}
