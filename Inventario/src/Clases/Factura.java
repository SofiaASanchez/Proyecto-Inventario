
package Clases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class Factura {

    
    
    private String fecha="";
    private String nombrecliente="";
    private String articulos="";
    private double total=0;
    private String rtn="";
    
    public Factura(String nombrecliente, String fecha, String articulos, double total, String rtn) {
        this.articulos=articulos;
        this.nombrecliente=nombrecliente;
        this.fecha=fecha;
        this.total=total;
        this.rtn=rtn;
    }

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getArticulos() {
        return articulos;
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public static void formatofactura(String producto, String total, String cliente, String rtn, String fecha, String numF){
            String titulo="**********************************************************\r\n" +
"                   Factura Inventario\r\n" +
"**********************************************************\r\n";
            String despedida="\r\n**********************************************************\r\n" +
"                     Hasta Pronto\r\n" +
"**********************************************************";

            
        String ClienteMSJ = "Al Cliente: "+cliente+"\r\n";
        String fechaCompra = "Fecha de Compra: "+fecha;
        
        
        String factura = titulo+"#Factura: "+numF+"\r\n"+producto+"\r\n"+ClienteMSJ+"RTN: "+rtn+"\r\n"+fechaCompra+"        Total: "+total+"\r\n"+despedida;
        Fechas.imprimir(factura, numF);
        System.out.print(factura);
        JOptionPane.showMessageDialog(null, "Factura Impresa con Exito");
      
    }
    
}
