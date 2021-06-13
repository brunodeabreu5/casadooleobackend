package com.backend.casadooleobackend.repositories;

import com.backend.casadooleobackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositories extends JpaRepository<Cliente, Integer> {

}
