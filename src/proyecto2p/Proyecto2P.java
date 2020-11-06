
package proyecto2p;

import BD.*;

import Models.*;

import Models.usuarioGeneral;

import Views.ConferenciasIns;
import Views.CrearConferencia;
import Views.DetallesConferenciaAjena;
import Views.Menu;
    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
//        new Menu(1).setVisible(true);
        //new ConferenciasIns().setVisible(true);

        
        //new ConferenciasIns().setVisible(true);
        new ConferenciasIns().setVisible(true);
        
        //new index().setVisible(true);
       //new DetallesConferenciaAjena().setVisible(true);

    }
    
}
