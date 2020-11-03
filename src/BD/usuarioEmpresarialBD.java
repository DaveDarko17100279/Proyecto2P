
package BD;
import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class usuarioEmpresarialBD {
    conexion con = new conexion();
    Connection cn = con.getConnection();
    String resultado;

    public usuarioEmpresarialBD() {
    }
    
    public void crearUsuario(usuarioEmpresarial usu){
        try {
            PreparedStatement insertar = cn.prepareStatement("call info_empre(?,?,?,?,?,?,?,?,?)");
            insertar.setString(1, usu.getNombre());
            insertar.setString(2, usu.getApellidoPaterno());
            insertar.setString(3, usu.getApellidoMaterno());
            insertar.setDate(4, usu.getFechaNacimiento());
            insertar.setString(5, usu.getCorreo());
            insertar.setLong(6, usu.getTelefono());
            insertar.setString(7, usu.getContraseña());
            insertar.setInt(8, usu.getTipo());
            insertar.setInt(9, usu.getEmpresa());
            insertar.executeUpdate();
            resultado = "Exito al guardar";
        } catch (SQLException ex) {
            Logger.getLogger(usuarioEmpresarialBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
