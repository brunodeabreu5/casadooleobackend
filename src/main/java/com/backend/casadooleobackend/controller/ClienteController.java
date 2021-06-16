package com.backend.casadooleobackend.controller;

import com.backend.casadooleobackend.dto.ClienteDTO;
import com.backend.casadooleobackend.model.Cliente;
import com.backend.casadooleobackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<Cliente> findById (@PathVariable int idCliente) {
        Cliente obj = service.findById(idCliente);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll () {
        List<ClienteDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Cliente> create (@RequestBody Cliente obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idCliente}").
                buildAndExpand(obj.getIdCliente()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{idCliente}")// int para fazer a comparação se existe @requestBody e a requisição do corpo
    public ResponseEntity<ClienteDTO> update (@PathVariable int idCliente, @RequestBody ClienteDTO objDto) {
        Cliente newObj = service.update(idCliente, objDto);
        return ResponseEntity.ok().body(new ClienteDTO(newObj));
    }

    @DeleteMapping(value = "/{idCliente}")
    public ResponseEntity<Void> delete (@PathVariable int idCliente) {
        service.delete(idCliente);
        return ResponseEntity.noContent().build();
    }
}

