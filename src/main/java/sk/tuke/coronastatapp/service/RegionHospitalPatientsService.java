package sk.tuke.coronastatapp.service;


import sk.tuke.coronastatapp.entity.RegionHospitalPatients;

import java.util.List;

public interface RegionHospitalPatientsService {

    void addRegionHospitalPatients(RegionHospitalPatients regionHospitalPatients);

    List<RegionHospitalPatients> getAllRegionHospitalPatients();

    void deleteAllRegionHospitalPatients();

}
