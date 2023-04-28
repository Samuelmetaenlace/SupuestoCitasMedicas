package com.citasmedicas.controller;

import com.citasmedicas.entities.Diagnostico;
import com.citasmedicas.repository.DiagnosticoRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/diagnosticos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DiagnosticoController {

    @Inject
    DiagnosticoRepository repository;

    @GET
    public List<Diagnostico> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Response findById(@PathParam("id") Long id){
        return repository.findById(id)
                .map(diagnostico -> Response.ok(diagnostico).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(Diagnostico diagnostico){
        repository.save(diagnostico);
        return Response.ok(diagnostico).status(Response.Status.CREATED).build();
    }


}
