package sk.tuke.coronastatapp.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.DistrictHospitalBeds;
import sk.tuke.coronastatapp.service.DistrictHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-beds/by-district")
public class DistrictHospitalBedsWebServiceRest {
    @Autowired
    DistrictHospitalBedsService districtHospitalBedsService;

    @GetMapping
    public List<DistrictHospitalBeds> getAllDistrictHospitalBeds() {
        return districtHospitalBedsService.getAllDistrictHospitalBeds();
    }
}
