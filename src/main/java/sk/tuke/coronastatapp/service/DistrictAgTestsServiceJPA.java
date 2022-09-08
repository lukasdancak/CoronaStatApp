package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictAgTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictAgTestsServiceJPA implements DistrictAgTestsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictAgTests(DistrictAgTests districtAgTests) {
        entityManager.persist(districtAgTests);
    }

    @Override
    public List<DistrictAgTests> getAllDistrictAgTests() {
        return entityManager.createQuery("select d from DistrictAgTests d").getResultList();
    }

    @Override
    public void deleteAllDistrictAgTests() {
        entityManager.createNativeQuery("DELETE from district_ag_tests").executeUpdate();
    }
}
