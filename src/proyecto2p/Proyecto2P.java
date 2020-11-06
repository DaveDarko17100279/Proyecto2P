
package proyecto2p;

import BD.*;
<<<<<<< Updated upstream
import Models.usuarioGeneral;
import Views.ConferenciasIns;
import Views.Login;
import Views.index;
import Views.Menu;
=======
import Views.ConferenciasIns;

import Views.NewIndex;
>>>>>>> Stashed changes
import Views.VConferencia;
import java.sql.Connection;


public class Proyecto2P {

    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
<<<<<<< Updated upstream
        new ConferenciasIns().setVisible(true);
=======
        new NewIndex().setVisible(true);
        new ConferenciasIns().setVisible(true);

        
>>>>>>> Stashed changes
        
        new index().setVisible(true);
    }
    
}
