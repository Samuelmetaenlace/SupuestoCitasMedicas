package com.citasmedicas.repository;

import com.citasmedicas.entities.Cita;
import java.util.List;
import java.util.Optional;

public interface CitaRepository {

    List<Cita> findAll();
    Optional<Cita> findById(Long id);
    Cita save(Cita cita);

    void deleteById(Long id);

}
