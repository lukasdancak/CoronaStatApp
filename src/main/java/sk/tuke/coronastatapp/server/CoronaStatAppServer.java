package sk.tuke.coronastatapp.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import sk.tuke.coronastatapp.SpringClient;
import sk.tuke.coronastatapp.service.VaccinationContactService;
import sk.tuke.coronastatapp.service.VaccinationContactServiceJPA;


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


}

