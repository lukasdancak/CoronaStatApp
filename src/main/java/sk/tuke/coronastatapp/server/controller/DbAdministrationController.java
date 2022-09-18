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
    HospitalStaffService hospitalStaffService;
    @Autowired
    HospitalStaffGovDb hospitalStaffGovDb;
    @Autowired
    RegionHospitalPatientsGovDb regionHospitalPatientsGovDb;
    @Autowired
    RegionHospitalPatientsService regionHospitalPatientsService;
    @Autowired
    SlovakiaHospitalPatientsService slovakiaHospitalPatientsService;
    @Autowired
    SlovakiaHospitalPatientsGovDb slovakiaHospitalPatientsGovDb;

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
        /****************** data about table: vaccination_contact ***********************/
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


        /******************* data table: vaccination **************************/

        model.addAttribute("VaccinationLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Vaccination"));


        /******************* data table: hospital_staff **************************/

        model.addAttribute("HospitalStaffLocalSize", tableRowCountService
                .getRowCountOfLocalTable("HospitalStaff"));


        /******************* data table: slovakia_hospital_patients **************************/

        model.addAttribute("SlovakiaHospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("SlovakiaHospitalPatients"));


        /******************* data table: region_hospital_patients **************************/

        model.addAttribute("RegionHospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("RegionHospitalPatients"));

        /******************* data table: district_hospital_patients **************************/

        model.addAttribute("DistrictHospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("DistrictHospitalPatients"));

        /******************* data table: hospital_patients **************************/

        model.addAttribute("HospitalPatientsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("HospitalPatients"));

        /******************* data table: slovakia_hospital_beds **************************/

        model.addAttribute("SlovakiaHospitalBedsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("SlovakiaHospitalBeds"));

        /******************* data table: region_hospital_beds **************************/

        model.addAttribute("RegionHospitalBedsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("RegionHospitalBeds"));

        /******************* data table: district_hospital_beds **************************/

        model.addAttribute("DistrictHospitalBedsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("DistrictHospitalBeds"));

        /******************* data table: hospital_beds **************************/

        model.addAttribute("HospitalBedsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("HospitalBeds"));


        /******************* data table: vaccine **************************/

        model.addAttribute("VaccineLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Vaccine"));
        model.addAttribute("VaccineGovSize", tableRowCountService
                .getRowCountOfGovTable("Vaccine"));

        /******************* data table: district **************************/

        model.addAttribute("DistrictLocalSize", tableRowCountService
                .getRowCountOfLocalTable("District"));
        model.addAttribute("DistrictGovSize", tableRowCountService
                .getRowCountOfGovTable("District"));

        /******************* data table: city **************************/

        model.addAttribute("CityLocalSize", tableRowCountService
                .getRowCountOfLocalTable("City"));
        model.addAttribute("CityGovSize", tableRowCountService
                .getRowCountOfGovTable("City"));

        /******************* data table: hospital **************************/

        model.addAttribute("HospitalLocalSize", tableRowCountService
                .getRowCountOfLocalTable("Hospital"));
        model.addAttribute("HospitalGovSize", tableRowCountService
                .getRowCountOfGovTable("Hospital"));

        /******************* data table: slovakia_ag_tests **************************/

        model.addAttribute("SlovakiaAgTestsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("SlovakiaAgTests"));

        /******************* data table: region_ag_tests **************************/

        model.addAttribute("RegionAgTestsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("RegionAgTests"));

        /******************* data table: district_ag_tests **************************/

        model.addAttribute("DistrictAgTestsLocalSize", tableRowCountService
                .getRowCountOfLocalTable("DistrictAgTests"));


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

            case "hospitalstaff":
                hospitalStaffService.deleteAllHospitalStaff();
                break;

            case "regionhospitalpatients":
                regionHospitalPatientsService.deleteAllRegionHospitalPatients();
                break;

            case "slovakiahospitalpatients":
                slovakiaHospitalPatientsService.deleteAllSlovakiaHospitalPatients();
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

            case "hospitalstaff":
                hospitalStaffService.deleteAllHospitalStaff();
                var list6 = hospitalStaffGovDb.getAllHospitalStaffs();
                for (HospitalStaff o : list6) {
                    hospitalStaffService.addHospitalStaff(o);
                }
                break;

            case "regionhospitalpatients":
                regionHospitalPatientsService.deleteAllRegionHospitalPatients();
                var list7 = regionHospitalPatientsGovDb.getAllRegionHospitalPatients();
                for (RegionHospitalPatients o : list7) {
                    regionHospitalPatientsService.addRegionHospitalPatients(o);
                }
                break;

            case "slovakiahospitalpatients":
                slovakiaHospitalPatientsService.deleteAllSlovakiaHospitalPatients();
                var list8 = slovakiaHospitalPatientsGovDb.getAllSlovakiaHospitalPatients();
                for (SlovakiaHospitalPatients o : list8) {
                    slovakiaHospitalPatientsService.addSlovakiaHospitalPatients(o);
                }
                break;
        }

        return "redirect:/dbadministration";
    }


}
