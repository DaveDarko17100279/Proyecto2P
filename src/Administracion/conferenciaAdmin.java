package Administracion;

import BD.conferenciaBD;
import Models.conferencia;

/**
 *
 * @author fabian_rodriguez
 */
public class conferenciaAdmin {
    private static conferenciaBD conferBD = new conferenciaBD();
    
    public static boolean agregar(conferencia confer) {
        if(confer == null) {
            return false;
        }
        else {
            conferBD.crearConferencia(confer);
            return true;
        }
    }
}
