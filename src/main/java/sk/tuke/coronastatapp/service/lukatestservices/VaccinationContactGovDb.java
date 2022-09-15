package sk.tuke.coronastatapp.service.lukatestservices;

import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.util.List;

public interface VaccinationContactGovDb {


    List<VaccinationContact> getAllVaccinationContacts();

    int getNumberOfRows();
}
