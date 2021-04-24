package com.example.casadooleobackend.model;

public class Veiculo {

    private int idVeiculos;
    private String marca;
    private String modelo;
    private String placaDoVeiculo;
    private int ano;

    public Veiculo () {
    }

    public Veiculo (int idVeiculos, String marca, String modelo, String placaDoVeiculo, int ano) {
        this.idVeiculos = idVeiculos;
        this.marca = marca;
        this.modelo = modelo;
        this.placaDoVeiculo = placaDoVeiculo;
        this.ano = ano;
    }

    public int getIdVeiculos () {
        return idVeiculos;
    }

    public void setIdVeiculos (int idVeiculos) {
        this.idVeiculos = idVeiculos;
    }

    public String getMarca () {
        return marca;
    }

    public void setMarca (String marca) {
        this.marca = marca;
    }

    public String getModelo () {
        return this.modelo;
    }

    public void setModelo (String modelo) {
        this.modelo = modelo;
    }

    public String getPlacaDoVeiculo () {
        return placaDoVeiculo;
    }

    public void setPlacaDoVeiculo (String placaDoVeiculo) {
        this.placaDoVeiculo = placaDoVeiculo;
    }

    public int getAno () {
        return ano;
    }

    public void setAno (int ano) {
        this.ano = ano;
    }

    @Override
    public String toString () {
        return "Veiculos{" +
                "idVeiculos=" + idVeiculos +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placaDoVeiculo='" + placaDoVeiculo + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }

}
