package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.util.List;

public interface VaccinationContactService {

    void addVaccination(VaccinationContact vaccinationContact);

    List<VaccinationContact> getAllVaccinationContacts();

    void deleteAllVaccinationContacts();
}
