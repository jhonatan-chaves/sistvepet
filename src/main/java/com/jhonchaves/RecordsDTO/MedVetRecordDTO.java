package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.ContatoModel;
import com.jhonchaves.models.UsuarioModel;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record MedVetRecordDTO (String firstName, String middleName, String cpf, char sex,
                               Date birthDate, String specialist, String crmv, Set<ContatoRecordDTO> contatos){
}
