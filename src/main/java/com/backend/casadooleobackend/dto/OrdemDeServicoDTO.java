package com.backend.casadooleobackend.dto;

import com.backend.casadooleobackend.model.OrdemDeServico;
import org.springframework.ui.Model;

import java.io.Serializable;

public class OrdemDeServicoDTO implements Serializable {

    private static final int serialVersionUID = 1;

    private int idOrdem;
    private String NomeCliente;
    private String tipoDoServico;
    private long valor;
    private String descricao;

    public OrdemDeServicoDTO(){}

    public OrdemDeServicoDTO (int idOrdem, String nomeCliente, String tipoDoServico, long valor, String descricao) {
        this.idOrdem = idOrdem;
        NomeCliente = nomeCliente;
        this.tipoDoServico = tipoDoServico;
        this.valor = valor;
        this.descricao = descricao;
    }

    public OrdemDeServicoDTO(OrdemDeServico model){
        idOrdem = model.getIdOrdem();
        NomeCliente = model.getNomeCliente();
        tipoDoServico = model.getTipoDoServico();
        valor = model.getValor();
        descricao = model.getDescricao();
    }

    public static int getSerialVersionUID () {
        return serialVersionUID;
    }

    public int getIdOrdem () {
        return idOrdem;
    }

    public void setIdOrdem (int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public String getNomeCliente () {
        return NomeCliente;
    }

    public void setNomeCliente (String nomeCliente) {
        NomeCliente = nomeCliente;
    }

    public String getTipoDoServico () {
        return tipoDoServico;
    }

    public void setTipoDoServico (String tipoDoServico) {
        this.tipoDoServico = tipoDoServico;
    }

    public long getValor () {
        return valor;
    }

    public void setValor (long valor) {
        this.valor = valor;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }
}
