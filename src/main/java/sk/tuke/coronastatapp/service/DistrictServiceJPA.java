package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictServiceJPA implements DistrictService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDictrict(District district) {
        entityManager.persist(district);
    }

    @Override
    public List<District> getAllDistricts() {
        return entityManager.createQuery("select d from District d").getResultList();
    }

    @Override
    public void deleteAllDistricts() {
        entityManager.createNativeQuery("DELETE from district").executeUpdate();
    }
}
