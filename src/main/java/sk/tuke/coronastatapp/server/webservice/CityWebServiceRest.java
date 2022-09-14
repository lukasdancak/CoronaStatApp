package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.City;
import sk.tuke.coronastatapp.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityWebServiceRest {

    @Autowired
    private CityService cityService;

    @PostMapping("/new")
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }
}
