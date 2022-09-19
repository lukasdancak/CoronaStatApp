package sk.tuke.coronastatapp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import sk.tuke.coronastatapp.service.VaccinationContactService;
import sk.tuke.coronastatapp.service.VaccinationContactServiceJPA;
import sk.tuke.coronastatapp.service.lukatestservices.*;

import sk.tuke.coronastatapp.service.*;

@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = "sk.tuke.coronastatapp.entity")
public class CoronaStatAppServer {
    public static void main(String[] args) {

        SpringApplication.run(CoronaStatAppServer.class);
    }


    @Bean
    RegionHospitalPatientsService regionHospitalPatientsService() {
        return new RegionHospitalPatientsServiceJPA();
    }

    @Bean
    RegionHospitalPatientsGovDb regionHospitalPatientsGovDb() {
        return new RegionHospitalPatientsGovDbImplJACKSON();
    }

    @Bean
    SlovakiaHospitalPatientsService slovakiaHospitalPatientsService() {
        return new SlovakiaHospitalPatientsServiceJPA();
    }

    @Bean
    SlovakiaHospitalPatientsGovDb slovakiaHospitalPatientsGovDb() {
        return new SlovakiaHospitalPatientsGovDbImplJACKSON();
    }

    @Bean
    HospitalStaffGovDb hospitalStaffGovDb() {
        return new HospitalStaffGovDbImplJACKSON();
    }

    @Bean
    HospitalStaffService hospitalStaffService() {
        return new HospitalStaffServiceJPA();
    }

    @Bean
    VaccineGovDb vaccineGovDb() {
        return new VaccineGovDbImplJACKSON();
    }

    @Bean
    VaccineService vaccineService() {
        return new VaccineServiceJPA();
    }

    @Bean
    VaccinationGovDb vaccinationGovDb() {
        return new VaccinationGovDbImplJACKSON();
    }

    @Bean
    VaccinationService vaccinationService() {
        return new VaccinationServiceJPA();
    }

    @Bean
    TableRowCountService tableRowCountService() {
        return new TableRowCountServiceImpl();
    }

    @Bean
    RegionVaccinationGovDb regionVaccinationGovDb() {
        return new RegionVaccinationGovDbImplJACKSON();
    }

    @Bean
    RegionVaccinationService regionVaccinationService() {
        return new RegionVaccinationServiceJPA();
    }

    @Bean
    SlovakiaVaccinationGovDb slovakiaVaccinationGovDb() {
        return new SlovakiaVaccinationGovDbImplJACKSON();
    }

    @Bean
    SlovakiaVaccinationService slovakiaVaccinationService() {
        return new SlovakiaVaccinationServiceJPA();
    }

    @Bean
    public RegionGovDb regionGovDb() {
        return new RegionGovDbImplJACKSON();
    }

    @Bean
    public VaccinationContactService vaccinationContactService() {
        return new VaccinationContactServiceJPA();
    }

    @Bean
    public VaccinationContactGovDb vaccinationContactGovDb() {
        return new VaccinationContactGovDbImplJACKSON();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public DistrictAgTestsService districtAgTestsService() {
        return new DistrictAgTestsServiceJPA();
    }

    @Bean
    public RegionAgTestsService regionAgTestsService() {
        return new RegionAgTestsServiceJPA();
    }

    @Bean
    public SlovakiaAgTestsService slovakiaAgTestsService() {
        return new SlovakiaAgTestsServiceJPA();
    }

    @Bean
    public HospitalService hospitalService() {
        return new HospitalServiceJPA();
    }

    @Bean
    public CityService cityService() {
        return new CityServiceJPA();
    }

    @Bean
    public DistrictService districtService() {
        return new DistrictServiceJPA();
    }

    @Bean
    public RegionService regionService() {
        return new RegionServiceJPA();
    }

    @Bean
    HospitalBedsService hospitalBedsService() {return new HospitalBedsServiceJPA();}

    @Bean
    HospitalBedsGovDb hospitalBedsGovDb() {return new HospitalBedsGovDbImplJACKSON();}

    @Bean
    DistrictHospitalBedsService districtHospitalBedsService() {return new DistrictHospitalBedsServiceJPA();}

    @Bean
    DistrictHospitalBedsGovDb districtHospitalBedsGovDb() {return new DistrictHospitalBedsGovDbImplJACKSON();}

    @Bean
    RegionHospitalBedsService regionHospitalBedsService() {return new RegionHospitalBedsServiceJPA();}

    @Bean
    RegionHospitalBedsGovDb regionHospitalBedsGovDb() {return  new RegionHospitalBedsGovDbImplJACKSON();}

    @Bean
    SlovakiaHospitalBedsService slovakiaHospitalBedsService() {return new SlovakiaHospitalBedsServiceJPA();}

    @Bean
    SlovakiaHospitalBedsGovDb slovakiaHospitalBedsGovDb () {return new SlovakiaHospitalBedsGovDbImplJACKSON();}

    @Bean
    HospitalPatientsService hospitalPatientsService() {return new HospitalPatientsServiceJPA();}

    @Bean
    HospitalPatientsGovDb hospitalPatientsGovDb() {return new HospitalPatientsGovDbImplJACKSON();}

    @Bean
    DistrictHospitalPatientsService districtHospitalPatientsService() {return new DistrictHospitalPatientsServiceJPA();}

    @Bean
    DistrictHospitalPatientsGovDb districtHospitalPatientsGovDb(){return new DistrictHospitalPatientsGovDbImplJACKSON();}


}

