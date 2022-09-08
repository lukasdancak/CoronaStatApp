package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalPatientsServiceJPA implements HospitalPatientsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalPatients(HospitalPatients hospitalPatients) {
        entityManager.persist(hospitalPatients);
    }

    @Override
    public List<HospitalPatients> getAllHospitalPatients() {
        return entityManager.createQuery("select hp from HospitalPatients hp").getResultList();
    }
}
