package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.RegionVaccination;
import sk.tuke.coronastatapp.service.RegionVaccinationService;


import java.util.List;

@RestController
@RequestMapping("/api/vaccinations/by-region")
public class RegionVaccinationWebServiceRest {
    @Autowired
    RegionVaccinationService regionVaccinationService;

    @GetMapping
    public List<RegionVaccination> getAllRegionVaccinations() {
        return regionVaccinationService.getAllRegionVaccinations();
    }
}
