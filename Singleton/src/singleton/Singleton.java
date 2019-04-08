/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author Juan
 */
public class Singleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Single Felix = Single.getSingletonInstance("Felix LP");
        Single Fernando = Single.getSingletonInstance("EL Guero");
    }

}
