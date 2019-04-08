/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class PersonDao {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String fileName = "people.dat";

    public ArrayList<Person> listPerson() {
        ArrayList listPerson = new ArrayList();
        Person person;
        try {
            input = new ObjectInputStream(new FileInputStream("people.dat"));
            String lastName = input.readUTF();
            String name = input.readUTF();
            String date = input.readUTF();
            String place = input.readUTF();

            person = new Person();
            person.setLastName(lastName);
            person.setName(name);
            person.setDate(date);
            person.setPlace(place);
            listPerson.add(person);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPerson;
    }

    //end listPerson
    public void insertPerson(String LastName, String name, String date, String place) {

        try {

            //error vueleve a crear el archivo.........
            output = new ObjectOutputStream(new FileOutputStream(fileName));
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            output.writeUTF("\n" + LastName);
            output.writeUTF("\n" + name);
            output.writeUTF("\n" + date);
            output.writeUTF("\n" + place);

            output.close();//
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//end insertperson

    public void deltePerson(String LastName, String name, String date, String place) {

        try {
            output = new ObjectOutputStream(new FileOutputStream(fileName));
            output.writeUTF("");
            output.writeUTF("");
            output.writeUTF("");
            output.writeUTF("");
            output.close();//
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
