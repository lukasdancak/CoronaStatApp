package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.RegionVaccination;


import java.util.List;

public interface RegionVaccinationGovDb {

    List<RegionVaccination> getAllRegionVaccinations();

    int getNumberOfRows();
}
