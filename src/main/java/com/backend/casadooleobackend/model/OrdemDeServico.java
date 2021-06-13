package com.backend.casadooleobackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ordem_de_servico")
public class OrdemDeServico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrdem;
    private String NomeCliente;
    private String tipoDoServico;
    private long valor;
    private String descricao;

    public OrdemDeServico () {
    }

    public OrdemDeServico (int idOrdem, String nomeCliente, String tipoDoServico, long valor, String descricao) {
        this.idOrdem = idOrdem;
        NomeCliente = nomeCliente;
        this.tipoDoServico = tipoDoServico;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString () {
        return "OrdemDeServico{" +
                "idOrdem=" + idOrdem +
                ", NomeCliente='" + NomeCliente + '\'' +
                ", tipoDoServico='" + tipoDoServico + '\'' +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}