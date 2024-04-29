package com.jhonchaves.RecordsDTO;

import com.jhonchaves.models.UsuarioModel;

import java.util.Date;

public record SecretarioRcordDTO(String firstName, String middleName, String cpf, char sex,
                                 Date birthDate, Long registration, String office) {
}
