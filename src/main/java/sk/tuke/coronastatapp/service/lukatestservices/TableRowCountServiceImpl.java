package sk.tuke.coronastatapp.service.lukatestservices;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.tuke.coronastatapp.entity.SlovakiaVaccination;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class TableRowCountServiceImpl implements TableRowCountService {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public int getRowCountOfLocalTable(String tableName) {

        try {
            System.out.println("spustam query v getrowCountLocalTable, table name: " + tableName);

            var query = entityManager.createQuery("SELECT COUNT(*) FROM " + tableName)
                    // var query = entityManager.createNativeQuery("SELECT COUNT(*) FROM " + tableName + ";")
                    .getSingleResult();
            System.out.println(query);
            int i = Integer.valueOf(query.toString());

            System.out.println("koncim query v getrowCountLocalTable, table name: " + tableName);
            return i;
        } catch (Exception e) {
            //e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getRowCountOfGovTable(String tableName) {
        String urlHome = "https://data.korona.gov.sk";
        switch (tableName) {
            case "VaccinationContact":
                return getRowCountOfGovTableWithOffset(urlHome + "/api/vaccination/contacts");

            case "Region":
                return getRowCountOfGovTableNoOffset(urlHome + "/api/regions");

            case "SlovakiaVaccination":
                return getRowCountOfGovTableWithOffset(urlHome + "/api/vaccinations/in-slovakia");

            case "RegionVaccination":
                return getRowCountOfGovTableWithOffset(urlHome + "/api/vaccinations/by-region");

            case "Vaccination":
                return getRowCountOfGovTableWithOffset(urlHome + "/api/vaccinations");

            case "HospitalStaff":
                return getRowCountOfGovTableWithOffset(urlHome + "/api/hospital-staff");

            case "Vaccine":
                return getRowCountOfGovTableNoOffset(urlHome + "/api/vaccines");

            case "District":
                return getRowCountOfGovTableNoOffset(urlHome + "/api/districts");

            case "City":
                return getRowCountOfGovTableNoOffset(urlHome + "/api/cities");

            case "Hospital":
                return getRowCountOfGovTableNoOffset(urlHome + "/api/hospitals");


            default:
                return -10; // vrati ak je nespravny nazov Entity na vstupe

        }

    }


    public int getRowCountOfGovTableWithOffset(String apiUrl) {
//        List<JsonNode> allJsons = new ArrayList<>();
//        List<JsonNode> tempJsons = new ArrayList<>();
        int allJsonsCount = 0;
        int tempJsonsCount = 0;


        try {
            String URLString = apiUrl;

            URL url = new URL(URLString);
            int x = 0;

            do {
                tempJsonsCount = 0;
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(url);
                JsonNode node = rootNode.path("page");
                JsonParser parser = mapper.treeAsTokens(node);
                tempJsonsCount = node.size();
                System.out.println("tempJsonCount je: " + tempJsonsCount);


                allJsonsCount += tempJsonsCount;
                System.out.println("allJsonCount je: " + allJsonsCount);
                /***create next link, for next offset*/
                String offset = rootNode.path("next_offset").asText();
                url = new URL(URLString + "?offset=" + offset);

                //kontrolny vypis
                x++;
                System.out.println(x + ".: offset is: " + offset + " next url is: " + url.toString());

            } while (tempJsonsCount != 0);

            System.out.println("nacital som do premennej pocet JSON-ov v SlovakiaVaccination");
            return allJsonsCount;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim poctu Jsonov v slovakiaVaccinations");
            return -1;
        }
    }


    public int getRowCountOfGovTableNoOffset(String apiUrl) {

        int allJsonsCount = 0;

        try {
            String URLString = apiUrl;
            URL url = new URL(URLString);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(url);
            allJsonsCount = rootNode.size();
            System.out.println("allJsonCount je: " + allJsonsCount);

            System.out.println("nacital som do premennej pocet JSON-ov v SlovakiaVaccination");
            return allJsonsCount;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("problem s nacitanim poctu Jsonov v slovakiaVaccinations");
            return -1;
        }


    }
}
