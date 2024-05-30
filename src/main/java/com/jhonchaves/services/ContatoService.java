package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.ContatoRecordDTO;
import com.jhonchaves.domain.Email;
import com.jhonchaves.domain.NumeroCelular;
import com.jhonchaves.domain.TipoContato;
import com.jhonchaves.models.ContatoModel;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.repository.ContatoRepository;
import com.jhonchaves.repository.MedVetRepository;
import com.jhonchaves.repository.SecretaryRepository;
import com.jhonchaves.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ContatoService {


    private final MedVetRepository medVetRepository;
    private final TutorRepository tutorRepository;
    private final SecretaryRepository secretaryRepository;
    private final ContatoRepository contatoRepository;

    public ContatoService(MedVetRepository medVetRepository, TutorRepository tutorRepository,
                          SecretaryRepository secretaryRepository, ContatoRepository contatoRepository){
        this.medVetRepository = medVetRepository;
        this.tutorRepository = tutorRepository;
        this.secretaryRepository = secretaryRepository;
        this.contatoRepository = contatoRepository;
    }

    @Transactional
    public ContatoRecordDTO criarContatoMedVet(Long medVetId, ContatoRecordDTO contatoRecordDTO){
        MedVetModel medVet = medVetRepository.findById(medVetId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"MedVet not found"));
         contatoRepository.findByValor(contatoRecordDTO.valor())
                .ifPresent(contato -> {
                    throw new RuntimeException(contatoRecordDTO.valor() +" já cadastrado.");
                });
        ContatoModel contato = new ContatoModel();
        BeanUtils.copyProperties(contatoRecordDTO, contato);
        sendNotification(contato);
        contato.setEntidadeRelacionada(medVet);
        return convertToDTO(contato);
    }

    private void sendNotification(ContatoModel contato){
        switch (contato.getTipo()){
            case EMAIL:
                new Email(contato.getValor()).sendNotification("Confime seu E-mail!");
                break;
            case CELULAR:
                new NumeroCelular(contato.getValor()).sendNotification("Confirme seu numero de celular.");
                break;
            default:
                throw new IllegalArgumentException("Tipo de contato não suportado: " + contato.getTipo());
        }
    }


    private ContatoRecordDTO convertToDTO(ContatoModel contact) {

        return new ContatoRecordDTO(contact.getTipo(), contact.getValor(), contact.getPrincipal());
    }



}
