package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalServiceJPA implements HospitalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return entityManager.createQuery("select h from Hospital h").getResultList();
    }

    @Override
    public void deleteAllHospitals() {
        entityManager.createNativeQuery("DELETE from hospital").executeUpdate();
    }
}
