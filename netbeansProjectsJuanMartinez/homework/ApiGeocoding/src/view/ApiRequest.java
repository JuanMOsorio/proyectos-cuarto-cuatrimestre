/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

/**
 *
 * @author Juan1
 */
public class ApiRequest {

    String timeZone;
    Object time;
    String summary;
    String icon;

    Object lat;
    Object lng;

    public void getRequestMaps(String locat) {
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + locat + "&key=AIzaSyBo25i09floq4pOVWC4evwdR1dlNq307gg");
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
                JSONData += output;
            }
            Object object = parser.parse(JSONData);//crea un objeto 
            JSONObject jObejct = (JSONObject) object;//crea un objeto de tipo jsonObject
            JSONArray results = (JSONArray) jObejct.get("results");//Extrae los elemetos de el array
            JSONObject formatted_address = (JSONObject) results.get(0);//obtiene el objeto del array

            JSONObject geometry = (JSONObject) formatted_address.get("geometry");//obtiene geometry
            JSONObject location = (JSONObject) geometry.get("location");//obtirne de de que localidad es          

            lat = (Object) location.get("lat");//latitud
            lng = (Object) location.get("lng");//longitud
            System.out.println("lat nad long" + lat + " + " + lng);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getRequestWeather(String latitude, String longitude) {
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
                JSONData += output;
            }
            Object object = parser.parse(JSONData);
            JSONObject jObejct = (JSONObject) object;
            timeZone = (String) jObejct.get("timezone");
            /////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////
            JSONObject objectCurrently = (JSONObject) jObejct;
            Object currently = (Object) objectCurrently.get("currently");
            JSONObject countainCurretly = (JSONObject) currently;
            time = (Object) countainCurretly.get("time");
            summary = (String) countainCurretly.get("summary");
            icon = (String) countainCurretly.get("icon");

        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error MalformedURL " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IOException " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
