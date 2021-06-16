package com.backend.casadooleobackend.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente () {

    }

    public int getIdCliente () {
        return idCliente;
    }

    public void setIdCliente (int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente (int idCliente, String nome, String endereco, String email, String telefone) {
        super();
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString () {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", veiculos=" + veiculos +
                '}';
    }
}
