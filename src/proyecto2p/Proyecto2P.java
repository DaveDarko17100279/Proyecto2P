
package proyecto2p;

import BD.*;
import Views.index;
import java.sql.Connection;


public class Proyecto2P {

    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
        new index().setVisible(true);
    }
    
}
