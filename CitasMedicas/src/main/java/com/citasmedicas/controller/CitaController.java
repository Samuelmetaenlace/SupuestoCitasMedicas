package com.citasmedicas.controller;

import com.citasmedicas.entities.Cita;
import com.citasmedicas.repository.CitaRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/citas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitaController {

    @Inject
    CitaRepository repository;

    @GET
    public List<Cita> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Response findById(@PathParam("id") Long id){
        return repository.findById(id)
                .map(cita -> Response.ok(cita).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(Cita cita){
        repository.save(cita);
        return Response.ok(cita).status(Response.Status.CREATED).build();
    }


}
