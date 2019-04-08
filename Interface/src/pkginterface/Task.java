/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

/**
 *
 * @author Juan
 */
public class Task implements Priority{

    private String Priority = "";
    String nombre = "juan";
    String[] task = new String[5];

    public String getPriority() {
        return Priority;
    }

    public void setPriority(int num) {
        task[0] = "Desayunar";
        task[1] = "Limpiar";
        task[2] = "Correr";
        task[3] = "Estudiar";
        task[4] = "Tarea";
        this.Priority = task[num];
        System.out.println(Priority);
    }
}
