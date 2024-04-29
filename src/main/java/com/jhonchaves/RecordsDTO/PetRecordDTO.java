package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.TutorModel;

import java.util.Date;

public record PetRecordDTO(String nomePet, String raca, String cor, Date dataNascimentoPet,
                           String type, char sexoAnimal, TutorModel tutorModel) {
}
