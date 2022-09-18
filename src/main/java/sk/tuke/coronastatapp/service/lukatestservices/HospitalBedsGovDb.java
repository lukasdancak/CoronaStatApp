package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.HospitalBeds;

import java.util.List;

public interface HospitalBedsGovDb {
    List<HospitalBeds> getAllHospitalBeds();
}
