package sk.tuke.coronastatapp.service;


import sk.tuke.coronastatapp.entity.SlovakiaVaccination;

import java.util.List;

public interface SlovakiaVaccinationService {

    void addSlovakiaVaccination(SlovakiaVaccination slovakiaVaccination);

    List<SlovakiaVaccination> getAllSlovakiaVaccinations();

    void deleteAllSlovakiaVaccinations();
}
