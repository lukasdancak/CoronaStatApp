
package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.SlovakiaHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SlovakiaHospitalBedsServiceJPA implements SlovakiaHospitalBedsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSlovakiaHospitalBeds(SlovakiaHospitalBeds SlovakiaHospitalBeds) {
        entityManager.persist(SlovakiaHospitalBeds);
    }

    @Override
    public List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds() {
        return entityManager.createQuery("select hb from SlovakiaHospitalBeds hb").getResultList();
    }
    @Override
    public void deleteAllSlovakiaHospitalBeds () {{
        entityManager.createNativeQuery("DELETE FROM SlovakiaHospitalBeds").executeUpdate();}
    }

}
