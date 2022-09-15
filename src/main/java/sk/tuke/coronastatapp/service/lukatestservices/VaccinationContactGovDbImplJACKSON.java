package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.DistrictAgTests;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VaccinationContactGovDbImplJACKSON implements VaccinationContactGovDb {

    @Override
    public List<VaccinationContact> getAllVaccinationContacts() {

        try {
            String URLString = "https://data.korona.gov.sk/api/vaccination/contacts";
            List<VaccinationContact> vaccinationContacts = new ArrayList<VaccinationContact>();
            List<VaccinationContact> tempVaccinationContacts = new ArrayList<VaccinationContact>();
            URL url = new URL(URLString);

            do {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(url);
                JsonNode node = rootNode.path("page");
                JsonParser parser = mapper.treeAsTokens(node);
                TypeReference<List<VaccinationContact>> typeReference = new TypeReference<>() {
                };
                tempVaccinationContacts = mapper.readValue(parser, typeReference);
                vaccinationContacts.addAll(tempVaccinationContacts);
                /***create next link, for next offset*/
                String offset = rootNode.path("offset").textValue();
                url = new URL(URLString + "?offset=" + offset);

            } while (!tempVaccinationContacts.isEmpty());

            System.out.println("nacital som do listu vaccinationContacts");
            return vaccinationContacts;
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
