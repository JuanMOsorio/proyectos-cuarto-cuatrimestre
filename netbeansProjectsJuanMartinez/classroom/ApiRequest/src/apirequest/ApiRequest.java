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

/**
 *
 * @author Juan1
 */
public class ApiRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.darksky.net/forecast/0cbec9ed87f9c88237e7ee3e964690f5/37.8267,-122.4233");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP error code: " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output = "";

            while ((output = br.readLine()) != null) {
                System.out.println(output);   
            }
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Error MalformedURL " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IOException " + ex.getMessage());
        }
    }
    //(CURENTLY:{ SUMARY:"CLOUDY"} ICON
    //buacar una libreria org.Json.simple.*
    

}
