package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CityServiceJPA implements CityService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCity(City city) {
        entityManager.persist(city);
    }

    @Override
    public List<City> getAllCities() {
        return entityManager.createQuery("select c from City c").getResultList();
    }

    @Override
    public void deleteAllCities() {
        entityManager.createNativeQuery("DELETE from city").executeUpdate();
    }
}
