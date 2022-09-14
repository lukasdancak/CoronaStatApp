
package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.RegionHospitalBeds;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionHospitalBedsServiceJPA implements RegionHospitalBedsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegionHospitalBeds(RegionHospitalBeds RegionHospitalBeds) {
        entityManager.persist(RegionHospitalBeds);
    }

    @Override
    public List<RegionHospitalBeds> getAllRegionHospitalBeds() {
        return entityManager.createQuery("select rhb from RegionHospitalBeds rhb").getResultList();
    }
    @Override
    public void deleteAllRegionHospitalBeds () {{
        entityManager.createNativeQuery("DELETE FROM RegionHospitalBeds").executeUpdate();}
    }

}
