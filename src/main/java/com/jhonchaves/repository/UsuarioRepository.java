package com.jhonchaves.repository;

import com.jhonchaves.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    private void logar(){}
}
