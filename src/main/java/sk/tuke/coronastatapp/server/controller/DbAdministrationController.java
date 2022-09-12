package sk.tuke.coronastatapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.coronastatapp.service.VaccinationContactService;

@Controller
//@Scope(WebApplicationContext.SCOPE_SESSION)
public class DbAdministrationController {

    @Autowired
    VaccinationContactService vaccinationContactService;


    @RequestMapping("/dbadministration")
    public String dbAdministration(Model model) {
        prepareModel(model);
        return "dbadministration";
    }

    private void prepareModel(Model model) {
        int vaccinationContactLocalSize = -1; // ak ostane -1, znamena to problem s databazou
        try {
            vaccinationContactLocalSize = vaccinationContactService.getAllVaccinationContacts().size();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        model.addAttribute("VaccinationContactLocalSize", vaccinationContactLocalSize);
    }


}
