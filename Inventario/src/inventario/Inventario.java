/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

    import Interfaz.UI_Login;
    import bdpostgresql.database_inventario;

public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        database_inventario db = new database_inventario();
        if (db.conectarme() == true){
            UI_Login Fram = new UI_Login();
            Fram.setVisible(true);
            Fram.setLocationRelativeTo(null);
        }
     }
    
}
