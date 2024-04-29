package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.SecretarioRcordDTO;
import com.jhonchaves.RecordsDTO.UsuarioRecordDTO;
import com.jhonchaves.models.SecretaryModel;
import com.jhonchaves.models.UsuarioModel;
import com.jhonchaves.repository.SecretaryRepository;
import com.jhonchaves.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SecretaryController {

    @Autowired
    private SecretaryRepository secretaryRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/secretary")
    public ResponseEntity<SecretaryModel> criar(@RequestBody @Valid SecretaryModel secretaryModel){

        UsuarioModel usuario = new UsuarioModel();
        usuario.setUserName(secretaryModel.getUsuarioModel().getUserName());
        usuario.setPassword(secretaryModel.getUsuarioModel().getPassword());

        usuarioRepository.save(usuario);

        secretaryModel.setUsuarioModel(usuario);


        return ResponseEntity.status(HttpStatus.CREATED).body(secretaryRepository.save(secretaryModel));
    }

    @GetMapping("/secretary/{id}")
    public ResponseEntity<SecretaryModel> getSecretary(@PathVariable(value = "id")Long id){
        return secretaryRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/secretary/{id}")
    public ResponseEntity<SecretaryModel> atualizar(@PathVariable(value = "id")Long id,
                                                    @RequestBody SecretarioRcordDTO secretarioRcordDTO){
        Optional<SecretaryModel> secreUP = secretaryRepository.findById(id);
        SecretaryModel novo = secreUP.get();
        BeanUtils.copyProperties(secretarioRcordDTO, novo);
        return ResponseEntity.status(HttpStatus.OK).body(secretaryRepository.save(novo));
    }




}

