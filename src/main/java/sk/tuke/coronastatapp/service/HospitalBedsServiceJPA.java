package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalBedsServiceJPA implements HospitalBedsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalBeds(HospitalBeds hospitalBeds) {
        entityManager.persist(hospitalBeds);
    }

    @Override
    public List<HospitalBeds> getAllHospitalBeds() {
        return entityManager.createQuery("select hb from HospitalBeds hb").getResultList();
    }
    @Override
    public void deleteAllHospitalBeds () {{
    entityManager.createNativeQuery("DELETE FROM hospitalBeds").executeUpdate();}
    }

}
