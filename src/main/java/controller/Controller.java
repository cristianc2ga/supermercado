/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Model.Cliente;

/**
 *
 * @author CristianGarcia
 */
public class Controller {
    public class ControladorClientes {
    private List<Cliente> clientes;
    private VistaClientes vista;
    
    public ControladorClientes() {
        clientes = new ArrayList<>();
        vista = new VistaClientes();
    }
    
    public void registrarCliente(String nombre, String cargo) {
        Cliente cliente = new Cliente(nombre, cargo);
        clientes.add(cliente);
    }
    
    public void mostrarClientes() {
        vista.mostrarClientes(clientes);
    }
}
}
