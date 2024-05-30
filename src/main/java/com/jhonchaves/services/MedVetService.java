package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.MedVetRecordDTO;
import com.jhonchaves.domain.Email;
import com.jhonchaves.domain.NumeroCelular;
import com.jhonchaves.models.ContatoModel;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.repository.MedVetRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class MedVetService {


    private final MedVetRepository medVetRepository;

    public MedVetService (MedVetRepository medVetRepository){
        this.medVetRepository = medVetRepository;
    }


    public MedVetModel save(MedVetRecordDTO medVetRecordDTO){
        Optional<MedVetModel> existCpf = medVetRepository.findByCpf(medVetRecordDTO.cpf());
        if(existCpf.isPresent()){
            throw new RuntimeException("Medico Já Cadastrado!");
        }
        MedVetModel medVet = new MedVetModel();
        BeanUtils.copyProperties(medVetRecordDTO,medVet);

        if(medVetRecordDTO.contatos() != null){
            medVetRecordDTO.contatos().forEach(contatoDTO -> {
               // ContatoModel contato =
                       // ContatoModel.createForMedVet(contatoDTO.tipo(), contatoDTO.valor(),
                                                    // contatoDTO.principal(), medVet);
               // medVet.getContatos().add(contato);
            });
        }


        medVetRepository.save(medVet);
        return medVet;
    }


     /* if (medVetRecordDTO.contatos() != null) {
            medVetRecordDTO.contatos().forEach(contatoDTO -> {
                Email email = new Email(contatoDTO.email());
                NumeroCelular numero = new NumeroCelular(contatoDTO.numeroCelular());
                ContatoModel contato = ContatoModel.createForMedVet(numero, email, medVet);
                BeanUtils.copyProperties(contatoDTO, contato);
                contato.setMedVet(medVet);
                medVet.getContatos().add(contato);
            });
        }*/

    public MedVetModel getMedVet(Long id){
        Optional<MedVetModel> medVetOb = medVetRepository.findById(id);
        return medVetOb.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Medico não encontrado!"));
    }


}
