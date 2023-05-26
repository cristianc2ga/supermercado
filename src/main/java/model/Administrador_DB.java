package model;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;


public class Administrador_DB {
    
    private Connection obj_connection;
    private String user = "root";
    private String passw = "try2023";
    private String url = "jdbc:mysql://localhost:3306/supermercadodb";
    //private String database = "supermercadodb";
    
    public boolean connect(){
        try {
            obj_connection = DriverManager.getConnection(url, user, passw);
            JOptionPane.showMessageDialog(null, "Succesful Connection");
            return true;
        } catch (SQLException err) {
            System.out.println(err);
            JOptionPane.showMessageDialog(null, err);
            return false;
        }        
    }
    
    public void register(String nombre, int identificacion, String cargo) {
    String instruction = "INSERT INTO usuarios VALUES (?, ?, ?)";
    try {
        PreparedStatement statement = obj_connection.prepareStatement(instruction);
        statement.setInt(1, identificacion);
        statement.setString(2, nombre);
        statement.setString(3, cargo);
        
        statement.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
    } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, err);
    }
}

    
    public ArrayList<String> getUsers(){
        String instruction = "SELECT * FROM usuarios";
        ArrayList<String> array_users = new ArrayList<>();
        try {
            ResultSet data_table = obj_connection.prepareStatement(instruction).executeQuery();
            while(data_table.next()) {
                array_users.add(data_table.getString("nombre") + " " + data_table.getInt("identificacion")
                + data_table.getString("cargo"));
            }
            return array_users;
                    
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err);
            return null;
        }                
    }
    public ArrayList<String> getUsersByRole(String cargo) {
    String instruction = "SELECT * FROM usuarios WHERE cargo = ?";
    ArrayList<String> arrayUsers = new ArrayList<>();

    try {
        PreparedStatement statement = obj_connection.prepareStatement(instruction);
        statement.setString(1, cargo);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String user = resultSet.getString("nombre") + " " +
                    resultSet.getInt("identificacion") + " " +
                    resultSet.getString("cargo");
            arrayUsers.add(user);
        }

        return arrayUsers;

    } catch (SQLException err) {
        JOptionPane.showMessageDialog(null, err);
        return null;
    }
}

}

