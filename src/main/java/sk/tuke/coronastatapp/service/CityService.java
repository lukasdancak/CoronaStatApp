package sk.tuke.coronastatapp.service;

import sk.tuke.coronastatapp.entity.City;

import java.util.List;

public interface CityService {

    void addCity(City city);

    List<City> getAllCities();

    void deleteAllCities();
}
