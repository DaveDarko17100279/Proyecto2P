
package proyecto2p;

import BD.*;
import Models.usuarioGeneral;
import Views.Login;
import Views.index;
import Views.Menu;
import java.sql.Connection;


public class Proyecto2P {

    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
        new index().setVisible(true);
    }
    
}
