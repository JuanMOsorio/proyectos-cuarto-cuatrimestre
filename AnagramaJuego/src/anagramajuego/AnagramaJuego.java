package anagramajuego;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.UIManager;

public class AnagramaJuego {
    Random aleatorio = new Random();
    String palabraActual;
    ArrayList palabras = new ArrayList();
    LeerArchivo la = new LeerArchivo("palabras.txt");
    AnagramaJuego(){
        String palabra = la.leerLinea();
        while(palabra != null){
            palabras.add(palabra);
            palabra = la.leerLinea();
        }
    }
    public String elegirPalabra(){
        if(palabras.size() > 0){
            int numal = aleatorio.nextInt(palabras.size());
            return (String)palabras.remove(numal);
        } else {
            return null;
        }
    }
    public String revolverPalabra(){
        ArrayList<Character> entrada = new ArrayList();
        ArrayList<Character> salida = new ArrayList();
        palabraActual = this.elegirPalabra();
        String palabraFinal = "";
        if(palabraActual != null){
            int num = 0;
            while(true){
                try{
                    entrada.add(palabraActual.charAt(num));
                    num++;
                }catch(IndexOutOfBoundsException err){
                    break;
                }
            }
            int tamano = entrada.size();
            while(salida.size() != tamano){
                int numal = aleatorio.nextInt(entrada.size());
                salida.add(entrada.remove(numal));
            }
            
            for(char l : salida){
                palabraFinal+=l;
            }
            return palabraFinal;
            
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
       try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       } catch(Exception err){
           System.out.println(err.getMessage());
       }
        new GUI().setVisible(true);
    }
    
}
