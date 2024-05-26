package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.ReceitaRecordDTO;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.models.PetModel;
import com.jhonchaves.models.ReceitaModel;
import com.jhonchaves.repository.MedVetRepository;
import com.jhonchaves.repository.PetRepository;
import com.jhonchaves.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private MedVetRepository medVetRepository;

    public Object save(ReceitaRecordDTO data){

        var receita = new ReceitaModel();


        MedVetModel medVetModel = medVetRepository.findById(data.medVet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Médico Veterinário com ID " + data.medVet() + " não encontrado"));

        PetModel petModel = petRepository.findById(data.pet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Animal de Estimação com ID " + data.pet() + " não encontrado"));

        BeanUtils.copyProperties(data, receita);
        receita.setPet(petModel);
        receita.setMedVet(medVetModel);
        receita.setCrmv(medVetModel.getCrmv());

        return receitaRepository.save(receita);


    }
}
