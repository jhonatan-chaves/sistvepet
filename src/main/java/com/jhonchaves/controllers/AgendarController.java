package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.AgendarRequestDTO;
import com.jhonchaves.RecordsDTO.AgendarResponseDTO;
import com.jhonchaves.models.AgendarModel;
import com.jhonchaves.repository.AgendarRepository;
import com.jhonchaves.services.AgendarService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendar")
public class AgendarController {

    @Autowired
    private AgendarService agendarService;

    @Autowired
    private AgendarRepository agendarRepository;

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody  AgendarRequestDTO data){
        return ResponseEntity.status(HttpStatus.CREATED).body(agendarService.save(data));
    }

    @GetMapping("/")
    public List<AgendarResponseDTO> getAll(){
        List<AgendarResponseDTO> lista = agendarRepository.findAll().stream().map(AgendarResponseDTO::new).toList();
        return lista;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendarModel> gatAgendamento(@PathVariable(value = "id") Long id){
        return agendarRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
