package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionAgTests;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionAgTestsServiceJPA implements RegionAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionAgTests(RegionAgTests regionAgTests) {
        try {
            entityManager.createQuery("SELECT r FROM RegionAgTests r WHERE r.id = :id")
                    .setParameter("id", regionAgTests.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(regionAgTests);
        }
    }

    @Override
    public List<RegionAgTests> getAllRegionAgTests() {
        return entityManager.createQuery("SELECT r FROM RegionAgTests r").getResultList();
    }

    @Override
    public void deleteAllRegionAgTests() {
        entityManager.createNativeQuery("DELETE FROM region_ag_tests").executeUpdate();
    }
}
