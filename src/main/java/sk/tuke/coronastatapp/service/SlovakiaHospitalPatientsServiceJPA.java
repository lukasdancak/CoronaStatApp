package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaHospitalPatientsServiceJPA implements SlovakiaHospitalPatientsService {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients) {
        entityManager.persist(slovakiaHospitalPatients);
    }

    @Override
    public List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients() {
        return entityManager.createQuery("select s from SlovakiaHospitalPatients s").getResultList();

    }

    @Override
    public void deleteAllSlovakiaHospitalPatients() {
        entityManager.createNativeQuery("DELETE from slovakia_hospital_patients").executeUpdate();

    }
}
