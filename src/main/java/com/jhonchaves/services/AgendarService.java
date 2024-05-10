package com.jhonchaves.services;

import com.jhonchaves.RecordsDTO.AgendarRequestDTO;
import com.jhonchaves.enums.StatusEnum;
import com.jhonchaves.models.AgendarModel;
import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.models.PetModel;
import com.jhonchaves.models.TutorModel;
import com.jhonchaves.repository.AgendarRepository;
import com.jhonchaves.repository.MedVetRepository;
import com.jhonchaves.repository.PetRepository;
import com.jhonchaves.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AgendarService {

    @Autowired
    private AgendarRepository agendarRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private MedVetRepository medVetRepository;
    @Autowired
    private PetRepository petRepository;

    public Object save(AgendarRequestDTO data){
        AgendarModel agendar = new AgendarModel();

        TutorModel tutorModel = tutorRepository.findById(data.tutor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tutor com ID " + data.tutor() + " não encontrado"));


        MedVetModel medVetModel = medVetRepository.findById(data.medVet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Médico Veterinário com ID " + data.medVet() + " não encontrado"));


        PetModel petModel = petRepository.findById(data.pet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Animal de Estimação com ID " + data.pet() + " não encontrado"));
        // Verifica se o ID do tutor associado ao ID do pet é o mesmo que o ID do tutor fornecido
        if (!petModel.getTutor().getId().equals(tutorModel.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "O Tutor com ID " + data.tutor() + " não é o tutor do Animal de Estimação com ID " + data.pet());
        }


        BeanUtils.copyProperties(data, agendar);

        agendar.setStatus(StatusEnum.PENDENTE);
        agendar.setTutor(tutorModel);
        agendar.setMedVet(medVetModel);
        agendar.setPet(petModel);



        System.out.println(petModel.getTutor().getId());



        return  agendarRepository.save(agendar);


    }

    /*
    *
    *  public Object save(AgendarRequestDTO agendarRecordDTO){
        AgendarModel agendar = new AgendarModel();
        // Busca o tutor pelo ID e verifica se existe
        TutorModel tutorModel = tutorRepository.findById(agendarRecordDTO.idTutor())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Tutor com ID " + agendarRecordDTO.idTutor() + " não encontrado"));

        // Busca o médico veterinário pelo ID e verifica se existe
        MedVetModel medVetModel = medVetRepository.findById(agendarRecordDTO.idMedVet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Médico Veterinário com ID " + agendarRecordDTO.idMedVet() + " não encontrado"));

        // Busca o animal de estimação pelo ID e verifica se existe
        PetModel petModel = petRepository.findById(agendarRecordDTO.idPet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Animal de Estimação com ID " + agendarRecordDTO.idPet() + " não encontrado"));

        // Define os objetos completos no agendar
        BeanUtils.copyProperties(agendarRecordDTO, agendar);
        agendar.setIdTutor(tutorModel.getId());
        agendar.setIdMedVet(medVetModel.getId());
        agendar.setIdPet(petModel.getIdPet());

        // Salva o agendar
        AgendarModel savedAgendar = agendarRepository.save(agendar);

        // Retorna um objeto AgendarResponseDTO com os objetos completos
        return new AgendarResponseDTO(
                savedAgendar.getDataHoraCriacao(),
                savedAgendar.getDataHoraConsulta(),
                tutorModel,
                petModel,
                savedAgendar.getStatus(),
                medVetModel,
                savedAgendar.getTipo()
        );
    }
    *
    * */
}
