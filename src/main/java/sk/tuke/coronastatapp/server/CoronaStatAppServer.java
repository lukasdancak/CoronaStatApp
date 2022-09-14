package sk.tuke.coronastatapp.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sk.tuke.coronastatapp.SpringClient;
import sk.tuke.coronastatapp.service.VaccinationContactService;
import sk.tuke.coronastatapp.service.VaccinationContactServiceJPA;
import sk.tuke.coronastatapp.service.lukatestservices.VaccinationContactGovDb;
import sk.tuke.coronastatapp.service.lukatestservices.VaccinationContactGovDbImpl;


import javax.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = "sk.tuke.coronastatapp.entity")
public class CoronaStatAppServer {
    public static void main(String[] args) {

        SpringApplication.run(CoronaStatAppServer.class);
    }

    @Bean
    public VaccinationContactService vaccinationContactService() {
        return new VaccinationContactServiceJPA();
    }

    @Bean
    public VaccinationContactGovDb vaccinationContactGovDb() {
        return new VaccinationContactGovDbImpl();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}

