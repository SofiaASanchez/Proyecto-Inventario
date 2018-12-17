
package Clases;

import BDPostgreSQL.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class BdOption {
    ConexionBD enlace = new ConexionBD();

    public BdOption() {
    
    }
    
     
    public void eliminar_usuario(String dato){
 
        Connection conex = enlace.conexion();
                
        try{
            Statement con = conex.createStatement();
            String orden = "DELETE FROM public.usuarios WHERE Id = "+"'"+dato+"'"+";";
            con.executeUpdate(orden);
            JOptionPane.showMessageDialog(null, "Eliminado correctamente de la base de datos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }   
    public void eliminar_producto(String dato){
        
        Connection conex = enlace.conexion();
        
        try{
            Statement con = conex.createStatement();
            String orden = "DELETE FROM public.producto WHERE id_producto = "+"'"+dato+"'"+";";
            con.executeUpdate(orden);
            JOptionPane.showMessageDialog(null, "Eliminado correctamente de la base de datos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }   
    public void eliminar_proveedor(String dato){
        
        Connection conex = enlace.conexion();
        
        try{
            Statement con = conex.createStatement();
            String orden = "DELETE FROM public.proveedor WHERE id_proveedor = "+"'"+dato+"'"+";";
            con.executeUpdate(orden);
            JOptionPane.showMessageDialog(null, "Eliminado correctamente de la base de datos");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }   
    public String updateUsuario(String id, Usuario datos){
        String mensaje="";
        Connection conex = enlace.conexion();
        try {
            Statement st = conex.createStatement();
            String orden = "UPDATE usuarios\n" +
"	SET id="+datos.getId_persona()+", nombre="+datos.getNombre()+", apellido ="+datos.getApellido()+", direccion= "+datos.getDireccion()+", telefono="+datos.getTelefono()+", \"fecha_Naci\"="+datos.getFecha_nacimiento()+",contra="+datos.getContrasena()+", \"tipoPermiso\"="+datos.getTipo_usuario()
                    + "	WHERE id="+id+";";
            //System.out.print(orden);
                    
                    
                    
            
            mensaje="Actualizado correctamente";
            ResultSet rs = st.executeQuery(orden);
     
        } catch (SQLException e) {
            mensaje="Actualizado correctamente";
            //System.out.print(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
        return mensaje;
    }
    public String updateProducto(Producto datos){
        
        String mensaje ="";
        Connection conex = enlace.conexion();
        
        try {
            Statement st = conex.createStatement();
            String orden = "UPDATE public.producto\n" +
"	SET nombre="+datos.getNombreProducto()+", id_producto="+datos.getIdProducto()+", categoria="+datos.getCategoria()+", precio="+datos.getPrecio()+", cantidad="+datos.getCantidad()+"\n" +
"	WHERE id_producto = '"+DatosUsuario.getIdProducto()+"';";
            //System.out.print(orden);
                    
                    
                    
            
            mensaje="Actualizado correctamente";
            ResultSet rs = st.executeQuery(orden);
     
        } catch (SQLException e) {
            mensaje="Actualizado correctamente";
            //System.out.print(e);
            //JOptionPane.showMessageDialog(null, e);
        }
        
        return mensaje;
    } 
    public String ingresarArticulos(Producto dato){
        Connection conex = enlace.conexion();
        String mensaje="";
        
        try{
            //Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            Statement con = conex.createStatement();
            String orden = "INSERT INTO public.producto(\n" +
                           " nombre, id_producto, categoria, precio, cantidad, proveedor)" +
                           "VALUES ("+dato.getNombreProducto()+","+dato.getIdProducto() +","+dato.getCategoria()+","+dato.getPrecio()+","+dato.getCantidad()+","+dato.getProveedor()+");";
            con.executeUpdate(orden);
            mensaje="Articulo Guardado con Exito";
            
            
        }catch(Exception e){
            
            //JOptionPane.showMessageDialog(null, e);
            mensaje="Algo Salio mal Verifica tus datos";
        }
        
        return mensaje;
    }
    public String ingresarUsuario(Usuario usuario){
        String mensaje="";
        Usuario dato= usuario;
        
        Connection conex = enlace.conexion();
        try{
            
            Statement con = conex.createStatement();
            String orden="INSERT INTO usuarios(\n" +
                         "id, nombre, apellido, direccion, telefono, \"fecha_Naci\", contra, \"tipoPermiso\")\n" +
                         "VALUES ("+dato.getId_persona()+", "+dato.getNombre() +", "+dato.getApellido()+", \n"+
                          dato.getDireccion()+", "+dato.getTelefono()+", "+dato.getFecha_nacimiento()+",\n"+
                          dato.getContrasena()+", "+dato.getTipo_usuario()+" );";
            
            con.executeUpdate(orden);
            mensaje = "Guardado Con EXITO";
          
        }catch(Exception e){
            
            mensaje = e.getMessage();
        }
        
        return mensaje;
    }
    public String ingresarFactura(Factura factura){
        String mensaje="";
        Connection conex = enlace.conexion();
        try{
            
            Statement con = conex.createStatement();
            String orden="INSERT INTO public.factura(\n" +
                          "fecha, nombre, productos, total, rtn)\n" +
                          "VALUES ('"+factura.getFecha()+"','"+factura.getNombrecliente()+"','"+factura.getArticulos()+"' ,'"+factura.getTotal()+"', '"+factura.getRtn()+"' );";
            
            con.executeUpdate(orden);
            //JOptionPane.showMessageDialog(null, "Guardado Con EXITO");
            
            orden = "SELECT numfac \n" +
                           "FROM public.factura WHERE nombre='"+factura.getNombrecliente()+"';";
            
            ResultSet rs = con.executeQuery(orden);
            rs.next();
            mensaje =rs.getString("numfac");
          
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return mensaje;
    }   
    public String ingresarProveedor(Proveedor dato){
        String mensaje="";
        
        Connection conex = enlace.conexion();
        
        try{
            //Connection conex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/inventarios", "postgres", "123");
            Statement con = conex.createStatement();
            String orden = "INSERT INTO public.proveedor(\n" +
                           " id_proveedor, \"nombreProveedor\", descripcion)" +
                           "VALUES ("+dato.getId_proveedor()+","+dato.getNombre() +","+dato.getDescripcion()+");";
            con.executeUpdate(orden);
            mensaje="Proveedor Guardado con Exito";
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            mensaje="Algo Salio mal Verifica tus datos";
        }
        
        return mensaje;
       
    }
    
    public void restaBD(String idP, String cant ){
        Connection conex = enlace.conexion();
        /*SELECT cantidad
	  FROM public.producto WHERE id_producto ='00012';*/
        int total;
        try {
            
            Statement st1 = conex.createStatement();
            String orden1="SELECT cantidad\n" +
"	  FROM public.producto WHERE id_producto ='"+idP+"';";
           
            ResultSet rs1 = st1.executeQuery(orden1);
            rs1.next();
            
            int cantB = Integer.parseInt(rs1.getString("cantidad"));
            int cantV = Integer.parseInt(cant);
            
            total=cantB-cantV;
             Ac(total, idP);
            
            
        } catch (Exception e) {
        }
       
   
    } 
    public void sumaBD(String idP,String cant){
        Connection conex = enlace.conexion();
        /*SELECT cantidad
	  FROM public.producto WHERE id_producto ='00012';*/
        int total;
        try {
            
            Statement st1 = conex.createStatement();
            String orden1="SELECT cantidad\n" +
"	  FROM public.producto WHERE id_producto ='"+idP+"';";
           
            ResultSet rs1 = st1.executeQuery(orden1);
            rs1.next();
            
            int cantB = Integer.parseInt(rs1.getString("cantidad"));
            int cantV = Integer.parseInt(cant);
            
            total=cantB+cantV;
             Ac(total, idP);
            
            
        } catch (Exception e) {
        }
    }
    public void Ac(int total, String idP){
        try {
            Connection conex = enlace.conexion();
                Statement st = conex.createStatement();           
                String orden = "UPDATE public.producto\n" +
                        "	SET  cantidad="+total+"\n" +
                        "	WHERE id_producto = '"+idP+"';";
            //System.out.print(orden);
                    

            ResultSet rs = st.executeQuery(orden);
     
        } catch (SQLException e) {
            
            //System.out.print(e);
            //JOptionPane.showMessageDialog(null, e);
        }
    }
}
