package sk.tuke.coronastatapp.service;


import sk.tuke.coronastatapp.entity.DistrictHospitalPatients;


import java.util.List;

public interface DistrictHospitalPatientsService {

    void addDistrictHospitalPatients(DistrictHospitalPatients DistrictHospitalPatients);

    void addRegionHospitalPatients(DistrictHospitalPatients districtHospitalPatients);

    List<DistrictHospitalPatients> getAllDistrictHospitalPatients();

    void deleteAllDistrictHospitalPatients();

}
