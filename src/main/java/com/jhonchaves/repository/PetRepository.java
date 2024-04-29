package com.jhonchaves.repository;

import com.jhonchaves.models.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetModel, Long> {
}
