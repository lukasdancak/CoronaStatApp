package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictAgTests;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictAgTestsServiceJPA implements DistrictAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictAgTests(DistrictAgTests districtAgTests) {
        try {
            entityManager.createQuery("SELECT d FROM DistrictAgTests d WHERE d.id = :id")
                    .setParameter("id", districtAgTests.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(districtAgTests);
        }
    }

    @Override
    public List<DistrictAgTests> getAllDistrictAgTests() {
        return entityManager.createQuery("SELECT d FROM DistrictAgTests d").getResultList();
    }

    @Override
    public void deleteAllDistrictAgTests() {
        entityManager.createNativeQuery("DELETE FROM district_ag_tests").executeUpdate();
    }
}
