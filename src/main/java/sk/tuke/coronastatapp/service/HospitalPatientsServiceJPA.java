
package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.HospitalPatients;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HospitalPatientsServiceJPA implements HospitalPatientsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHospitalPatients(HospitalPatients HospitalPatients) {
        entityManager.persist(HospitalPatients);
    }

    @Override
    public List<HospitalPatients> getAllHospitalPatients() {
        return entityManager.createQuery("select hb from HospitalPatients hb").getResultList();
    }
    @Override
    public void deleteAllHospitalPatients () {{
        entityManager.createNativeQuery("DELETE FROM HospitalPatients").executeUpdate();}
    }

}
