package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.District;

import java.util.List;

public interface DistrictService {

    void addDistrict(District district);

    List<District> getAllDistricts();

    void deleteAllDistricts();
}
