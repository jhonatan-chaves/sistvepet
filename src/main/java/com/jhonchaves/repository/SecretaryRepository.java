package com.jhonchaves.repository;

import com.jhonchaves.models.SecretaryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretaryRepository extends JpaRepository<SecretaryModel, Long> {

    private void gerenciarMedVet(){}
    private void gerenciarTutor(){}
    private void marcarConsulta(){}
}
