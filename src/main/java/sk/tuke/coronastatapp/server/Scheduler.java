package sk.tuke.coronastatapp.server;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sk.tuke.coronastatapp.entity.DistrictAgTests;
import sk.tuke.coronastatapp.entity.RegionAgTests;
import sk.tuke.coronastatapp.entity.SlovakiaAgTests;
import sk.tuke.coronastatapp.service.DistrictAgTestsService;
import sk.tuke.coronastatapp.service.RegionAgTestsService;
import sk.tuke.coronastatapp.service.SlovakiaAgTestsService;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private DistrictAgTestsService districtAgTestsService;
    @Autowired
    private RegionAgTestsService regionAgTestsService;
    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;

    @Scheduled(cron = "0 40 10 * * ?")
    public void updateDistrictAgTests() {
        try {
            String URLString = "https://data.korona.gov.sk/api/ag-tests/by-district";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.path("page");
            JsonParser parser = mapper.treeAsTokens(node);
            TypeReference<List<DistrictAgTests>> typeReference = new TypeReference<>() {
            };
            List<DistrictAgTests> districtAgTests = mapper.readValue(parser, typeReference);
            for (DistrictAgTests districtAgTest : districtAgTests) {
                districtAgTestsService.addDistrictAgTests(districtAgTest);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(cron = "0 40 10 * * ?")
    public void updateRegionAgTests() {
        try {
            String URLString = "https://data.korona.gov.sk/api/ag-tests/by-region";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.path("page");
            JsonParser parser = mapper.treeAsTokens(node);
            TypeReference<List<RegionAgTests>> typeReference = new TypeReference<>() {
            };
            List<RegionAgTests> regionAgTests = mapper.readValue(parser, typeReference);
            for (RegionAgTests regionAgTest : regionAgTests) {
                regionAgTestsService.addRegionAgTests(regionAgTest);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(cron = "0 40 10 * * ?")
    public void updateSlovakiaAgTests() {
        try {
            String URLString = "https://data.korona.gov.sk/api/ag-tests/in-slovakia";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.path("page");
            JsonParser parser = mapper.treeAsTokens(node);
            TypeReference<List<SlovakiaAgTests>> typeReference = new TypeReference<>() {
            };
            List<SlovakiaAgTests> slovakiaAgTests = mapper.readValue(parser, typeReference);
            for (SlovakiaAgTests slovakiaAgTest : slovakiaAgTests) {
                slovakiaAgTestsService.addSlovakiaAgTests(slovakiaAgTest);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
