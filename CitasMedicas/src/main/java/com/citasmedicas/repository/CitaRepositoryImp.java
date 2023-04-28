package com.citasmedicas.repository;

import com.citasmedicas.entities.Cita;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Default
@ApplicationScoped
public class CitaRepositoryImp implements CitaRepository{

    @PersistenceContext(unitName = "default")
    EntityManager em;

    @Override
    public List<Cita> findAll() {
        //CUIDADO AQUI SE COGE EL OBJETO
        String jpql = "select e from Cita e";
        return em.createQuery(jpql, Cita.class).getResultList();
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return Optional.ofNullable(em.find(Cita.class, id));
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Cita save(Cita cita) {
        em.persist(cita);
        return cita;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Cita> medicoOptional = findById(id);
        medicoOptional.ifPresent(cita -> em.remove(cita));

    }
}
