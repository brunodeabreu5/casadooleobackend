package com.backend.casadooleobackend.dto;

import com.backend.casadooleobackend.model.Cliente;
import com.backend.casadooleobackend.model.Veiculo;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final int serialVersionUID = 1;

    private int idCliente;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public ClienteDTO () {
    }

    public ClienteDTO (int idCliente, String nome, String endereco, String email, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public ClienteDTO (Cliente model) {
        idCliente = model.getIdCliente();
        nome = model.getNome();
        endereco = model.getEndereco();
        email = model.getEmail();
        email = model.getEmail();
    }



    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public String getEndereco () {
        return endereco;
    }

    public void setEndereco (String endereco) {
        this.endereco = endereco;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }
}
