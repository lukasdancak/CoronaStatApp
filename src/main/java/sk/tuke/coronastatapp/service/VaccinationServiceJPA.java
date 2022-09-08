package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Vaccination;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
public class VaccinationServiceJPA implements VaccinationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccination(Vaccination vaccination) {

        entityManager.persist(vaccination);
    }

    @Override
    public List<Vaccination> getAllVaccinations() {
        return entityManager.createQuery("select v from Vaccination v").getResultList();
    }
}
