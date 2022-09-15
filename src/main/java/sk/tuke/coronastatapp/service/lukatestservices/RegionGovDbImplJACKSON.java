package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.Region;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RegionGovDbImplJACKSON implements RegionGovDb {

    @Override
    public List<Region> getAllRegions() {

        try {
            String URLString = "https://data.korona.gov.sk/api/regions";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Region>> typeReference = new TypeReference<>() {
            };
            List<Region> regions = mapper.readValue(url, typeReference);

            System.out.println("nacital som do listu all Region");
            return regions;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim all Region");
            return null;
        }

    }

    @Override
    public int getNumberOfRows() {
        var temp = getAllRegions();

        if (temp != null) {
            return temp.size();
        } else {
            return -1;
        }
    }
}
