/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edog;

/**
 *
 * @author Juan
 */
public class Dog {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public int ageDogsToAgeHumans() {
       return age * 7;
    }
    
    public String toString() {
        return "Nombre: " + name + "\nEdad: " + age + "\nEdad en años Humanos: " + ageDogsToAgeHumans();
    }

}
