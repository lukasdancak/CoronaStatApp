package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.DistrictHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DistrictHospitalBedsServiceJPA implements DistrictHospitalBedsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addDistrictHospitalBeds(DistrictHospitalBeds DistrictHospitalBeds) {
        entityManager.persist(DistrictHospitalBeds);
    }

    @Override
    public List<DistrictHospitalBeds> getAllDistrictHospitalBeds() {
        return entityManager.createQuery("select dhb from DistrictHospitalBeds dhb").getResultList();
    }
    @Override
    public void deleteAllDistrictHospitalBeds () {{
        entityManager.createNativeQuery("DELETE FROM DistrictHospitalBeds").executeUpdate();}
    }

}
