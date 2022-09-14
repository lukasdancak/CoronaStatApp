package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.DistrictAgTests;
import sk.tuke.coronastatapp.service.DistrictAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/ag-tests/by-district")
public class DistrictAgTestsWebServiceRest {

    @Autowired
    private DistrictAgTestsService districtAgTestsService;

    @PostMapping("/new")
    public void addDistrictAgTests(@RequestBody DistrictAgTests districtAgTests) {
        districtAgTestsService.addDistrictAgTests(districtAgTests);
    }

    @GetMapping
    public List<DistrictAgTests> getAllDistrictAgTests() {
        return districtAgTestsService.getAllDistrictAgTests();
    }
}
