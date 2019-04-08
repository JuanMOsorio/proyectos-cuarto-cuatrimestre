/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
            System.out.println("Name: " + name + " wieght: " + wieght + " Date: " + date);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateWriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateWriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateWriteRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
