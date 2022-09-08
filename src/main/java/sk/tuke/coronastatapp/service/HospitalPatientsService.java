package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalPatients;

import java.util.List;

public interface HospitalPatientsService {
    void addHospitalPatients(HospitalPatients hospitalPatientsService);

    List<HospitalPatients> getAllHospitalPatients();
}
