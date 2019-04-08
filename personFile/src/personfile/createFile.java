/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan1
 */
public class createFile {

    private PrintWriter output;//salida lo que almacenara el nombre del archivo
    private String filename;//obtendra el nombre del archivo
    private File file;//varible de tipo File, lo almacena

    public createFile() throws FileNotFoundException {//constructor
        menu();//inicializa el metodo run
    }

    public void createFile(File file) throws FileNotFoundException {//metodo para crear archivo tiene un parametro File
        if (!file.exists()) {//si el archivo esxite.
            output = new PrintWriter(new FileOutputStream(file, true));//creacion de archivos.
            JOptionPane.showMessageDialog(null, "file created!");//mensaje de archivo creado
        } else {//si no
            JOptionPane.showMessageDialog(null, "The file alredy exits!");//mensaje de archivo exixtente
        }
    }

    public void writeFile(String dni, String name, String lastName, String birthDay, String place, File file) throws FileNotFoundException {//metodo para escribir sobre el archivo ya creado        
        output = new PrintWriter(new FileOutputStream(file, true));//creacion de archivos.
        output.print(dni + " " + name + " " + lastName + " ");//escritura de el archivo 
        output.println(birthDay + " " + place);
        output.close();//se ciera el archivo.
    }

    public void readFile(File file) throws FileNotFoundException {//metodo para leer el archivo
        String cont = "";
        if (file.exists()) {//si el archivo esxite.
            Scanner input = new Scanner(file);//para leer el objeto. lo cobiret en una entrada
            while (input.hasNext()) {//si existe datos
                String dni = input.next();//extrae el nombre
                String name = input.next();//next espara buscar entre espacios
                String lastName = input.next();//extrae el apellido
                String birthDay = input.next();
                String place = input.next();
                cont += dni + " " + name + " " + lastName + " " + birthDay + " " + place + "\n";
            }
            JOptionPane.showMessageDialog(null, cont);
            input.close();//cierra la entrada de datos
        }
    }

    public void menu() throws FileNotFoundException {//metodo para realizar un menu
        Object[] botones = {"Create", "Write", "Read", "Exit"};
        int option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        while (option != 3) {//condion para 4
            switch (option) {
                case 0: {//crea el archivo
                    filename = JOptionPane.showInputDialog("name file: ");
                    file = new File(filename + ".txt");//asigna el nombre al archivo
                    createFile(file);//crea el archivo
                    option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[1]);//menu
                    break;
                }
                case 1: {
                    if (filename == null) {//escribe en un archivo ya existente
                        JOptionPane.showMessageDialog(null, "no found \ncreate a file!");
                        option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);//menu
                        break;
                    }
                    String dni = JOptionPane.showInputDialog("dni: ");//obtine datos.
                    String names = JOptionPane.showInputDialog("name: ");
                    String lastName = JOptionPane.showInputDialog("lastname: ");
                    String birthDay = JOptionPane.showInputDialog("birthday: ");
                    String place = JOptionPane.showInputDialog("place: ");
                    writeFile(dni, names, lastName, birthDay, place, file);//crea los arcivos

                    option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[2]);//menu
                    break;
                }
                case 2: {//lee un archivo ya existente
                    if (filename != null) {//si no existe 
                        readFile(file);//lee el archivo
                        option = JOptionPane.showOptionDialog(null, "Chose a option!!", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[3]);//menu
                    }//checar Erro de despues de lectura
                    if (filename == null) {
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
