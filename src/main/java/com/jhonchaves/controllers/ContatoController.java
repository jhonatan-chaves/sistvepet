package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.ContatoRecordDTO;
import com.jhonchaves.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContatoController {


    @Autowired
    private ContatoService contactService;

    @PostMapping("/medVet/{medVetId}")
    public ResponseEntity<ContatoRecordDTO> createContactForMedVet(@PathVariable Long medVetId,
                                                                   @Valid @RequestBody ContatoRecordDTO contactDTO) {
        ContatoRecordDTO createdContact = contactService.criarContatoMedVet(medVetId, contactDTO);
        return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
    }

}
