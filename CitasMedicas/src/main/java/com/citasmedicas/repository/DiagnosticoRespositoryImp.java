package com.citasmedicas.repository;

import com.citasmedicas.entities.Diagnostico;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class DiagnosticoRespositoryImp implements DiagnosticoRepository {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Diagnostico> findAll() {
        String jpql = "select e from Diagnostico e";
        return em.createQuery(jpql, Diagnostico.class).getResultList();
    }

    @Override
    public Optional<Diagnostico> findById(Long id) {
        return Optional.ofNullable(em.find(Diagnostico.class, id));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Diagnostico save(Diagnostico diagnostico) {
        em.persist(diagnostico);
        return diagnostico;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Diagnostico> medicoOptional = findById(id);
        medicoOptional.ifPresent(diagnostico -> em.remove(diagnostico));
    }
}
