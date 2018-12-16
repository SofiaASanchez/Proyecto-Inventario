package Clases;


public class Proveedor {

    private String id_proveedor;
    private String nombre;
    private String descripcion;

    public Proveedor(String id_proveedor, String nombre, String descripcion) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Proveedor(){}
    
    public String getId_proveedor() {
        return id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
