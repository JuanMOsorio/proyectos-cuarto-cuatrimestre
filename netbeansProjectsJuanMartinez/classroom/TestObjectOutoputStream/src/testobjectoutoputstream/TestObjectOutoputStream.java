/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectoutoputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
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
public class TestObjectOutoputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CREATE AN OUTPUT STREAM THE FILE
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //WRITE A STRING, DOUBLE VALUE, AND OBJECT TO THE FILE
            output.writeUTF("Juan Martinez Osorio");
            output.writeDouble(68.8);
            output.writeObject(new Date());
            //close output stream
            output.close();//
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of NOTFOUND" + ex.getMessage());
//            Logger.getLogger(TestObjectOutoputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(TestObjectOutoputStream.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "There is an error of IO" + ex.getMessage());
        }

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
            String name = input.readUTF();
            double wieght = input.readDouble();
            Date date =  (Date) input.readObject();
            System.out.println("Name: "+name+" wieght: "+wieght+" Date: "+date);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of NOTFOUND" + ex.getMessage());
//            Logger.getLogger(TestObjectOutoputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of NOTFOUND" + ex.getMessage());
//            Logger.getLogger(TestObjectOutoputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestObjectOutoputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
