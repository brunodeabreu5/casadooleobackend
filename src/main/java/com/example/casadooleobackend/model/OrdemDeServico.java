package com.example.casadooleobackend.model;

public class OrdemDeServico {

    private int idOrdemDeServico;
    private String tipoDeServico;
    private double valor;
    private int dia;
    private String descricao;

    public OrdemDeServico () {
    }

    public OrdemDeServico (int idOrdemDeServico, String tipoDeServico, double valor, int dia, String descricao) {
        this.idOrdemDeServico = idOrdemDeServico;
        this.tipoDeServico = tipoDeServico;
        this.valor = valor;
        this.dia = dia;
        this.descricao = descricao;
    }

    public int getIdOrdemDeServico () {
        return idOrdemDeServico;
    }

    public void setIdOrdemDeServico (int idOrdemDeServico) {
        this.idOrdemDeServico = idOrdemDeServico;
    }

    public String getTipoDeServico () {
        return tipoDeServico;
    }

    public void setTipoDeServico (String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public double getValor () {
        return valor;
    }

    public void setValor (double valor) {
        this.valor = valor;
    }

    public int getDia () {
        return dia;
    }

    public void setDia (int dia) {
        this.dia = dia;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString () {
        return "OrdemDeServico{" +
                "idOrdemDeServico=" + idOrdemDeServico +
                ", tipoDeServico='" + tipoDeServico + '\'' +
                ", valor=" + valor +
                ", dia=" + dia +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
