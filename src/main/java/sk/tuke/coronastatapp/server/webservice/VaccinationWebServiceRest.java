package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.Vaccination;
import sk.tuke.coronastatapp.service.VaccinationService;


import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationWebServiceRest {
    @Autowired
    VaccinationService vaccinationService;

    @GetMapping
    public List<Vaccination> getAllVaccinations() {
        return vaccinationService.getAllVaccinations();
    }
}
