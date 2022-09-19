package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.DistrictHospitalPatients;
import sk.tuke.coronastatapp.service.DistrictHospitalPatientsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-patients/by-district")
public class DistrictHospitalPatientsWebServiceRest {
    @Autowired
    DistrictHospitalPatientsService districtHospitalPatientsService;

    @GetMapping
    public List<DistrictHospitalPatients> getAllDistrictHospitalPatients(){
        return districtHospitalPatientsService.getAllDistrictHospitalPatients();
    }
}
