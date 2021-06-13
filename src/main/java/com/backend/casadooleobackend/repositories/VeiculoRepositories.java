package com.backend.casadooleobackend.repositories;

import com.backend.casadooleobackend.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepositories extends JpaRepository<Veiculo, Integer> {
}
