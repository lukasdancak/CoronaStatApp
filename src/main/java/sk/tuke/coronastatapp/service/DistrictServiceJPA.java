package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.District;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictServiceJPA implements DistrictService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDictrict(District district) {
        try {
            entityManager.createQuery("SELECT d FROM District d WHERE d.id = :id")
                    .setParameter("id", district.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(district);
        }
    }

    @Override
    public List<District> getAllDistricts() {
        return entityManager.createQuery("SELECT d FROM District d").getResultList();
    }

    @Override
    public void deleteAllDistricts() {
        entityManager.createNativeQuery("DELETE FROM district").executeUpdate();
    }
}
