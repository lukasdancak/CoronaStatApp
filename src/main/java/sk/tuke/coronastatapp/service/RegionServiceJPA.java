package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RegionServiceJPA implements RegionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRegion(Region region) {
        try {
            entityManager.createQuery("SELECT r FROM Region r WHERE r.id = :id")
                    .setParameter("id", region.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(region);
        }
    }

    @Override
    public List<Region> getAllRegions() {
        return entityManager.createQuery("SELECT r FROM Region r").getResultList();
    }

    @Override
    public void deleteAllRegions() {
        entityManager.createNativeQuery("DELETE FROM region").executeUpdate();
    }
}
