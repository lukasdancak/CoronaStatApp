package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Hospital;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalServiceJPA implements HospitalService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospital(Hospital hospital) {
        try {
            entityManager.createQuery("SELECT h FROM Hospital h WHERE h.id = :id")
                    .setParameter("id", hospital.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(hospital);
        }
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return entityManager.createQuery("SELECT h FROM Hospital h").getResultList();
    }

    @Override
    public void deleteAllHospitals() {
        entityManager.createNativeQuery("DELETE FROM hospital").executeUpdate();
    }
}
