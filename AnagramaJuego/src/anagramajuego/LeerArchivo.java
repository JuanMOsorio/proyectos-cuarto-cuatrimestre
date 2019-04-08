package anagramajuego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerArchivo {
    File archivo;
    FileReader fr;
    BufferedReader br;
    String palabraActual;
    LeerArchivo(String ruta){
        archivo = new File(ruta);
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public String leerLinea(){
        try {
            return br.readLine();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
