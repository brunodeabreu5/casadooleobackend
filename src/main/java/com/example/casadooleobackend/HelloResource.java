package com.example.casadooleobackend;

import com.example.casadooleobackend.model.Veiculo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("Aplication/json")
    public Veiculo hello () {
        Veiculo veiculo = new Veiculo(1,"BMW","m5","gfj34",202);
        veiculo.getIdVeiculos();
        veiculo.getMarca();
        return veiculo;
    }
    @GET
    @Produces("text/plain")
    public String Bruno(){

        return "Abreu";
    }
}