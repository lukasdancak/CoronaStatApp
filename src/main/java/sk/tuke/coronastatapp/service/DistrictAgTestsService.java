package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictAgTests;

import java.util.List;

public interface DistrictAgTestsService {

    void addDistrictAgTests(DistrictAgTests districtAgTests);

    List<DistrictAgTests> getAllDistrictAgTests();

    void deleteAllDistrictAgTests();
}
