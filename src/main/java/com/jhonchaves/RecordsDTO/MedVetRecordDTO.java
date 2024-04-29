package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.UsuarioModel;

import java.util.Date;

public record MedVetRecordDTO (String firstName, String middleName, String cpf, char sex,
                              Date birthDate, String specialist, String crmv){
}
