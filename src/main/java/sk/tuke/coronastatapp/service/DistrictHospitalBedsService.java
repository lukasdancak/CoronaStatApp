package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictHospitalBeds;
import sk.tuke.coronastatapp.entity.HospitalBeds;
import sk.tuke.coronastatapp.entity.Vaccine;

import java.util.List;

public interface DistrictHospitalBedsService {
    void addDistrictHospitalBeds(DistrictHospitalBeds districtHospitalBeds);
    List<DistrictHospitalBeds> getAllDistrictHospitalBeds();

    void deleteAllDistrictHospitalBeds();


}
