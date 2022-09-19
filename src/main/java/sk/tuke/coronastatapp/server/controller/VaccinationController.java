package sk.tuke.coronastatapp.server.controller;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.tuke.coronastatapp.entity.Vaccination;
import sk.tuke.coronastatapp.service.SlovakiaVaccinationService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VaccinationController {

    @Autowired
    SlovakiaVaccinationService slovakiaVaccinationService;

    @RequestMapping("/charts/vaccinationslovakia")
    public String vaccination(Model model) {
        model.addAttribute("vaccinationData", prepareData());


        return "vaccination";
    }

    private List<List<Object>> prepareData() {
        System.out.println("som v prepare data");
        List<List<Object>> finallist = new ArrayList<List<Object>>();


        try {
            String URLString = "http://localhost:8080/api/vaccinations";

            URL url = new URL(URLString);

            ObjectMapper mapper = new ObjectMapper();
            System.out.println("som pred nacitanim linku");
            JsonNode rootNode = mapper.readTree(url);

            System.out.println("som pred cyklom");
            for (int i = 0; i < rootNode.size(); i++) {
                System.out.println("published_on: " + rootNode.get(i).path("published_on").textValue());
                System.out.println("dose1: " + rootNode.get(i).path("dose1_count").intValue());
                finallist.add(List.of(rootNode.get(i).path("published_on").textValue(), rootNode.get(i).path("dose1_count").intValue()));

            }

            return finallist;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim oobjektov do listu pre graf");
            return null;
        }


    }


}
