package com.citasmedicas.repository;

import com.citasmedicas.entities.Medico;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MedicoRepositoryImp implements MedicoRepository {
    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Medico> findAll() {
        String jpql = "select e from Medico e";
        return em.createQuery(jpql, Medico.class).getResultList();
    }

    @Override
    public Optional<Medico> findById(Long id) {
        return Optional.ofNullable(em.find(Medico.class, id));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Medico save(Medico medico) {
        em.persist(medico);
        return medico;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Medico> medicoOptional = findById(id);
        medicoOptional.ifPresent(medico -> em.remove(medico));
    }
}
