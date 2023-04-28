package com.citasmedicas.repository;

import com.citasmedicas.entities.Paciente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PacienteRepositoryImp implements PacienteRepository {

    @PersistenceContext(unitName = "default")
    EntityManager em;
    @Override
    public List<Paciente> findAll() {
        String jpql = "select e from Paciente e";
        return em.createQuery(jpql, Paciente.class).getResultList();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return Optional.ofNullable(em.find(Paciente.class, id));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Paciente save(Paciente paciente) {
        em.persist(paciente);
        return paciente;
    }


    @Override
    public void deleteById(Long id) {
        Optional<Paciente> pacienteOptional = findById(id);
        pacienteOptional.ifPresent(paciente -> em.remove(paciente));
    }


}
