package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Vaccination;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class VaccinationContactServiceJPA implements VaccinationContactService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVaccination(VaccinationContact vaccinationContact) {

    }

    @Override
    public List<VaccinationContact> getAllVaccinationContacts() {
        return null;
    }
}
