package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaVaccination;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaVaccinationServiceJPA implements SlovakiaVaccinationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaVaccination(SlovakiaVaccination slovakiaVaccination) {

        entityManager.persist(slovakiaVaccination);
    }

    @Override
    public List<SlovakiaVaccination> getAllSlovakiaVaccinations() {
        return entityManager.createQuery("select v from SlovakiaVaccination v").getResultList();
    }

    @Override
    public void deleteAllSlovakiaVaccinations() {
        entityManager.createNativeQuery("DELETE from slovakia_vaccination").executeUpdate();

    }
}
