
package proyecto2p;

import BD.*;

import Models.*;

import Models.usuarioGeneral;

import Views.ConferenciasIns;
import Views.DetallesConferenciaAjena;
import Views.Login;
import Views.index;
import Views.Menu;
    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
        new NewIndex().setVisible(true);
        //new ConferenciasIns().setVisible(true);

        
        //new ConferenciasIns().setVisible(true);
        new ConferenciasIns().setVisible(true);
        
        //new index().setVisible(true);
       //new DetallesConferenciaAjena().setVisible(true);

    }
    
}
