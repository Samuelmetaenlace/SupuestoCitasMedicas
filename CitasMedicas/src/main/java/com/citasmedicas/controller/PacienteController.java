package com.citasmedicas.controller;

import com.citasmedicas.entities.Paciente;
import com.citasmedicas.repository.PacienteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/pacientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PacienteController {

    @Inject
    PacienteRepository repository;

    @GET
    public List<Paciente> findAll() {
        return repository.findAll();
    }

    @Path("{id}")
    @GET
    public Response findById(@PathParam("id") Long id){
        return repository.findById(id)
                .map(paciente -> Response.ok(paciente).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    public Response create(Paciente paciente){
        repository.save(paciente);
        return Response.ok(paciente).status(Response.Status.CREATED).build();
    }

    @Path("{id}")
    @PUT
    public Response update(Paciente paciente, @PathParam("id") Long id){
        Optional<Paciente> pacienteOpcional = repository.findById(id);

        if(pacienteOpcional.isPresent()){
            Paciente pacienteExistente = pacienteOpcional.get();
            pacienteExistente.setDireccion(paciente.getDireccion());
            pacienteExistente.setNSS(paciente.getNSS());
            pacienteExistente.setTelefono(paciente.getTelefono());
            pacienteExistente.setNumTarjeta(paciente.getNumTarjeta());
            repository.save(pacienteExistente);
            return Response.ok(paciente).status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Path("{id}")
    @DELETE
    public Response delete( @PathParam("id") Long id) {
        try {
            repository.deleteById(id);
            return Response.ok().status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
