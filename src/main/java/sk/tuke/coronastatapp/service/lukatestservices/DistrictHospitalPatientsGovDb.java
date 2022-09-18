package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.DistrictHospitalPatients;

import java.util.List;

public interface DistrictHospitalPatientsGovDb {
    List<DistrictHospitalPatients> getAllDistrictHospitalPatients();

}
