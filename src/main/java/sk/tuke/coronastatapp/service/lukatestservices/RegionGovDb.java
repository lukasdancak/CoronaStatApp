package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.Region;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.util.List;

public interface RegionGovDb {

    List<Region> getAllRegions();

    int getNumberOfRows();
}
