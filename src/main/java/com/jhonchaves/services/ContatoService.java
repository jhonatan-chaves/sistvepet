package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.ContatoRecordDTO;
import com.jhonchaves.models.ContatoModel;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.repository.ContatoRepository;
import com.jhonchaves.repository.MedVetRepository;
import com.jhonchaves.repository.SecretaryRepository;
import com.jhonchaves.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContatoService {

    @Autowired
    private MedVetRepository medVetRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private SecretaryRepository secretaryRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public ContatoRecordDTO criarContatoMedVet(Long medVetId, ContatoRecordDTO contatoRecordDTO){
        MedVetModel medVet = medVetRepository.findById(medVetId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"MedVet not found"));

        ContatoModel contact = ContatoModel.createForMedVet(contatoRecordDTO.numeroCelular(), contatoRecordDTO.email(), medVet);
        ContatoModel savedContact = contatoRepository.save(contact);

        return convertToDTO(savedContact);
    }

    private ContatoRecordDTO convertToDTO(ContatoModel contact) {
        return new ContatoRecordDTO(contact.getNumeroCelular(), contact.getEmail());
    }



}
