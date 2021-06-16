package com.backend.casadooleobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVeiculo;
    private String placaDoVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private int odometro;

    //jsonIgnore ele vai iquinora a cateria cliente para não fica em loop
    @JsonIgnore
    //ManyTOne muitos para 1
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Cliente cliente;

    public Veiculo () {
    }

    /*This e para acessa o valor da variavel*/
    public Veiculo (int idVeiculo, String marca, String modelo, String placaDoVeiculo, int ano, int odometro, Cliente cliente) {
        this.idVeiculo = idVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.placaDoVeiculo = placaDoVeiculo;
        this.ano = ano;
        this.odometro = odometro;
        this.cliente = cliente;
    }

    @Override
    public String toString () {
        return "Veiculo{" +
                "idVeiculo=" + idVeiculo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placaDoVeiculo='" + placaDoVeiculo + '\'' +
                ", ano=" + ano +
                ", odometro=" + odometro +
                ", cliente=" + cliente +
                '}';
    }
}
