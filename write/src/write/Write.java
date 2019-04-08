/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package write;

import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Juan
 */
public class Write {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        File file = new File("scores.txt");

        PrintWriter output = new PrintWriter(file);//creacion de archivos.
        //escribir salidad formatear al archivo.
        output.print("John T Smith");
        output.println(90);
        output.print("Erick K Jones");
        output.println(85);

        output.close();
    }

}
