package com.backend.casadooleobackend.dto;

import com.backend.casadooleobackend.model.Veiculo;

import java.io.Serializable;

public class VeiculoDTO implements Serializable {

    private static final int serialVersionUID = 1;

    private int idVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String placaDoVeiculo;
    private int odometro;

    public VeiculoDTO () {
    }

    public VeiculoDTO (int idVeiculo, String placaDoVeiculo, String marca, String modelo, int ano, int odometro) {
        this.idVeiculo = idVeiculo;
        this.placaDoVeiculo = placaDoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.odometro = odometro;
    }

    public VeiculoDTO (Veiculo model) {
        idVeiculo = model.getIdVeiculo();
        marca = model.getMarca();
        modelo = model.getModelo();
        ano = model.getAno();
        odometro = model.getOdometro();
    }

    public static int getSerialVersionUID () {
        return serialVersionUID;
    }

    public int getIdVeiculo () {
        return idVeiculo;
    }

    public void setIdVeiculo (int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca () {
        return marca;
    }

    public void setMarca (String marca) {
        this.marca = marca;
    }

    public String getModelo () {
        return modelo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public int getAno () {
        return ano;
    }

    public void setAno (int ano) {
        this.ano = ano;
    }

    public String getPlacaDoVeiculo () {
        return placaDoVeiculo;
    }

    public void setPlacaDoVeiculo (String placaDoVeiculo) {
        this.placaDoVeiculo = placaDoVeiculo;
    }

    public int getOdometro () {
        return odometro;
    }

    public void setOdometro (int odometro) {
        this.odometro = odometro;
    }
}
