package com.jhonchaves.repository;

import com.jhonchaves.models.AgendarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendarRepository extends JpaRepository<AgendarModel, Long> {
}
