package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Vaccination;

import java.util.List;

public interface VaccinationService {
    void addVaccination(Vaccination vaccination);

    List<Vaccination> getAllVaccinations();

    void deleteAllVaccinations();
}
