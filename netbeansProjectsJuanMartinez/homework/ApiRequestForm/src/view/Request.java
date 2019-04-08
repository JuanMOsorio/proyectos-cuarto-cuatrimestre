/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

/**
 *
 * @author Juan1
 */
public class Request {

    Double latidud;
    Double longitud;
    String timeZone;
    Object time;
    String summary;
    String icon;

    public void getRequest(String latitude, String longitude) {
        try {
            URL url = new URL("https://api.darksky.net/forecast/0cbec9ed87f9c88237e7ee3e964690f5/" + latitude + "," + longitude + "");
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
//            latidud = (Double) jObejct.get("latitude");
//            longitud = (Double) jObejct.get("longitude");
            timeZone = (String) jObejct.get("timezone");
//            System.out.println("Latitude: " + latidud + "\nLongitude: " + longitude + "\nTimezone" + timeZone);
            /////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////
            JSONObject objectCurrently = (JSONObject) jObejct;
            Object currently = (Object) objectCurrently.get("currently");
            JSONObject countainCurretly = (JSONObject) currently;
            time = (Object) countainCurretly.get("time");
            summary = (String) countainCurretly.get("summary");
            icon = (String) countainCurretly.get("icon");

//            System.out.println("Time: " + time + "\nSummary: " + summary + "\nIcon: " + icon);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error MalformedURL " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IOException " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
