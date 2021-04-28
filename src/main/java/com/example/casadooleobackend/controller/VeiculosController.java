package com.example.casadooleobackend.controller;

import com.example.casadooleobackend.dao.ClienteDao;
import com.example.casadooleobackend.dao.VeiculoDao;
import com.example.casadooleobackend.model.Veiculo;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("veiculo")
public class VeiculosController {

    @GET
    @Path("criartabela")
    @Produces("application/json")
    public Response criaTabelaVeiculo () {
        VeiculoDao veiculoDao = new VeiculoDao();
        veiculoDao.criaTabelaVeiculo();
        return Response.ok(new Gson().toJson("Tabela criada com sucesso!")).build();
    }

    @GET
    @Produces("application/json")
    public Response listaVeiculos () {
        VeiculoDao veiculoDao = new VeiculoDao();
        List<Veiculo> veiculos = veiculoDao.listaDeVeiculos();
        return Response.ok(new Gson().toJson(veiculos)).build();
    }

    @GET
    @Path("{idVeiculo}")
    @Produces("application/json")
    public Response getIdVeiculos (@PathParam("idVeiculo") int id) {
        VeiculoDao veiculoDao = new VeiculoDao();
        Veiculo veiculo = veiculoDao.consultaVeiculoPorId(id);
        return Response.ok(new Gson().toJson(veiculo)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarVeiculo (Veiculo veiculo) {
        VeiculoDao veiculoDao = new VeiculoDao();
        veiculoDao.cadastraVeiculo(veiculo);
        return Response.ok(new Gson().toJson("Cadastrado!!!" + veiculo)).build();
    }

    @PUT
    @Path("editar/{idVeiculo}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response modificaVeiculo (Veiculo veiculo, @PathParam("idVeiculo") int id) {
        VeiculoDao veiculoDao = new VeiculoDao();
        if (veiculoDao.consultaVeiculoPorId(id) != null) {
            Veiculo result = veiculoDao.alteraVeiculo(veiculo, id);
            return Response.ok(new Gson().toJson(result)).build();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("{idVeiculo}")
    @Produces("application/json")
    public Response deletarVeiculo (Veiculo veiculo, @PathParam("idVeiculo") int id) {
        VeiculoDao veiculoDao = new VeiculoDao();
        veiculoDao.removeVeiculo(id);
        return Response.ok("Removido com sucesso!!!").build();
    }
}
