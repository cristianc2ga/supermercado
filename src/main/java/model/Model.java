/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author CristianGarcia
 */
public class Model {
    public class Cliente {
    private String nombre;
    private String cargo;
    
    public Cliente(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getCargo() {
        return cargo;
    }
}
}
