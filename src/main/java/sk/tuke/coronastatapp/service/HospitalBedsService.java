package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalBeds;

import java.util.List;

public interface HospitalBedsService {

    void addHospitalBeds(HospitalBeds hospitalBeds);

    List<HospitalBeds> getAllHospitalBeds();
}
