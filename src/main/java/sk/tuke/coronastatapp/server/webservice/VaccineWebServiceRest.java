package sk.tuke.coronastatapp.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.Vaccine;
import sk.tuke.coronastatapp.service.VaccineService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineWebServiceRest {
    @Autowired
    VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> getAllVaccines(){
        return vaccineService.getVaccines();
    }

}
