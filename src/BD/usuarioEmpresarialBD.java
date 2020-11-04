
package BD;
import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class usuarioEmpresarialBD {
    conexion con = new conexion();
    Connection cn = con.getConnection();
    String resultado;

    public usuarioEmpresarialBD() {
    }
    
    public void crearUsuario(usuarioEmpresarial usu){//inserta un usuario a la base de datos de tipo empresarial
        try {
            PreparedStatement insertar = cn.prepareStatement("call info_empre(?,?,?,?,?,?,?,?,?)");//inserta los datos al almacenamiento procesado ya creado
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
    
    public usuarioEmpresarial getUsuario(String correo, String password){//obtiene la informacion de un usuario empresarial
        usuarioEmpresarial usu = new usuarioEmpresarial();
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from informacion_usuario where Correo = ? and Contraseña = ? ");
            buscar.setString(1, correo);
            buscar.setString(2, password);
            ResultSet res = buscar.executeQuery();
            while (res.next()){
                usu = new usuarioEmpresarial(getEmpresa(res.getInt("ID_Usuario")),res.getInt("ID_Usuario"),res.getString("Nombre_s"), res.getString("Apellido_Paterno"), res.getString("Apellido_Materno"), res.getDate("Fecha_Nacimiento"), res.getString("Correo"), res.getLong("Telefono"), res.getString("Contraseña"), res.getInt("ID_TU"), res.getInt("Zenis"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usu;//retorna una variable de tipo usuarioEmpresarial
    }
    public int getEmpresa(int id){//obtiene la empresa en la que se asigna al usuario empresarial
        int idempresa = 0;
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from detalle_emprearial where ID_Usuario = ? ");
            buscar.setInt(1, id);
            ResultSet res = buscar.executeQuery();
            while(res.next()){
                idempresa = res.getInt("ID_Empresa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idempresa;//retorna la id de la empresa asignada
    }
}
