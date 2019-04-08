/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readfileusingjfilechosooer;

import java.io.File;//para los archivo
import java.io.FileNotFoundException;
import java.util.Scanner;//para leer 
import javax.swing.JFileChooser;//muestar el cuadro de exploracion de archivos.
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class Readfileusingjfilechosooer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser fileChooser = new JFileChooser();
        int count = 0;
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {//
            //get the seleted file
            File file = fileChooser.getSelectedFile();//todo lo refernete al file
            try {
                //create a file
                Scanner input = new Scanner(file);//crea el archivo
                //Read text from the file
                while (input.hasNext()) {//mientras hay palabras
                    System.out.println(input.nextLine());//imprime las lineas
                }
                input.close();//cierra el documento
                input = new Scanner(file);//abre el documento
                while (input.hasNext()) {
                    input.next();//recorre las las palabras
//                    count = acum + 1;//cuenta la cantidad de palabras
                    count++;//acumula la cantidad
                }
                System.out.println("words = " + count);
                input.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No File seleted");
        }

    }
}
