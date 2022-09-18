package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.Vaccine;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class VaccineGovDbImplJACKSON implements VaccineGovDb {

    @Override
    public List<Vaccine> getAllVaccines() {

        try {
            String URLString = "https://data.korona.gov.sk/api/vaccines";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Vaccine>> typeReference = new TypeReference<>() {
            };
            List<Vaccine> resultList = mapper.readValue(url, typeReference);

            System.out.println("nacital som do listu vsetky objekty");
            return resultList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim objektov do listu");
            return null;
        }

    }


}
