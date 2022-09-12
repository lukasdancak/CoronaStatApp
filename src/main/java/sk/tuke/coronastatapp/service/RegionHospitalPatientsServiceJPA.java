package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RegionHospitalPatientsServiceJPA implements RegionHospitalPatientsService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients) {
        entityManager.persist(regionHospitalPatients);
    }

    @Override
    public List<RegionHospitalPatients> getAllRegionHospitalPatients() {
        return entityManager.createQuery("select r from RegionHospitalPatients r").getResultList();
    }

    @Override
    public void deleteAllRegionHospitalPatients() {
        entityManager.createNativeQuery("DELETE from region_hospital_patients").executeUpdate();
    }
}
