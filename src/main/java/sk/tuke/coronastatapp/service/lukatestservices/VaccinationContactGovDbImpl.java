package sk.tuke.coronastatapp.service.lukatestservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import sk.tuke.coronastatapp.entity.VaccinationContact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VaccinationContactGovDbImpl implements VaccinationContactGovDb {

    private String url = "https://data.korona.gov.sk/api";

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<VaccinationContact> getAllVaccinationContacts(String apiLink) {
        List<VaccinationContact> finalList = new ArrayList<VaccinationContact>();
        List<VaccinationContact> tempList = new ArrayList<VaccinationContact>();
        String offfsetLink = "";

//        do {
//            tempList.clear();
//            tempList = Arrays.asList(restTemplate.getForEntity(url + apiLink + offfsetLink, VaccinationContact[].class).getBody());
//            finalList.addAll(tempList);
//            if (!tempList.isEmpty()) {
//                offfsetLink = "?offset=" + tempList.get(tempList.size() - 1).getHospital().getId();
//            }
//
//        } while (!true);

//        return finalList;
        return Arrays.asList(restTemplate.getForEntity(url + apiLink + offfsetLink, VaccinationContact[].class).getBody());

    }

    //        return Arrays.asList(restTemplate.getForEntity(url + "/score/" + game, Score[].class).getBody());

    @Override
    public int getNumberOfRows(String apiLink) {
        return getAllVaccinationContacts(apiLink).size();
    }
}
