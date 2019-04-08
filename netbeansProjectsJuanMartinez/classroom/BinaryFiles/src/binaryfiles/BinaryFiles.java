/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 *
 * @author Juan1
 */
public class BinaryFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CreateWriteRead c =  new CreateWriteRead();
        String fileName = "nuevo";
        c.create(fileName);
        c.write("Juan", 66.33, (new Date()));
        c.read();
    }
    
}
