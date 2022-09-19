package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.SlovakiaHospitalBeds;
import sk.tuke.coronastatapp.service.SlovakiaHospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-beds/in-slovakia")
public class SlovakiaHospitalBedsWebServiceRest {
    @Autowired
    SlovakiaHospitalBedsService slovakiaHospitalBedsService;

    @GetMapping
    public List<SlovakiaHospitalBeds> getAllSlovakiaHospitalBeds(){
        return slovakiaHospitalBedsService.getAllSlovakiaHospitalBeds();
    }
}
