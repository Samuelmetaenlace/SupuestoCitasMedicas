package com.citasmedicas.repository;

import com.citasmedicas.entities.Medico;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository {

    List<Medico> findAll();
    Optional<Medico> findById(Long id);
    Medico save(Medico medico);

    void deleteById(Long id);

}
