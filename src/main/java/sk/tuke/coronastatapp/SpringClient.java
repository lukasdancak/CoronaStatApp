package sk.tuke.coronastatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.coronastatapp.server.*"))
public class SpringClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runnerFillerJPA(DataFillerJPA console) {
        return s -> console.play();
    }

    @Bean
    public DataFillerJPA consoleJPA() {
        return new DataFillerJPA();
    }

}




