package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.SlovakiaVaccination;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SlovakiaVaccinationGovDbImplJACKSON implements SlovakiaVaccinationGovDb {

    @Override
    public List<SlovakiaVaccination> getAllSlovakiaVaccinations() {

        try {
            String URLString = "https://data.korona.gov.sk/api/vaccinations/in-slovakia";
            List<SlovakiaVaccination> slovakiaVaccinations = new ArrayList<SlovakiaVaccination>();
            List<SlovakiaVaccination> tempSlovakiaVaccinations = new ArrayList<SlovakiaVaccination>();
            URL url = new URL(URLString);
            int x = 0;

            do {
                tempSlovakiaVaccinations.clear();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(url);
                JsonNode node = rootNode.path("page");
                JsonParser parser = mapper.treeAsTokens(node);
                TypeReference<List<SlovakiaVaccination>> typeReference = new TypeReference<>() {
                };
                tempSlovakiaVaccinations = mapper.readValue(parser, typeReference);
                slovakiaVaccinations.addAll(tempSlovakiaVaccinations);
                /***create next link, for next offset*/
                String offset = rootNode.path("next_offset").asText();
                url = new URL(URLString + "?offset=" + offset);

                //kontrolny vypis
                x++;
                System.out.println(x + ".: offset is: " + offset + " next url is: " + url.toString());

            } while (!tempSlovakiaVaccinations.isEmpty());

            System.out.println("nacital som do listu slovakiaVaccinations");
            return slovakiaVaccinations;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim slovakiaVaccinations");
            return null;
        }
    }

    @Override
    public int getNumberOfRows() {
        var temp = getAllSlovakiaVaccinations();

        if (temp != null) {
            return temp.size();
        } else {
            return -1;
        }
    }
}
