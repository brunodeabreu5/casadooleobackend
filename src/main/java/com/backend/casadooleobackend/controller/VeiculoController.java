package com.backend.casadooleobackend.controller;

import com.backend.casadooleobackend.dto.VeiculoDTO;
import com.backend.casadooleobackend.model.Veiculo;
import com.backend.casadooleobackend.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(value = "/{idVeiculo}")
    public ResponseEntity<Veiculo> findById (@PathVariable int idVeiculo) {
        Veiculo veiculo = veiculoService.findById(idVeiculo);
        return ResponseEntity.ok().body(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> findAll () {
        List<VeiculoDTO> listVeiculo = veiculoService.findAll();
        return ResponseEntity.ok(listVeiculo);
    }

    @PostMapping
    public ResponseEntity<Veiculo> create (@RequestBody Veiculo veiculo) {
        veiculo = veiculoService.create(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCliente}")
                .buildAndExpand(veiculo.getIdVeiculo()).toUri();
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping(value = "/{IdVeiculo}")
    public ResponseEntity<VeiculoDTO> update (@PathVariable int idVeiculo, @RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoService.update(idVeiculo, veiculoDTO);
        return ResponseEntity.ok().body(new VeiculoDTO(veiculo));
    }

    @DeleteMapping(value = "/{idVeiculo}")
    public ResponseEntity<Void> delete (@PathVariable int idVeiculo) {
        veiculoService.delete(idVeiculo);
        return ResponseEntity.noContent().build();
    }
}

