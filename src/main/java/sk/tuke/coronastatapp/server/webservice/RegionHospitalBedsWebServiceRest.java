package sk.tuke.coronastatapp.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.RegionHospitalBeds;
import sk.tuke.coronastatapp.service.RegionHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-beds/by-region")
public class RegionHospitalBedsWebServiceRest {
    @Autowired
    RegionHospitalBedsService regionHospitalBedsService;

    @GetMapping
    public List<RegionHospitalBeds> getAllRegionHospitalBeds(){
       return regionHospitalBedsService.getAllRegionHospitalBeds();
    }

}
