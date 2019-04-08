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
public class Single {

    private String nombre;
    private static Single Single;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private Single(String nombre) {
        this.nombre = nombre;
        System.out.println("Mi nombre es: " + this.nombre);
    }

    public static Single getSingletonInstance(String nombre) {
        if (Single == null) {
            Single = new Single(nombre);
        } else {
            System.out.println("No se puede crear el objeto " + nombre + " "
                    + "porque ya existe un objeto de la clase Single");
        }

        return Single;
    }

}
