package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.RegionVaccination;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RegionVaccinationGovDbImplJACKSON implements RegionVaccinationGovDb {

    @Override
    public List<RegionVaccination> getAllRegionVaccinations() {

        try {
            String URLString = "https://data.korona.gov.sk/api/vaccinations/by-region";
            List<RegionVaccination> regionVaccinations = new ArrayList<RegionVaccination>();
            List<RegionVaccination> tempRegionVaccinations = new ArrayList<RegionVaccination>();
            URL url = new URL(URLString);
            int x = 0;

            do {
                tempRegionVaccinations.clear();
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(url);
                JsonNode node = rootNode.path("page");
                JsonParser parser = mapper.treeAsTokens(node);
                TypeReference<List<RegionVaccination>> typeReference = new TypeReference<>() {
                };
                tempRegionVaccinations = mapper.readValue(parser, typeReference);
                regionVaccinations.addAll(tempRegionVaccinations);
                /***create next link, for next offset*/
                String offset = rootNode.path("next_offset").asText();
                url = new URL(URLString + "?offset=" + offset);

                //kontrolny vypis
                x++;
                System.out.println(x + ".: offset is: " + offset + " next url is: " + url.toString());

            } while (!tempRegionVaccinations.isEmpty());

            System.out.println("nacital som do listu regionVaccinations");
            return regionVaccinations;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim regionVaccinations");
            return null;
        }
    }

    @Override
    public int getNumberOfRows() {
        var temp = getAllRegionVaccinations();

        if (temp != null) {
            return temp.size();
        } else {
            return -1;
        }
    }
}
