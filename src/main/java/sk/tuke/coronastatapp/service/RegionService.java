package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Region;

import java.util.List;

public interface RegionService {

    void addRegion(Region region);

    List<Region> getAllRegions();

    void deleteAllRegions();
}
