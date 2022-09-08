package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionAgTestsServiceJPA implements RegionAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionAgTests(RegionAgTests regionAgTests) {
        entityManager.persist(regionAgTests);
    }

    @Override
    public List<RegionAgTests> getAllRegionAgTests() {
        return entityManager.createQuery("select r from RegionAgTests r").getResultList();
    }

    @Override
    public void deleteAllRegionAgTests() {
        entityManager.createNativeQuery("DELETE from region_ag_tests").executeUpdate();
    }
}
