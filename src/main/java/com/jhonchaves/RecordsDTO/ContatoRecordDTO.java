package com.jhonchaves.RecordsDTO;

import com.jhonchaves.domain.TipoContato;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ContatoRecordDTO( @NotNull(message = "O tipo de contato não pode estar vazio.") TipoContato tipo,
                                @NotBlank(message = "O valor do contato não pode estar vazio.") String valor,
                                Boolean principal) {

    public ContatoRecordDTO {

        if (tipo == TipoContato.EMAIL && !valor.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (tipo == TipoContato.CELULAR && !valor.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new IllegalArgumentException("Número de celular inválido.");
        }
    }




}
