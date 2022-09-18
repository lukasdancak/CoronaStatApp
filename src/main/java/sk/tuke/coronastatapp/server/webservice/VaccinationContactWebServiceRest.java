package sk.tuke.coronastatapp.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.tuke.coronastatapp.entity.VaccinationContact;
import sk.tuke.coronastatapp.service.VaccinationContactService;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination/contacts")
public class VaccinationContactWebServiceRest {
    @Autowired
    VaccinationContactService vaccinationContactService;

    @GetMapping
    public List<VaccinationContact> getAllVaccinationContact() {
        return vaccinationContactService.getAllVaccinationContacts();
    }
}
