package sk.tuke.coronastatapp.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import sk.tuke.coronastatapp.service.*;

@SpringBootApplication
@EntityScan(basePackages = "sk.tuke.coronastatapp.entity")
public class CoronaStatAppServer {

    public static void main(String[] args) {

        SpringApplication.run(CoronaStatAppServer.class);
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
}

