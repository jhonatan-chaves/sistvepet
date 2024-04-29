package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.MedVetRecordDTO;
import com.jhonchaves.services.MedVetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MedVetController {

    @Autowired
    private MedVetService medVetService;

    @PostMapping("/registrar/medvet")
    public ResponseEntity<Object> criarMedVet(@RequestBody @Valid MedVetRecordDTO medVetRecordDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(medVetService.save(medVetRecordDTO));
    }

    @GetMapping("/gerenciar/medvet/{id}")
    public ResponseEntity<Object> getMedVet(@PathVariable(value = "id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(medVetService.getMedVet(id));
    }

}
