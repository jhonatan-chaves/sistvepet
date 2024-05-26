package com.jhonchaves.repository;

import com.jhonchaves.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
}
