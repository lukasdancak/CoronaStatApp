package sk.tuke.coronastatapp.service;


import sk.tuke.coronastatapp.entity.Vaccine;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccineServiceJPA implements VaccineService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccine(Vaccine vaccine) {
        entityManager.persist(vaccine);
    }

    @Override
    public List<Vaccine> getVaccines() {
        return entityManager.createQuery("select v from Vaccine v").getResultList();
    }

    @Override
    public Vaccine getVaccineById(int vaccineId) {
        return (Vaccine) entityManager.createQuery("select v from Vaccine v where v.id = :vacid")
                .setParameter("vacid", vaccineId)
                .getSingleResult();
    }
}
