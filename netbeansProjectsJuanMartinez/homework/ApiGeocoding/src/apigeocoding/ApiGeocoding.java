/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apigeocoding;

import view.ApiRequest;
import view.Weather;

/**
 *
 * @author Juan1
 */
public class ApiGeocoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Weather weather = new Weather();
        weather.setVisible(true);
        weather.setLocationRelativeTo(null);

        ApiRequest a = new ApiRequest();
        String locat= "tehuacanpuebla";
        a.getRequestMaps(locat);
    }

}
