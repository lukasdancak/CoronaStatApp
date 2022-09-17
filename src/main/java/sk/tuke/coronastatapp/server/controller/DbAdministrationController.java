package sk.tuke.coronastatapp.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import sk.tuke.coronastatapp.entity.*;
import sk.tuke.coronastatapp.service.*;
import sk.tuke.coronastatapp.service.lukatestservices.*;

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

    @Autowired
    RegionVaccinationService regionVaccinationService;
    @Autowired
    RegionVaccinationGovDb regionVaccinationGovDb;
    @Autowired
    VaccinationService vaccinationService;
    @Autowired
    VaccinationGovDb vaccinationGovDb;
    @Autowired
    VaccineService vaccineService;
    @Autowired
    VaccineGovDb vaccineGovDb;

    @Autowired
    TableRowCountService tableRowCountService;

//    @Autowired
//    RestTemplate restTemplate;


    @RequestMapping("/dbadministration")
    public String dbAdministration(Model model) {
        prepareModel(model);
        return "dbadministration";
    }

    private void prepareModel(Model model) {
        /****************** data about table: slovakia_vaccination ***********************/
        model.addAttribute("VaccinationContactLocalSize", tableRowCountService
                .getRowCountOfLocalTable("VaccinationContact"));


        model.addAttribute("VaccinationContactGovSize", tableRowCountService
                .getRowCountOfGovTable("VaccinationContact"));


        /****************  data about table: region *****************************/

        model.addAttribute("RegionLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Region"));

        model.addAttribute("RegionGovSize", tableRowCountService
                .getRowCountOfGovTable("Region"));

        /******************* data table: slovakia_vaccination **************************/

        model.addAttribute("SlovakiaVaccinationLocalSize", tableRowCountService
                .getRowCountOfLocalTable("SlovakiaVaccination"));

//        model.addAttribute("SlovakiaVaccinationGovSize", tableRowCountService
//                .getRowCountOfGovTable("SlovakiaVaccination"));

        /******************* data table: region_vaccination **************************/

        model.addAttribute("RegionVaccinationLocalSize", tableRowCountService
                .getRowCountOfLocalTable("RegionVaccination"));

//        model.addAttribute("RegionVaccinationGovSize", tableRowCountService
//                .getRowCountOfGovTable("RegionVaccination"));

        /******************* data table: vaccination **************************/

        model.addAttribute("VaccinationLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Vaccination"));

//        model.addAttribute("VaccinationGovSize", tableRowCountService
//                .getRowCountOfGovTable("Vaccination"));

        /******************* data table: hospital_staff **************************/

        model.addAttribute("HospitalStaffLocalSize", tableRowCountService
                .getRowCountOfLocalTable("HospitalStaff"));

//        model.addAttribute("HospitalStaffGovSize", tableRowCountService
//                .getRowCountOfGovTable("HospitalStaff"));

        /******************* data table: slovakia_hospital_patients **************************/

        model.addAttribute("SlovakiaHospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("SlovakiaHospitalPatients"));

//        model.addAttribute("SlovakiaHospitalPatientsGovSize", tableRowCountService
//                .getRowCountOfGovTable("SlovakiaHospitalPatients"));

        /******************* data table: region_hospital_patients **************************/

        model.addAttribute("RegionHospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("RegionHospitalPatients"));

//        model.addAttribute("SlovakiaHospitalPatientsGovSize", tableRowCountService
//                .getRowCountOfGovTable("SlovakiaHospitalPatients"));

        /******************* data table: vaccine **************************/

        model.addAttribute("VaccineLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Vaccine"));


    }

    /**************** request for clear table ******************/
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

            case "regionvaccination":
                regionVaccinationService.deleteAllRegionVaccinations();
                break;

            case "vaccination":
                vaccinationService.deleteAllVaccinations();
                break;

            case "vaccine":
                vaccineService.deleteAllVaccine();
                break;
        }

        return "redirect:/dbadministration";
    }

    /**************** request for clear and fill table ******************/
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

            case "regionvaccination":
                regionVaccinationService.deleteAllRegionVaccinations();
                var list3 = regionVaccinationGovDb.getAllRegionVaccinations();
                for (RegionVaccination rv : list3) {
                    regionVaccinationService.addRegionVaccination(rv);
                }
                break;

            case "vaccination":
                vaccinationService.deleteAllVaccinations();
                var list4 = vaccinationGovDb.getAllVaccinations();
                for (Vaccination rv : list4) {
                    vaccinationService.addVaccination(rv);
                }
                break;

            case "vaccine":
                vaccineService.deleteAllVaccine();
                var list5 = vaccineGovDb.getAllVaccines();
                for (Vaccine rv : list5) {
                    vaccineService.addVaccine(rv);
                }
                break;
        }

        return "redirect:/dbadministration";
    }


}
