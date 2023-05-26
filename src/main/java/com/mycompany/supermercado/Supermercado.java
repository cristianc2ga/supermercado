
package com.mycompany.supermercado;
import view.View;
import model.Model;
import controller.Controller;
import model.Administrador_DB;
/**
 * @author CristianGarcia
 */
public class Supermercado {

    public static void main(String[] args) {
        View obj_view = new View(); 
        Model obj_model = new Model();
        Administrador_DB obj_DB = new Administrador_DB();
        Controller obj_Control = new Controller(obj_view, obj_model, obj_DB);    
    }
}
