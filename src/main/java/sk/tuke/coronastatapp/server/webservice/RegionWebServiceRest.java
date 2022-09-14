package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.tuke.coronastatapp.entity.Region;
import sk.tuke.coronastatapp.service.RegionService;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionWebServiceRest {

    @Autowired
    private RegionService regionService;

    @PostMapping("/new")
    public void addRegion(@RequestBody Region region) {
        regionService.addRegion(region);
    }

    @GetMapping
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }
}
