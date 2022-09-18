package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.RegionHospitalPatients;
import sk.tuke.coronastatapp.service.RegionHospitalPatientsService;


import java.util.List;

@RestController
@RequestMapping("/api/hospital-patients/by-region")
public class RegionHospitalPatientsWebServiceRest {
    @Autowired
    RegionHospitalPatientsService regionHospitalPatientsService;

    @GetMapping
    public List<RegionHospitalPatients> getAllRegionHospitalPatients() {
        return regionHospitalPatientsService.getAllRegionHospitalPatients();
    }
}
