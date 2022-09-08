package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionAgTests;

import java.util.List;

public interface RegionAgTestsService {

    void addRegionAgTests(RegionAgTests regionAgTests);

    List<RegionAgTests> getAllRegionAgTests();

    void deleteAllRegionAgTests();
}
