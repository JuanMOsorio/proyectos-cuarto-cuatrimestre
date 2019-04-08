/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class Agenda implements Serializable {

    public static final int MAX = 100;
    private ItemAgenda[] elArray;
    private int num;//contralar la posicion del arreglo

    public Agenda() {
        elArray = new ItemAgenda[MAX];
        num = 0;
    }

    public void insertar(ItemAgenda ia) {
        elArray[num] = ia;
        num++;
    }

    public void buscar(String n) {
//        if (elArray[0] == n) {
//
//            System.out.println(elArray[0]);
////            num++;
//        } else {
//            System.out.println("no");
//        }
        ItemAgenda nombre = null;
        if (nombre.nom == n) {
            System.out.println(elArray[0]);
        } else {
            System.out.println("no");
        }

    }

    public String toString() {
        String res = "";
        for (int i = 0; i < num; i++) {
            res += "\n" + elArray[i] + "\n";
            res += "==========================";
        }
        return res;
    }

    public void guardarAgenda(String fich) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fich)));
            oos.writeObject(this);
            oos.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FILENOTFOUND " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOEXCEPTION " + ex.getMessage());
        }
    }

    public static Agenda leerAgenda(String fich) {
        Agenda aux = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
            aux = (Agenda) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FILENOTFOUND " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOEXCEPTION " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "CLASSNOTFOUND   " + ex.getMessage());
        }
        return aux;
    }

    /*
    Escribir  dos metodos de busqueda uno por nombre y tro por telefono
    ambas opraciones devolvran el prinmer ItemAgenda que cumpla con la condicion
    en caso de que exista o nullñ en el caso de que no sea asi
     */
    public void buscarItemNombre(String nombre) {
        for (int i = 0; i < num; i++) {
            if (elArray[i].nom == nombre) {
                System.out.println("Buscar Item por nombre->(" + nombre + ")<-: " + elArray[i]);
            }
        }
    }

    public void buscarItemTel(String tel) {
        for (int i = 0; i < num; i++) {
            if (elArray[i].tel == tel) {
                System.out.println("Buscar Item por telefono->(" + tel + ")<-: " + elArray[i]);
            }
        }
    }

}
