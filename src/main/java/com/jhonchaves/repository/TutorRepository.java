package com.jhonchaves.repository;

import com.jhonchaves.models.TutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorModel, Long> {

    private void agendarConsulta(){}
}
