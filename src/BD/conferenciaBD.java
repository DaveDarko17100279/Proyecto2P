
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
    
    public void crearConferencia(conferencia confe){//inserta en la base de datos los principales datos de una conferencia
        try {
            PreparedStatement insertar = cn.prepareStatement("call creacion_conferencia (?,?,?,?,?,?,?,?)");//se crea la query llamando al almacenamiento creado anteriormente
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
            insertar.executeUpdate();
            resultado = "Exito al guardar";
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //NO TOCAR POR FAVOR :)
//    public conferencia[] getConferencias(int idUsuario){
//        conferencia[] con;
//        int x = 0;
//        PreparedStatement buscar = cn.prepareStatement(resultado)
//        return con; 
//    }
}
