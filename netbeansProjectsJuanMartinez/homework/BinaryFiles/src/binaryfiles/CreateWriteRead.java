/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class CreateWriteRead {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String fileName;

    public CreateWriteRead() {
        menu();
    }

    public void create(String file) {
        //CREATE AN OUTPUT STREAM THE FILE
        try {
            fileName = file + ".dat";
            output = new ObjectOutputStream(new FileOutputStream(fileName));
            //WRITE A STRING, DOUBLE VALUE, AND OBJECT TO THE FILE
            //close output stream
//            output.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of NOTFOUND" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of IO" + ex.getMessage());
        }
    }

    public void write(String name, double peso, Date date) {
        try {
            output.writeUTF(name);
            output.writeDouble(peso);
            output.writeObject(date);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of NOT FOUND" + ex.getMessage());
        }
    }

    public void read() {
        try {
            input = new ObjectInputStream(new FileInputStream(fileName));
            String name = input.readUTF();
            double wieght = input.readDouble();
            Date date = (Date) input.readObject();
            JOptionPane.showMessageDialog(null, "Name: " + name + " wieght: " + wieght + " Date: " + date);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error FILENOTFOUND" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error IO" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error CLASSNOTFOUND" + ex.getMessage());
        }
    }

    public void menu() {
        Object[] botones = {"Create", "Write", "Read", "Exit"};
        int option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        while (option != 3) {//condion para 4
            switch (option) {
                case 0: {//crea el archivo
                    fileName = JOptionPane.showInputDialog("name file: ");
                    create(fileName);//crea el archivo
                    option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[1]);//menu
                    break;
                }
                case 1: {
                    if (fileName == null) {//escribe en un archivo ya existente
                        JOptionPane.showMessageDialog(null, "no found \ncreate a file!");
                        option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);//menu
                        break;
                    }
                    String name = JOptionPane.showInputDialog("Nombre: ");//obtine datos.
                    String peso = JOptionPane.showInputDialog("Peso: ");
                    double pesoD = Double.parseDouble(peso);
                    Date date = (new Date());
                    write(name, pesoD, date);//crea los arcivos
                    option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[2]);//menu
                    break;
                }
                case 2: {//lee un archivo ya existente
                    if (fileName != null) {//si no existe 
                        read();//lee el archivo
                        option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[3]);//menu
                    }//checar Erro de despues de lectura
                    if (fileName == null) {
                        JOptionPane.showMessageDialog(null, "no found\ncreate a file!");//mensaje de no se encontro
                        option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);//menu   
                    }
                    break;
                }
                case 3: {
                    System.exit(0);//sale del proyecto.
                    break;
                }
            }

        }
    }
}
