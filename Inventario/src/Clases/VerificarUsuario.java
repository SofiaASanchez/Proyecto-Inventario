
package Clases;


import BDPostgreSQL.ConexionBD;
import javax.swing.*;
import java.sql.*;

public class VerificarUsuario {

    private String nombre;
    private String contra;
    
    public VerificarUsuario() {
        
    }
    
    
    public VerificarUsuario(String nombre, String contra) {
        this.nombre=nombre;
        this.contra=contra;
    }

    public int tipoUsuario(String nombre, String contra){
    
    int tipo=0;
    
        ConexionBD enlace = new ConexionBD();
        Connection conex = enlace.conexion();
        
        try{
           // Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            PreparedStatement datos = conex.prepareStatement("Select \"tipoPermiso\" from usuarios where nombre ='"+nombre+"' And contra='"+contra+"'");
            ResultSet rs = datos.executeQuery();
            rs.next();
          
            if(rs.getString("tipoPermiso").equals("1")){
                  tipo=1;
            }
           else{
              tipo=0;
          }
          
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Datos no Validos");
        }
    return tipo;
}
 
    public int validarUsuario(String nom, String cont){
        ConexionBD enlace = new ConexionBD();
        Connection conex = enlace.conexion();
        int dec=0;
        
        try{
           // Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            PreparedStatement datos = conex.prepareStatement("SELECT contra, nombre FROM usuarios WHERE contra='"+cont+"'");
            ResultSet rs = datos.executeQuery();
            rs.next();
            
          if(rs.getString("nombre").equals(nom)){
              dec=1;
          }else{
              dec=0;
          }
        }catch(Exception e){
            
            //JOptionPane.showMessageDialog(null, "Datos no Validos");
        }
        
        return dec;
        
    }
            
}
