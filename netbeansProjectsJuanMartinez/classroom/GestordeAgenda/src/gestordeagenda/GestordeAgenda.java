/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;

/**
 *
 * @author Juan1
 */
public class GestordeAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ItemAgenda ia1 = new ItemAgenda("Juan Martinez Osorio", "2381524116", 75855);
        ItemAgenda ia2 = new ItemAgenda("Mi compa naman", "2381694569", 75740);
        ItemAgenda ia3 = new ItemAgenda("Juan Carlos", "2385933744", 75742);

        //crear una agenda
        Agenda a1 = new Agenda();
        a1.insertar(ia1);
        a1.insertar(ia2);
        a1.insertar(ia3);

        //escribir el archivo
        a1.guardarAgenda("myAgenda.dat");

        //leer agenda
        Agenda resAgenda = Agenda.leerAgenda("myAgenda.dat");
        System.out.println(resAgenda);

        //buscar en agenda 
        //por nombre
        a1.buscarItemNombre("Juan Carlos");
        //buscar por telefono
        a1.buscarItemTel("2381524116");
    }

}
