package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.PetModel;

import java.util.Date;
import java.util.List;

public record TutorRecordDTO (String firstName, String middleName, String cpf, char sex,
                              Date birthDate, List<PetModel> pets){
}
