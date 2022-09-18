package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.HospitalStaff;
import sk.tuke.coronastatapp.service.HospitalStaffService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-staff")
public class HospitalStaffWebServiceRest {
    @Autowired
    HospitalStaffService hospitalStaffService;

    @GetMapping
    public List<HospitalStaff> getAllHospitalStaff() {

        return hospitalStaffService.getAllHospitalStaff();
    }
}
