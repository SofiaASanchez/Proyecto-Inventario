
package Clases;


import BDPostgreSQL.ConexionBD;
import javax.swing.*;
import java.sql.*;

public class VerificarUsuario {

    private String id;
    private String contra;
    
    public VerificarUsuario() {
        
    }
    
    
    public VerificarUsuario(String id, String contra) {
        this.id=id;
        this.contra=contra;
    }

    public int tipoUsuario(String id, String contra){
    
    int tipo=0;
    
        ConexionBD enlace = new ConexionBD();
        Connection conex = enlace.conexion();
        
        try{
           // Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            PreparedStatement datos = conex.prepareStatement("Select \"tipoPermiso\" from usuarios where id ='"+id+"' And contra='"+contra+"'");
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
 
    public int validarUsuario(String id, String cont){
        ConexionBD enlace = new ConexionBD();
        Connection conex = enlace.conexion();
        int dec=0;
        
        try{
           // Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            PreparedStatement datos = conex.prepareStatement("SELECT contra, id FROM usuarios WHERE contra='"+cont+"'");
            ResultSet rs = datos.executeQuery();
            rs.next();
            
          if(rs.getString("id").equals(id)){
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
