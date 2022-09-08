package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaAgTestsServiceJPA implements SlovakiaAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaAgTests(SlovakiaAgTests slovakiaAgTests) {
        entityManager.persist(slovakiaAgTests);
    }

    @Override
    public List<SlovakiaAgTests> getAllSlovakiaAgTests() {
        return entityManager.createQuery("select s from SlovakiaAgTests s").getResultList();
    }

    @Override
    public void deleteAllSlovakiaAgTests() {
        entityManager.createNativeQuery("DELETE from slovakia_ag_tests").executeUpdate();
    }
}
