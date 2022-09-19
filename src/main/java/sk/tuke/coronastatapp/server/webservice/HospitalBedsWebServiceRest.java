package sk.tuke.coronastatapp.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.service.HospitalBedsService;
import sk.tuke.coronastatapp.entity.HospitalBeds;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-beds")
public class HospitalBedsWebServiceRest {
    @Autowired
    HospitalBedsService hospitalBedsService;

    @GetMapping
    public List<HospitalBeds> getAllHospitalBeds() {
        return hospitalBedsService.getAllHospitalBeds();
    }

}
