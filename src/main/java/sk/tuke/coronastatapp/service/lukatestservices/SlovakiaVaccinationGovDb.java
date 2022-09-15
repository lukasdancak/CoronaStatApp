package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.SlovakiaVaccination;

import java.util.List;

public interface SlovakiaVaccinationGovDb {

    List<SlovakiaVaccination> getAllSlovakiaVaccinations();

    int getNumberOfRows();
}
