
package BD;
import Models.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class conferenciaBD {
    conexion con = new conexion();
    Connection cn = con.getConnection();
    String resultado;

    public conferenciaBD() {
    }
    
    public void crearConferencia(conferencia confe){
        try {
            PreparedStatement insertar = cn.prepareStatement("call creacion_conferencia (?,?,?,?,?,?,?,?)");
            insertar.setInt(1, confe.getIdUsuario());
            insertar.setString(2, confe.getNombreConferencia());
            insertar.setInt(3, confe.getCupoTotal());
            insertar.setInt(4, confe.getPrecio());
            if(confe.isCosto() == true){
                insertar.setString(5, "si");
            }else{
                insertar.setString(5, "no");
            }
            insertar.setDate(6, confe.getFechaPresentacion());
            insertar.setTime(7, confe.getHoraInicial());
            insertar.setTime(8, confe.getHoraFinalizacion());
            resultado = "Exito al guardar";
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
