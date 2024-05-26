package com.jhonchaves.RecordsDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record ContatoRecordDTO(@NotEmpty(message = "digite um numero de celular por favor!") String numeroCelular,
                               @Email(message = "email precisa ser valido")
                               @NotEmpty(message = "digite o email por favor!") String email) {
}
