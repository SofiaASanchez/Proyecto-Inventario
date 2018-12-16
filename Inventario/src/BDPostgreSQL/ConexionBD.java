
package BDPostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionBD {
    private Connection conexion = null;
    
    private String pass = "123";
    private String user = "postgres";
    
    public boolean conectarme(){
        try{
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios",user,pass);
            JOptionPane.showMessageDialog(null, "Conectado a la base de datos");
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION, IMPOSIBLE CONTINUAR");
            return false;
        }
    }
    public Connection conexion(){
         try{
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios",user,pass);
            return conexion;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION, IMPOSIBLE CONTINUAR");
           
        }
         return conexion;
    }
    
}
