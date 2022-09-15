package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.DistrictAgTests;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class VaccinationContactGovDbImplJACKSON implements VaccinationContactGovDb {

    @Override
    public List<VaccinationContact> getAllVaccinationContacts() {

        try {
            String URLString = "https://data.korona.gov.sk/api/vaccination/contacts";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.path("page");
            JsonParser parser = mapper.treeAsTokens(node);
            TypeReference<List<VaccinationContact>> typeReference = new TypeReference<>() {
            };
            List<VaccinationContact> districtAgTests = mapper.readValue(parser, typeReference);
//            for (int i = 0; i < districtAgTests.size(); i++) {
//                districtAgTestsService.addDistrictAgTests(districtAgTests.get(i));
//            }
            System.out.println("nacital som do listu vaccinationContacts");
            return districtAgTests;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim vaccinationcontacts");
            return null;
        }

    }

    @Override
    public int getNumberOfRows() {
        var temp = getAllVaccinationContacts();

        if (temp != null) {
            return getAllVaccinationContacts().size();
        } else {
            return -1;
        }
    }
}
