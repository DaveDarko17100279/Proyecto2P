/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2p;

import BD.conexion;
import Views.index;
import java.sql.Connection;

/** Hola amikos de yutudwdaawdwada w 
 *
 * @author DaveDarko
 */
public class Proyecto2P {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        conexion conex = new conexion();
        Connection cn = conex.getConnection();
        System.out.println("Hola, buenos días");
        System.out.print("Hola, buenos días");
        System.out.print("Hola, buenos días Soy Rangel");
         new index().setVisible(true);
        //Hola Mundo da
    }
    
}
