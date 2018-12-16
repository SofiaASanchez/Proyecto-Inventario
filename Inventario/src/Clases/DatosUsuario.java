
package Clases;


public class DatosUsuario {
    static String nombre="";
    static String permiso="";
    static String id="";
    static String idProducto = "";
    static int cantidad=0;
    public DatosUsuario() {
    
    }

    
    
    public static void datos(String nombre, String permiso) {
    DatosUsuario.nombre = nombre;
    DatosUsuario.permiso = permiso;
    }
    
    public static void id(String id){
        DatosUsuario.id = id;
    }

    public static void setCantidad(int cantidad) {
        DatosUsuario.cantidad = cantidad;
    }

    public static int getCantidad() {
        return cantidad;
    }
    

    public static void setIdProducto(String idProducto) {
        DatosUsuario.idProducto = idProducto;
    }

    public static String getIdProducto() {
        return idProducto;
    }
    
    
    
    public static String getId() {
        return id;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getPermiso() {
        return permiso;
    }


    
    
}
