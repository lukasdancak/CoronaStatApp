package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.City;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CityServiceJPA implements CityService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCity(City city) {
        try {
            entityManager.createQuery("SELECT c FROM City c WHERE c.id = :id")
                    .setParameter("id", city.getId())
                    .getSingleResult();
            System.out.println("Record with this ID already exists in DB!");
        } catch (NoResultException e) {
            entityManager.persist(city);
        }
    }

    @Override
    public List<City> getAllCities() {
        return entityManager.createQuery("SELECT c FROM City c").getResultList();
    }

    @Override
    public void deleteAllCities() {
        entityManager.createNativeQuery("DELETE FROM city").executeUpdate();
    }
}
