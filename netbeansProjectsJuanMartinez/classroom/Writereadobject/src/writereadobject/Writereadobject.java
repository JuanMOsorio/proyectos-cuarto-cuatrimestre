/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;

import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class Writereadobject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Writes an object to a binary file

        ObjectOutputStream fileOut;
        TestObject obj = new TestObject(1, "text 1", 2.0);
        String fileName = JOptionPane.showInputDialog("Enter the file's name");

        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(fileName));
            fileOut.writeObject(obj);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFound " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException " + ex.getMessage());
        }
        //End write 

        TestObject objIn;
        try {
            //Read object from a binary file
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(fileName));
            objIn = (TestObject) fileIn.readObject();
            objIn.display();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFound " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFound " + ex.getMessage());
        }

    }

}
