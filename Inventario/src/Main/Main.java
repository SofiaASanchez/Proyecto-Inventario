
package Main;

import BDPostgreSQL.ConexionBD;
import InterFazLogIn.UI_Login;


public class Main {

    
    public static void main(String[] args) {
        ConexionBD enlace = new ConexionBD();
         if (enlace.conectarme() == true){
            UI_Login Fram = new UI_Login();
            Fram.setVisible(true);
            Fram.setLocationRelativeTo(null);
        
       }
    
    }
    }

