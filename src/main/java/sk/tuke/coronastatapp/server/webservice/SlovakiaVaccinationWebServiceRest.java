package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.SlovakiaVaccination;
import sk.tuke.coronastatapp.service.SlovakiaVaccinationService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccinations/in-slovakia")
public class SlovakiaVaccinationWebServiceRest {
    @Autowired
    SlovakiaVaccinationService slovakiaVaccinationService;

    @GetMapping
    public List<SlovakiaVaccination> getAllSlovakiaVaccinations() {
        return slovakiaVaccinationService.getAllSlovakiaVaccinations();
    }
}
