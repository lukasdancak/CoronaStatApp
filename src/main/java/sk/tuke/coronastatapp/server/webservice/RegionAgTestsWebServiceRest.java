package sk.tuke.coronastatapp.server.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.RegionAgTests;
import sk.tuke.coronastatapp.service.RegionAgTestsService;

import java.util.List;

@RestController
@RequestMapping("/api/ag-tests/by-region")
public class RegionAgTestsWebServiceRest {

    @Autowired
    private RegionAgTestsService regionAgTestsService;

//    @PostMapping("/new")
//    public void addRegionAgTests(@RequestBody RegionAgTests regionAgTests) {
//        regionAgTestsService.addRegionAgTests(regionAgTests);
//    }

    @GetMapping
    public List<RegionAgTests> getAllRegionAgTests() {
        return regionAgTestsService.getAllRegionAgTests();
    }
}
