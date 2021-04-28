package com.example.casadooleobackend.model;


public class Cliente {

    private int idCliente;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private Veiculo veiculo;

    public Cliente () {
    }

    public Cliente (int idCliente, String nome, String endereco, String email, String telefone, Veiculo veiculo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.veiculo = veiculo;
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

    public Veiculo getVeiculo () {
        return veiculo;
    }

    public void setVeiculo (Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString () {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", veiculo=" + veiculo +
                '}';
    }
}
