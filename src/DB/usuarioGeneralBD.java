
package DB;
import Models.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class usuarioGeneralBD {
    conexion con = new conexion();
    Connection cn = conexion.getConnection();
    String resultado;
    public usuarioGeneralBD() {
    }
    
    public void crearUsuario(usuarioGeneral usu){//inserta los datos de un usuario general en la base de datos
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
            System.out.println(resultado);
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    public usuarioGeneral getUsuario(String correo, String password){//obtiene los datos de un usuario de tipo general
        usuarioGeneral usu = new usuarioGeneral();
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from informacion_usuario where Correo = ? and Contraseña = ? ");
            buscar.setString(1, correo);
            buscar.setString(2, password);
            ResultSet res = buscar.executeQuery();
            while (res.next()){
                usu = new usuarioGeneral(res.getInt("ID_Usuario"),res.getString("Nombre_s"), res.getString("Apellido_Paterno"), res.getString("Apellido_Materno"), res.getDate("Fecha_Nacimiento"), res.getString("Correo"), res.getLong("Telefono"), res.getString("Contraseña"), res.getInt("ID_TU"), res.getInt("Zenis"));
                return usu;
            }
            System.out.println("Succesfuly");
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
     public usuarioGeneral getUsuarioByID(int ID_u){//obtiene los datos de un usuario de tipo general
        usuarioGeneral usu = new usuarioGeneral();
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from informacion_usuario where ID_Usuario = ?");
            buscar.setInt(1, ID_u);
            ResultSet res = buscar.executeQuery();
            while (res.next()){
                usu = new usuarioGeneral(res.getInt("ID_Usuario"),res.getString("Nombre_s"), res.getString("Apellido_Paterno"), res.getString("Apellido_Materno"), res.getDate("Fecha_Nacimiento"), res.getString("Correo"), res.getLong("Telefono"), res.getString("Contraseña"), res.getInt("ID_TU"), res.getInt("Zenis"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioGeneralBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usu;//retorna un valor tipo usuarioGeneral
    }
    
    public void actualizarZenis(int Zenis, int ID_u){ //Actualizar un registro de la BD 
          try{
           
            PreparedStatement sql = cn.prepareStatement("update informacion_usuario set Zenis=? where ID_Usuario=?");
            sql.setInt(1, Zenis);
            sql.setInt(2, ID_u);
            sql.executeUpdate();
        
        }catch(SQLException ex){
        
        }
     }
}
