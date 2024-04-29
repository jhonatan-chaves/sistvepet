package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.TutorRecordDTO;
import com.jhonchaves.models.TutorModel;
import com.jhonchaves.repository.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {

    @Autowired
    private TutorRepository tutorRepository;

    @PostMapping("/cadastrar/tutor")
    public ResponseEntity<TutorModel> cadastrarTutor(@RequestBody @Valid TutorRecordDTO tutorRecordDTO){
        TutorModel tutor = new TutorModel();
        BeanUtils.copyProperties(tutorRecordDTO, tutor);
        tutor.getPets().forEach(pets -> pets.setTutor(tutor));
        tutorRepository.save(tutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(tutor);
    }

    @GetMapping("/tutor/{id}")
    public ResponseEntity<TutorModel> getTutor(@PathVariable(value = "id") Long id){
        return tutorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
