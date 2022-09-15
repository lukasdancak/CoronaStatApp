package sk.tuke.coronastatapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.coronastatapp.entity.SlovakiaVaccination;
import sk.tuke.coronastatapp.entity.VaccinationContact;
import sk.tuke.coronastatapp.service.RegionService;
import sk.tuke.coronastatapp.service.SlovakiaVaccinationService;
import sk.tuke.coronastatapp.service.VaccinationContactService;
import sk.tuke.coronastatapp.service.lukatestservices.RegionGovDb;
import sk.tuke.coronastatapp.service.lukatestservices.SlovakiaVaccinationGovDb;
import sk.tuke.coronastatapp.service.lukatestservices.VaccinationContactGovDb;

@Controller
//@Scope(WebApplicationContext.SCOPE_SESSION)
public class DbAdministrationController {

    @Autowired
    VaccinationContactService vaccinationContactService;
    @Autowired
    VaccinationContactGovDb vaccinationContactGovDb;
    @Autowired
    RegionService regionService;
    @Autowired
    RegionGovDb regionGovDb;
    @Autowired
    SlovakiaVaccinationService slovakiaVaccinationService;
    @Autowired
    SlovakiaVaccinationGovDb slovakiaVaccinationGovDb;

//    @Autowired
//    RestTemplate restTemplate;


    @RequestMapping("/dbadministration")
    public String dbAdministration(Model model) {
        prepareModel(model);
        return "dbadministration";
    }

    private void prepareModel(Model model) {
        /*****************************************/
        int vaccinationContactLocalSize = -1; // ak ostane -1, znamena to problem s databazou
        try {
            vaccinationContactLocalSize = vaccinationContactService.getAllVaccinationContacts().size();
        } catch (Exception e) {
            //e.printStackTrace();
        }
        model.addAttribute("VaccinationContactLocalSize", vaccinationContactLocalSize);

        int vaccinationContactGovSize = -1; // ak ostane -1, znamena to problem s databazou
        vaccinationContactGovSize = vaccinationContactGovDb.getNumberOfRows();
        model.addAttribute("VaccinationContactGovSize", vaccinationContactGovSize);

        /*********************************************/
        int regionLocalSize = -1; // ak ostane -1, znamena to problem s databazou
        try {
            regionLocalSize = regionService.getAllRegions().size();
        } catch (Exception e) {  //e.printStackTrace();
        }
        model.addAttribute("RegionLocalSize", regionLocalSize);

        int regionGovSize = -1; // ak ostane -1, znamena to problem s databazou
        regionGovSize = regionGovDb.getNumberOfRows();
        model.addAttribute("RegionGovSize", regionGovSize);

        /*********************************************/
        int slovakiaVaccinationLocalSize = -1; // ak ostane -1, znamena to problem s databazou
        try {
            slovakiaVaccinationLocalSize = slovakiaVaccinationService.getAllSlovakiaVaccinations().size();
        } catch (Exception e) {  //e.printStackTrace();
        }
        model.addAttribute("SlovakiaVaccinationLocalSize", slovakiaVaccinationLocalSize);

        int slovakiaVaccinationGovSize = -1; // ak ostane -1, znamena to problem s databazou
        slovakiaVaccinationGovSize = slovakiaVaccinationGovDb.getNumberOfRows();
        model.addAttribute("SlovakiaVaccinationGovSize", slovakiaVaccinationGovSize);

    }


    @RequestMapping("/dbadministration/clear")
    public String clearTable(@RequestParam(required = false) String tablename,
                             Model model) {
        System.out.println("som v clearTable metode");
        //tu by mala byt kontrola, ci je prihlaseny admin

        if (tablename == null) {
            System.out.println("tablename is null");
            return "redirect:/dbadministration";
        }
        System.out.println("som v clearTable metode po kontrole tableName is null ?");

        switch (tablename) {
            case "vaccinationcontact":
                vaccinationContactService.deleteAllVaccinationContacts();
                System.out.println("som vo switchi, vaccination contact");
                break;

            case "slovakiavaccination":
                slovakiaVaccinationService.deleteAllSlovakiaVaccinations();
                break;
        }

        return "redirect:/dbadministration";
    }

    @RequestMapping("/dbadministration/clearandfill")
    public String clearAndFillTable(@RequestParam(required = false) String tablename,
                                    Model model) {
        //tu by mala byt kontrola, ci je prihlaseny admin
        if (tablename == null) {
            return "redirect:/dbadministration";
        }

        switch (tablename) {
            case "vaccinationcontact":
                vaccinationContactService.deleteAllVaccinationContacts();
                var list = vaccinationContactGovDb.getAllVaccinationContacts();
                for (VaccinationContact vc : list) {
                    vaccinationContactService.addVaccination(vc);
                }
                break;

            case "slovakiavaccination":
                slovakiaVaccinationService.deleteAllSlovakiaVaccinations();
                var list2 = slovakiaVaccinationGovDb.getAllSlovakiaVaccinations();
                for (SlovakiaVaccination sv : list2) {
                    slovakiaVaccinationService.addSlovakiaVaccination(sv);
                }
                break;
        }

        return "redirect:/dbadministration";
    }


}