package com.jhonchaves.repository;

import com.jhonchaves.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
    Optional<ContatoModel> findByValor(String valor);
}
