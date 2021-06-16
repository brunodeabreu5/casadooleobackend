package com.backend.casadooleobackend.service;

import com.backend.casadooleobackend.dto.VeiculoDTO;
import com.backend.casadooleobackend.model.Veiculo;
import com.backend.casadooleobackend.repositories.VeiculoRepositories;
import com.backend.casadooleobackend.service.exceptions.DataIntegrityViolationException;
import com.backend.casadooleobackend.service.exceptions.ObjectionNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {


    @Autowired
    VeiculoRepositories veiculoRepositories;

    public List<VeiculoDTO> findAll () {
        List<Veiculo> resultList = veiculoRepositories.findAll();
        return resultList.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
    }

    public Veiculo findById (int id) {
        Optional<Veiculo> veiculo = veiculoRepositories.findById(id);
        return veiculo.orElseThrow(() -> new ObjectionNotFountException("Veiculo não encontrado!!!"));
    }

    public Veiculo create (Veiculo veiculo) {
        veiculo.getIdVeiculo();
        return veiculoRepositories.save(veiculo);
    }

    public Veiculo update (int id, VeiculoDTO veiculoDTO) {
        Veiculo veiculo = findById(id);
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setPlacaDoVeiculo(veiculo.getPlacaDoVeiculo());
        veiculo.setAno(veiculo.getAno());
        veiculo.setOdometro(veiculo.getOdometro());
        return veiculoRepositories.save(veiculo);
    }

    public void delete (int idVeiculo) {
        findById(idVeiculo);
        try {
            veiculoRepositories.deleteById(idVeiculo);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Veiculo não encotrado!!!");
        }
    }
}
