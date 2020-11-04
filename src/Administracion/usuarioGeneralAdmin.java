package Administracion;

import BD.usuarioGeneralBD;
import Models.usuarioGeneral;

/**
 *
 * @author fabian_rodriguez
 */

public class usuarioGeneralAdmin {
    private static usuarioGeneralBD userGeneralBD = new usuarioGeneralBD();
    
    public static boolean agregar(usuarioGeneral userGeneral) {
        if(userGeneral == null) {
            return false;
        }
        else {
            userGeneralBD.crearUsuario(userGeneral);
            return true;
        }
    }
    
//    public static int cantidad() {
//        return userGeneralBD.size();
//    }
    
    public static usuarioGeneral buscar(int id) {
        usuarioGeneral resultado = new usuarioGeneral();
        
        resultado = userGeneralBD.getUsuario(id);

        return resultado;
    }

//    public static void eliminar(int id) {
//        userGeneralBD.eliminar(id);
//    }
//
//    public static void actualizar(usuarioGeneral persona) {
//        userGeneralBD.actualizar(persona);
//    }
}
