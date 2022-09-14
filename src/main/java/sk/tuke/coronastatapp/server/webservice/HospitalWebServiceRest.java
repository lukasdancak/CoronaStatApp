package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.Hospital;
import sk.tuke.coronastatapp.service.HospitalService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalWebServiceRest {

    @Autowired
    private HospitalService hospitalService;

//    @PostMapping("/new")
//    public void addHospital(@RequestBody Hospital hospital) {
//        hospitalService.addHospital(hospital);
//    }

    @GetMapping
    public List<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }
}
