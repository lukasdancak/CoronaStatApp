package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.SlovakiaHospitalPatients;
import sk.tuke.coronastatapp.service.SlovakiaHospitalPatientsService;


import java.util.List;

@RestController
@RequestMapping("/api/hospital-patients/in-slovakia")
public class SlovakiaHospitalPatientsWebServiceRest {
    @Autowired
    SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;

    @GetMapping
    public List<SlovakiaHospitalPatients> getAllSLovakiaHospitalPatients() {
        return slovakiaHospitalPatientsService.getSlovakiaHospitalPatients();
    }
}
