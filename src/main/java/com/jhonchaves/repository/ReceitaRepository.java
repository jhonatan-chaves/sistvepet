package com.jhonchaves.repository;

import com.jhonchaves.models.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {
}
