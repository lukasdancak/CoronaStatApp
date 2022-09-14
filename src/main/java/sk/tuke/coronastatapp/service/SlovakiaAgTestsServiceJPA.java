package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaAgTests;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaAgTestsServiceJPA implements SlovakiaAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaAgTests(SlovakiaAgTests slovakiaAgTests) {
        try {
            entityManager.createQuery("SELECT s FROM SlovakiaAgTests s WHERE s.id = :id")
                    .setParameter("id", slovakiaAgTests.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(slovakiaAgTests);
        }
    }

    @Override
    public List<SlovakiaAgTests> getAllSlovakiaAgTests() {
        return entityManager.createQuery("SELECT s FROM SlovakiaAgTests s").getResultList();
    }

    @Override
    public void deleteAllSlovakiaAgTests() {
        entityManager.createNativeQuery("DELETE FROM slovakia_ag_tests").executeUpdate();
    }
}
