package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionVaccination;

import java.util.List;

public interface RegionVaccinationService {

    void addRegionVaccination(RegionVaccination vaccination);

    List<RegionVaccination> getAllRegionVaccinations();

    void deleteAllRegionVaccinations();
}
