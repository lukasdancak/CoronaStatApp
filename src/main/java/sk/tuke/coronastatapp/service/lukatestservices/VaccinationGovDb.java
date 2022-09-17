package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.RegionVaccination;
import sk.tuke.coronastatapp.entity.Vaccination;

import java.util.List;

public interface VaccinationGovDb {

    List<Vaccination> getAllVaccinations();

    int getNumberOfRows();
}
