package com.jhonchaves.repository;

import com.jhonchaves.models.MedVetModel;
import com.jhonchaves.models.TutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedVetRepository extends JpaRepository<MedVetModel, Long> {

    Optional<MedVetModel> findByCpf(String cpf);
    private void  marcarExame(TutorModel tutorModel){}
    private void consultarPet(){}
}
