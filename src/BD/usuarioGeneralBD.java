
package BD;
import Models.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class usuarioGeneralBD {
    conexion con = new conexion();
    Connection cn = con.getConnection();
    String resultado;
    public usuarioGeneralBD() {
    }
    
    public void crearUsuario(usuarioGeneral usu){
        try {
            PreparedStatement insertar = cn.prepareStatement("insert into informacion_usuario (Nombre_s, Apellido_Paterno, Apellido_Materno, Fecha_Nacimiento, Correo, Telefono, Contraseña, ID_TU) values (?,?,?,?,?,?,?,?)");
            insertar.setString(1, usu.getNombre());
            insertar.setString(2, usu.getApellidoPaterno());
            insertar.setString(3, usu.getApellidoMaterno());
            insertar.setDate(4, usu.getFechaNacimiento());
            insertar.setString(5, usu.getCorreo());
            insertar.setLong(6, usu.getTelefono());
            insertar.setString(7, usu.getContraseña());
            insertar.setInt(8, usu.getTipo());
            insertar.executeUpdate();
            resultado = "Exito al guardar";
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    
}
