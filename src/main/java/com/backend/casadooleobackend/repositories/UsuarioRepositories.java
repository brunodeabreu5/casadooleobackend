package com.backend.casadooleobackend.repositories;

import com.backend.casadooleobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Integer> {
}
