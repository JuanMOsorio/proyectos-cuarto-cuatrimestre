/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconverter;

import java.io.FileNotFoundException;

/**
 *
 * @author Juan1
 */
public class FileConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Convert file = new Convert();
        file.open();
        file.countain();
        file.convert();
    }

}
