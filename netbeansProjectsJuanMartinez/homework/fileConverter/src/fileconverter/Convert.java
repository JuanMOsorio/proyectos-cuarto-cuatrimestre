/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class Convert {

    private File file;
    private Scanner input;
    private PrintWriter output;
    private String title, h1, h2, p, p2;

    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                input = new Scanner(file);
                while (input.hasNext()) {
//                    System.out.println(input.nextLine());
                    title = input.nextLine();
                    h1 = input.nextLine();
                    h2 = input.nextLine();
                    p = input.nextLine();
                    p2 = input.nextLine();
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file selected");
        }
    }

    public void countain() throws FileNotFoundException {
        int acum = 0, count = 0;
        try {
            input.close();
            input = new Scanner(file);
            while (input.hasNext()) {
                input.next();//recorre las las palabras
                count = acum + 1;//cuenta la cantidad de palabras
                acum++;//acumula la cantidad
            }
            System.out.println("words = " + count);
//            input.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }

    public void convert() throws FileNotFoundException {
//        System.out.println(file);
        file = new File(this.file + ".html");
        output = new PrintWriter(new FileOutputStream(file, true));
        if (file.exists()) {
            output.println("<!DOCTYPE html>");
            output.println("    <head>\n"
                    + "        <title>" + title + "</title>\n"
                    + "    </head><body><h1>" + h1 + "</h1></br><h2>" + h2 + "</h2><br>"
                            + "<p>" + p + "<p/><br><p>" + p2 + "<p/></body>\n");
            JOptionPane.showMessageDialog(null, "file created!");//mensaje de archivo creado
        }
        output.close();
    }
}
