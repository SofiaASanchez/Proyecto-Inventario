
package Clases;


public class Producto {
    
    private String nombreProducto, idProducto, categoria, proveedor;
    private int cantidad;
    double precio;
    
    public Producto() {
    
    }
    
    public Producto(String nombreProducto, String idProducto, String categoria, double precio, int cantidad, String proveedor ) {
        
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedor= proveedor;
                
    }
    public Producto(String nombreProducto, String idProducto, String categoria, double precio, int cantidad) {
        
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
                
    }
    
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
 
    
}
