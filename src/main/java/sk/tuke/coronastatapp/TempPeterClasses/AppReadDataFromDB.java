package sk.tuke.coronastatapp.TempPeterClasses;

import org.jboss.jandex.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppReadDataFromDB {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(Main.class.getName());

    private static HttpURLConnection conn;
    public static void main(String[] args) {

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        try{
            URL url = new URL("https://data.korona.gov.sk/api/hospital-beds/by-region");
            conn = (HttpURLConnection) url.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            int status = conn.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            log.info("response code: " + status);
            System.out.println(responseContent.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }

    }

}
