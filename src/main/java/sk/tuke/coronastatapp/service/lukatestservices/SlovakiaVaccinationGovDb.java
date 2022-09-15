package sk.tuke.coronastatapp.service.lukatestservices;

import java.util.List;

public interface SlovakiaVaccinationGovDb {

    List<SlovakiaVaccinationGovDb> getAllSlovakiaVaccinations();

    int getNumberOfRows();
}
