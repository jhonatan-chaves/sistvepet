package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.MedVetRecordDTO;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.repository.MedVetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MedVetService {

    @Autowired
    private MedVetRepository medVetRepository;

    public MedVetModel save(MedVetRecordDTO medVetRecordDTO){
        Optional<MedVetModel> existCpf = medVetRepository.findByCpf(medVetRecordDTO.cpf());
        if(existCpf.isPresent()){
            throw new RuntimeException("Medico Já Cadastrado!");
        }
        MedVetModel medVet = new MedVetModel();
        BeanUtils.copyProperties(medVetRecordDTO,medVet);
        medVetRepository.save(medVet);
        return medVet;
    }

    public MedVetModel getMedVet(Long id){
        Optional<MedVetModel> medVetOb = medVetRepository.findById(id);
        return medVetOb.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Medico não encontrado!"));
    }


}
