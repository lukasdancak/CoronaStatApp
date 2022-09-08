package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Hospital;

import java.util.List;

public interface HospitalService {

    void addHospital(Hospital hospital);

    List<Hospital> getAllHospitals();

    void deleteAllHospitals();
}
