package sk.tuke.coronastatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import sk.tuke.coronastatapp.service.*;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.coronastatapp.server.*"))
public class SpringClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runnerDataFillerJPA(DataFillerJPA console) {
        return s -> console.fill();
    }

    @Bean
    public DataFillerJPA consoleJPA() {
        return new DataFillerJPA();
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
    public RegionService regionService() { return new RegionServiceJPA(); }

}




