package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionHospitalBeds;

import java.util.List;

public interface RegionHospitalBedsService {

    void addRegionHospitalBeds(RegionHospitalBeds RegionHospitalBeds);

    List<RegionHospitalBeds> getAllRegionHospitalBeds();

    void deleteAllRegionHospitalBeds();
}
