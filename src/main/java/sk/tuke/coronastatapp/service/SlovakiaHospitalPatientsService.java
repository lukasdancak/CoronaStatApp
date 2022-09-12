package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaHospitalPatients;

import java.util.List;

public interface SlovakiaHospitalPatientsService {

    void addSlovakiaHospitalPatients(SlovakiaHospitalPatients slovakiaHospitalPatients);

    List<SlovakiaHospitalPatients> getSlovakiaHospitalPatients();

    void deleteAllSlovakiaHospitalPatients();
}
