package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.ReceitaRecordDTO;
import com.jhonchaves.services.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody ReceitaRecordDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.save(data));
    }
}
