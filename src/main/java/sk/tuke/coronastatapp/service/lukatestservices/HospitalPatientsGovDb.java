package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.HospitalPatients;

import java.util.List;

public interface HospitalPatientsGovDb {
    List<HospitalPatients> getAllHospitalPatients();

}
