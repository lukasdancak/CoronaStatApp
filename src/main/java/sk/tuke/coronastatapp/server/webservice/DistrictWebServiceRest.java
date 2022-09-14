package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.District;
import sk.tuke.coronastatapp.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictWebServiceRest {

    @Autowired
    private DistrictService districtService;

//    @PostMapping("/new")
//    public void addDistrict(@RequestBody District district) {
//        districtService.addDistrict(district);
//    }

    @GetMapping
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }
}
