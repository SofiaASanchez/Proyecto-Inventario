
package Clases;

import static java.awt.PageAttributes.MediaType.C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Fechas {
    
    
    public static String fechaName(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd_MM_YY H_mm");
        //System.out.print(formatoFecha.format(fecha));
        return formatoFecha.format(fecha);
       
    }
    
     public static String fechaBD(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YY H:mm");
        //System.out.print(formatoFecha.format(fecha));
        return formatoFecha.format(fecha);

     }
     
    public static String fechaSolo(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YY");
        //System.out.print(formatoFecha.format(fecha));
        return formatoFecha.format(fecha);
    }
    
    public static void imprimir(String texto, String nombreF){

        try {
            
            FileOutputStream archivo;
            PrintStream p;          
            archivo= new FileOutputStream("Factura "+nombreF+".txt");
            p= new PrintStream(archivo);
            p.append("\r\n");
            p.println(texto);
            
            p.close();

        } catch (FileNotFoundException e) { 
      }
    }
}
