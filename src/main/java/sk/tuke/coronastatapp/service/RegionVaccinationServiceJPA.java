package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionVaccination;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionVaccinationServiceJPA implements RegionVaccinationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionVaccination(RegionVaccination regionVaccination) {

        entityManager.persist(regionVaccination);
    }

    @Override
    public List<RegionVaccination> getAllRegionVaccinations() {
        return entityManager.createQuery("select r from RegionVaccination r").getResultList();
    }

    @Override
    public void deleteAllRegionVaccinations() {
        entityManager.createNativeQuery("DELETE from region_vaccination").executeUpdate();

    }
}
