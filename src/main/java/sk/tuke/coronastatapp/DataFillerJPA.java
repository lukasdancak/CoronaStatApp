package sk.tuke.coronastatapp;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import sk.tuke.coronastatapp.entity.*;
import sk.tuke.coronastatapp.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


public class DataFillerJPA {

    @Autowired
    private DistrictAgTestsService districtAgTestsService;
    @Autowired
    private RegionAgTestsService regionAgTestsService;
    @Autowired
    private SlovakiaAgTestsService slovakiaAgTestsService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private CityService cityService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private RegionService regionService;

    public void fill() throws IOException {
        System.out.println("Opening database filler JPA.");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean continued = true;
        String[] options = {"DistrictAgTests", "RegionAgTests", "SlovakiaAgTests", "Hospital", "City", "District", "Region"};

        do {
            System.out.println("ID  Table");
            for (int i = 0; i < options.length; i++) {
                System.out.println(i + 1 + " - " + options[i]);
            }
            System.out.println("Please enter ID of table to populate or 0 to exit:");

            String tableId = input.readLine();

            switch (tableId) {
                case "0" -> continued = false;
                case "1" -> populateDistrictAgTests();
                case "2" -> populateRegionAgTests();
                case "3" -> populateSlovakiaAgTests();
                case "4" -> populateHospital();
                case "5" -> populateCity();
                case "6" -> populateDistrict();
                case "7" -> populateRegion();
                default -> System.out.println("Table with ID \"" + tableId + "\" does NOT exists!");
            }
        } while (continued);

        System.out.println("Closing database filler JPA.");
    }

    public void populateDistrictAgTests() {
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
            for (int i = 0; i < districtAgTests.size(); i++) {
                districtAgTestsService.addDistrictAgTests(districtAgTests.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateRegionAgTests() {
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
            for (int i = 0; i < regionAgTests.size(); i++) {
                regionAgTestsService.addRegionAgTests(regionAgTests.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateSlovakiaAgTests() {
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
            for (int i = 0; i < slovakiaAgTests.size(); i++) {
                slovakiaAgTestsService.addSlovakiaAgTests(slovakiaAgTests.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateHospital() {
        try {
            String URLString = "https://data.korona.gov.sk/api/hospitals";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Hospital>> typeReference = new TypeReference<>() {
            };
            List<Hospital> hospitals = mapper.readValue(url, typeReference);
            for (int i = 0; i < hospitals.size(); i++) {
                hospitalService.addHospital(hospitals.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateCity() {
        try {
            String URLString = "https://data.korona.gov.sk/api/cities";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<City>> typeReference = new TypeReference<>() {
            };
            List<City> cities = mapper.readValue(url, typeReference);
            for (int i = 0; i < cities.size(); i++) {
                cityService.addCity(cities.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateDistrict() {
        try {
            String URLString = "https://data.korona.gov.sk/api/districts";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<District>> typeReference = new TypeReference<>() {
            };
            List<District> districts = mapper.readValue(url, typeReference);
            for (int i = 0; i < districts.size(); i++) {
                districtService.addDistrict(districts.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void populateRegion() {
        try {
            String URLString = "https://data.korona.gov.sk/api/regions";
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Region>> typeReference = new TypeReference<>() {
            };
            List<Region> regions = mapper.readValue(url, typeReference);
            for (int i = 0; i < regions.size(); i++) {
                regionService.addRegion(regions.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}