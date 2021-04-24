package com.example.casadooleobackend.controller;

import com.example.casadooleobackend.dao.VeiculosDao;
import com.example.casadooleobackend.model.Veiculo;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("veiculo")
public class VeiculosController {
    @GET
    @Produces("application/json")
    public Response listaVeiculos () {
        VeiculosDao veiculosDao = new VeiculosDao();
        List<Veiculo> veiculos = veiculosDao.listaDeVeiculos();
        return Response.ok(new Gson().toJson(veiculos)).build();
    }

    @GET
    @Path("{idVeiculo}")
    @Produces("application/json")
    public Response getIdVeiculos (@PathParam("idVeiculo") int id) {
        VeiculosDao veiculosDao = new VeiculosDao();
        Veiculo veiculo = veiculosDao.consultaVeiculoPorId(id);
        return Response.ok(new Gson().toJson(veiculo)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarVeiculo (Veiculo veiculo) {
        VeiculosDao veiculosDao = new VeiculosDao();
        veiculosDao.cadastraVeiculo(veiculo);
        return Response.ok(new Gson().toJson("Cadastrado!!!"+veiculo)).build();
    }

    @PUT
    @Path("editar/{idVeiculo}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response modificaVeiculo (Veiculo veiculo, @PathParam("idVeiculo") int id) {
        VeiculosDao veiculosDao = new VeiculosDao();
        if (veiculosDao.consultaVeiculoPorId(id) != null) {
            Veiculo result = veiculosDao.alteraVeiculo(veiculo, id);
            return Response.ok(new Gson().toJson(result)).build();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("{idVeiculo}")
    @Produces("application/json")
    public Response deletarVeiculo (Veiculo veiculo, @PathParam("idVeiculo") int id) {
        VeiculosDao veiculosDao = new VeiculosDao();
        veiculosDao.removeVeiculo(id);
        return Response.ok("removido com sucesso!!!").build();
    }
}
