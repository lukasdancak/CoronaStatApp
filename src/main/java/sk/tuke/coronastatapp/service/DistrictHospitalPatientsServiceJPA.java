package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictHospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalPatientsServiceJPA implements DistrictHospitalPatientsService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addDistrictHospitalPatients(DistrictHospitalPatients DistrictHospitalPatients) {

    }

    @Override
    public void addRegionHospitalPatients(DistrictHospitalPatients districtHospitalPatients) {

    }

    @Override
    public List<DistrictHospitalPatients> getAllDistrictHospitalPatients() {
        return null;
    }

    @Override
    public void deleteAllDistrictHospitalPatients() {

    }
}
