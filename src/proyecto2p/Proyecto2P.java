

package proyecto2p;

import BD.*;

import Models.usuarioGeneral;
import Views.ConferenciasIns;
import Views.Login;
import Views.index;
import Views.Menu;

import Views.ConferenciasIns;

import java.sql.Connection;


public class Proyecto2P {

    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
        new ConferenciasIns().setVisible(true);

        
        
        new index().setVisible(true);

    }
    
}

 
package proyecto2p; 
 
import BD.*; 
import Models.*; 
import Views.ConferenciasIns; 
import Views.CrearConferencia; 
import Views.DetallesConferenciaAjena; 
import Views.Menu; 
import Views.NewIndex; 
import Views.VConferencia; 
import java.sql.Connection; 
 
 
public class Proyecto2P { 
 
    public static void main(String[] args) { 
        conexion conex = new conexion(); 
        Connection cn = conex.getConnection(); 
         

//        new Menu(1).setVisible(true); 
         new Menu(1).setVisible(true); 
        //new ConferenciasIns().setVisible(true); 
 
         
        //new ConferenciasIns().setVisible(true); 
         
        //new index().setVisible(true); 
       //new DetallesConferenciaAjena().setVisible(true); 
 
    } 
     

} 

} 

