package proyecto2p;

import BD.*;

import Models.usuarioGeneral;
import Views.ConferenciasIns;
import Views.Menu;

import Views.ConferenciasIns;

import java.sql.Connection;


public class Proyecto2P {

    public static void main(String[] args) {
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        
//        new ConferenciasIns().setVisible(true);

        
        
//        new index().setVisible(true);

    }
    
}