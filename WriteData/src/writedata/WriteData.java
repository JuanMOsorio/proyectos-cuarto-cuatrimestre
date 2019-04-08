/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writedata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Juan
 */
public class WriteData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        File file = new File("j.txt");
        if (file.exists()) {//si el archivo esxite.
            System.out.println("File alredy exist: ");
//            System.exit(0);
            Scanner input = new Scanner(file);//para leer el objeto.
            while (input.hasNext()) {
                String firstName = input.next();//extrae el nombre
                String mi = input.next();//next espara buscar entre espacios
                String lastName = input.next();
                int score = input.nextInt();

                System.out.println(firstName + " " + mi + " " + lastName + " " + score);
            }
            input.close();
        } else {
            PrintWriter output = new PrintWriter(new FileOutputStream(file, true));//creacion de archivos.
            //escribir salidad formatead al archivo.
            output.print("John T Smith ");
            output.println(90);
            output.print("Erick K Jones ");
            output.println(85);
            
            output.print("Juan M Osorio ");
            output.println(100);

            output.close();

            System.out.println("file created!");
        }
    }
}
