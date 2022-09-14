package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaHospitalBeds;

import java.util.List;

public interface SlovakiaHospitalBedsService {

    void addSlovakiaHospitalBeds(SlovakiaHospitalBeds SlovakiaHospitalBeds);

    List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds();

    void deleteAllSlovakiaHospitalBeds();
}
