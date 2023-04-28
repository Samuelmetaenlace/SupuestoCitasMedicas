package com.citasmedicas.repository;

import com.citasmedicas.entities.Diagnostico;


import java.util.List;
import java.util.Optional;

public interface DiagnosticoRepository {

    List<Diagnostico> findAll();
    Optional<Diagnostico> findById(Long id);
    Diagnostico save(Diagnostico diagnostico);

    void deleteById(Long id);

}
