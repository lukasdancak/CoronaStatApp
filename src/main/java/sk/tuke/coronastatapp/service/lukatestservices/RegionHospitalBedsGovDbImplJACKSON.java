package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.RegionHospitalBeds;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RegionHospitalBedsGovDbImplJACKSON implements RegionHospitalBedsGovDb{


    @Override
    public List<RegionHospitalBeds> getAllRegionHospitalBeds() {

        try {
        String URLString = "https://data.korona.gov.sk/api/hospital-beds/by-region";
        List<RegionHospitalBeds> resultList = new ArrayList<RegionHospitalBeds>();
        List<RegionHospitalBeds> tempList = new ArrayList<RegionHospitalBeds>();
        URL url = new URL(URLString);
        int x = 0;

        do {
            tempList.clear();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.path("page");
            JsonParser parser = mapper.treeAsTokens(node);
            TypeReference<List<RegionHospitalBeds>> typeReference = new TypeReference<>() {
            };
            tempList = mapper.readValue(parser, typeReference);
            resultList.addAll(tempList);
            /***create next link, for next offset*/
            String offset = rootNode.path("next_offset").asText();
            url = new URL(URLString + "?offset=" + offset);

            //kontrolny vypis
            x++;
            System.out.println(x + ".: offset is: " + offset + " next url is: " + url.toString());

        } while (!tempList.isEmpty());

        System.out.println("nacital som objekty do listu RegionHospitalBeds");
        return resultList;
    } catch (IOException e) {
        System.out.println(e.getMessage());
        System.out.println("problem s nacitanim RegionHospitalBeds");
        return null;
    }
}

}
