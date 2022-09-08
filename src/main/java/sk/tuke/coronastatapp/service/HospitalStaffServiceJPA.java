package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalStaff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalStaffServiceJPA implements HospitalStaffService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalStaff(HospitalStaff hospitalStaff) {
        entityManager.persist(hospitalStaff);
    }

    @Override
    public List<HospitalStaff> getAllHospitalStaff() {
        return entityManager.createQuery("select s from Staff s").getResultList();
    }
}
