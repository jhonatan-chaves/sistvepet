package com.jhonchaves.controllers;

import com.jhonchaves.RecordsDTO.UsuarioRecordDTO;
import com.jhonchaves.models.UsuarioModel;
import com.jhonchaves.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/secretary/usuario/{id}")
    public ResponseEntity<UsuarioModel> criarUs(@PathVariable(value = "id")Long id, @RequestBody UsuarioRecordDTO usuarioRecordDTO){
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDTO, usuario);
        usuario.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }


    @PutMapping("/secretary/usuariooo/{id}")
    public ResponseEntity<UsuarioModel> atuUSu(@PathVariable(value = "id")Long id,
                                               @RequestBody UsuarioRecordDTO usuarioRecordDTO){
        Optional<UsuarioModel> usuUp = usuarioRepository.findById(id);
        UsuarioModel novo = usuUp.get();
        BeanUtils.copyProperties(usuarioRecordDTO, novo);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(novo));
    }
}
