package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Vaccine;

import java.util.List;

public interface VaccineService {

    void addVaccine(Vaccine vaccine);

    List<Vaccine> getVaccines();

    Vaccine getVaccineById(int vaccineId);

    void deleteAllVaccine();

}
