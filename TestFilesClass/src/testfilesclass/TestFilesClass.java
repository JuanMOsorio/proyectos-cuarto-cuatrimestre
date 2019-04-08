/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfilesclass;

import java.io.File;

/**
 *
 * @author Juan
 */
public class TestFilesClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("hello.txt");//verifica la exixtencia de los archivos.
        System.out.println("Does it exists? " + file.exists());//impromir en pantalla una pregunta.
        System.out.println("The file has " + file.length() + " bytes");//el tamaño del archivo.
        System.out.println("Can it be read? " + file.canRead());//si tiene permisos de lectura.
        System.out.println("Can it be written? " + file.canWrite());//si tiene permiso de escritura.
        System.out.println("Is it a directory? " + file.isDirectory());//si se trata de un directorio.
        System.out.println("Is it a file? " + file.isFile());//si se trata de un archivo.
        System.out.println("Is it absolute? " + file.isAbsolute());//si la ruta es absoluta.
        System.out.println("Is it hiden " + file.isHidden());//si el archivo esta oculto.
        System.out.println("Absolute path is " + file.getAbsolutePath());//indica la ruta.
        System.out.println("Last modified on " + new java.util.Date(file.lastModified()));//para saber cuando fue modificado.
    }

}
