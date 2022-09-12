package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalStaff;

import java.util.List;

public interface HospitalStaffService {
    void addHospitalStaff(HospitalStaff hospitalStaff);

    List<HospitalStaff> getAllHospitalStaff();

    void deleteAllHospitalStaff();
}
