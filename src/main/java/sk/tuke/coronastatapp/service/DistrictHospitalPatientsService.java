package sk.tuke.coronastatapp.service;


import sk.tuke.coronastatapp.entity.DistrictHospitalPatients;
import sk.tuke.coronastatapp.entity.RegionHospitalPatients;

import java.util.List;

public interface DistrictHospitalPatientsService {

    void addRegionHospitalPatients(DistrictHospitalPatients districtHospitalPatients);

    List<DistrictHospitalPatients> getAllDistrictHospitalPatients();

    void deleteAllDistrictHospitalPatients();

}
