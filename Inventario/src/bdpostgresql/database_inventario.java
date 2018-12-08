/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpostgresql;

    import javax.swing.*;
    import java.sql.*;

public class database_inventario {
    Connection conexion = null;
    
    String pass = "123";
    String user = "postgres";
    
    public boolean conectarme(){
        try{
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Inventario",user,pass);
            JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION, IMPOSIBLE CONTINUAR");
            return false;
        }
    }
}
