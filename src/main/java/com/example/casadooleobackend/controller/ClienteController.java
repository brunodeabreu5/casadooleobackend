package com.example.casadooleobackend.controller;

import com.example.casadooleobackend.model.Cliente;
import com.example.casadooleobackend.dao.ClienteDao;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cliente")
public class ClienteController {

    @GET
    @Path("criartabela")
    @Produces("application/json")
    public Response criaTabelaFilme () {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.criaTabelaCliente();
        return Response.ok(new Gson().toJson("Tabela criada com sucesso!")).build();
    }

    @GET
    @Produces("application/json")
    public Response listaCliente () {
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> clienteList = clienteDao.listaDeCliente();
        return Response.ok(new Gson().toJson(clienteList)).build();
    }

    @GET
    @Path("{idCliente}")
    @Produces("application/json")
    public Response getIdCliente (@PathParam("idCliente") int id) {
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = clienteDao.consultaClientePorId(id);
        return Response.ok(new Gson().toJson(cliente)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarCliente (Cliente cliente) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.cadastraCliente(cliente);
        return Response.ok(new Gson().toJson("Cadastrado!!!")).build();
    }

    @PUT
    @Path("editar/{idCliente}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response modificaCliente (Cliente cliente, @PathParam("idCliente") int id) {
        ClienteDao clienteDao = new ClienteDao();
        if (clienteDao.consultaClientePorId(id) != null) {
            Cliente result = clienteDao.alteraCliente(cliente, id);
            return Response.ok(new Gson().toJson(result)).build();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("{idCliente}")
    @Produces("application/json")
    public Response deletarCliente (Cliente cliente, @PathParam("idCliente") int id) {
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.removeCliente(id);
        return Response.ok("removido com sucesso!!!").build();
    }


}
