/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apirequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class ApiRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://api.darksky.net/forecast/0cbec9ed87f9c88237e7ee3e964690f5/37.8267,-122.4233");
        try {

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output = "";

            String JSONData = "";
            JSONParser parser = new JSONParser();
            while ((output = br.readLine()) != null) {
//                System.out.println("LA " + output);
                JSONData += output;

            }

            Object object = parser.parse(JSONData);
            JSONObject jObejct = (JSONObject) object;
            Double latidud = (Double) jObejct.get("latitude");
            Double longitude = (Double) jObejct.get("longitude");
            String timeZone = (String) jObejct.get("timezone");
            System.out.println("Latitude: " + latidud + "\nLongitude: " + longitude + "\nTimezone" + timeZone);
            /////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////
            JSONObject objectCurrently = (JSONObject) jObejct;
            Object currently = (Object) objectCurrently.get("currently");
            JSONObject countainCurretly = (JSONObject) currently;
            Object time = (Object) countainCurretly.get("time");
            String summary = (String) countainCurretly.get("summary");
            String icon = (String) countainCurretly.get("icon");

            System.out.println("Time: " + time + "\nSummary: " + summary + "\nIcon: " + icon);

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error MalformedURL " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IOException " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //(CURENTLY:{ SUMARY:"CLOUDY"} ICON
    //buacar una libreria org.Json.simple.*

}
