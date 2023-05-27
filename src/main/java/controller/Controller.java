package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.View;
import model.Model;
import model.Administrador_DB;

public class Controller {
    private Model obj_model;
    private View obj_view;
    private Administrador_DB obj_DB;
    boolean confirmacion;
    
    public Controller(View obj_view, Model obj_model, Administrador_DB obj_DB) {
        this.obj_view = obj_view;
        this.obj_model = obj_model;
        this.obj_DB = obj_DB;
        this.obj_view.btnRegistrar.addActionListener(btn_registrar);
        this.obj_view.btnConsultar.addActionListener(btn_consultar);
        start_view();
        confirmacion = obj_DB.connect();
    };
    
    public void start_view(){
        obj_view.setVisible(true);
        obj_view.setLocationRelativeTo(null);
        String[] cargos = {"Todos", "Administrador", "Cliente", "Cliente Especial", "Gerente", "Cajero", "Mensajero", "Bodeguero"};
        obj_view.listaCargos.setModel(new DefaultComboBoxModel<>(cargos));

    };
    public void establish_user(){
        obj_model.setNombre(obj_view.txtNombre.getText());
        obj_model.setIdentificacion(Integer.parseInt(obj_view.txtIdentificacion.getText()));
        obj_model.setCargo(obj_view.txtCargo.getText());
    };
     public void clean_view () {
        obj_view.txtNombre.setText("");
        obj_view.txtIdentificacion.setText("");
        obj_view.txtCargo.setText("");

    }
    ActionListener btn_registrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (confirmacion){                
                establish_user();            
                obj_DB.register(obj_model.getNombre(), obj_model.getIdentificacion(), obj_model.getCargo());
                clean_view();
            }      
            else {
                JOptionPane.showMessageDialog(null, "There is an error with the database connection");
            }
        }
    };
    ActionListener btn_consultar = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Identification");
        model.addColumn("Role");

        String selectedCargo = (String) obj_view.listaCargos.getSelectedItem();

        if (confirmacion) {
            if (selectedCargo.equals("Todos")) {
                ArrayList<String> array_users = obj_DB.getUsers();
                //System.out.println(array_users);
                for (String user : array_users) {
                    String[] userData = user.split(";");                    
                    model.addRow(new Object[]{userData[1],userData[0], userData[2]});
                }
            } else {
                ArrayList<String> array_users = obj_DB.getUsersByRole(selectedCargo);
                //System.out.println(array_users);
                for (String user : array_users) {
                    String[] userData = user.split(";");
                    model.addRow(new Object[]{userData[1], userData[0], userData[2]});
                }
            }

            obj_view.textTabla.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "There is an error with the database connection");
        }
        }
    };



}
