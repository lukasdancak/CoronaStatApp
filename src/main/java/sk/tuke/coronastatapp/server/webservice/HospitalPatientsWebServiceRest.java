package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.HospitalPatients;
import sk.tuke.coronastatapp.service.HospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-patients")
public class HospitalPatientsWebServiceRest {
    @Autowired
    HospitalPatientsService hospitalPatientsService;

    @GetMapping
    public List <HospitalPatients> getAllHospitalPatients(){
        return hospitalPatientsService.getAllHospitalPatients();
    }

}
