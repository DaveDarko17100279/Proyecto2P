
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
    
    public conferencia[] getConferencias(int idUsuario){//consigue todas las conferencias creadas por un usuario
        conferencia[] con = new conferencia[totalConferencias(idUsuario)];
        int x = 0;
        boolean costo;
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from conferencia where ID_Usuario = ? ");
            buscar.setInt(1, idUsuario);
            ResultSet res = buscar.executeQuery();
            while(res.next()){
                System.out.println("Hola 2");
                con[x] = new conferencia (res.getInt("ID_Conferencia"), res.getString("Nombre_Conferencia"), res.getInt("Cupo_Total"), res.getInt("Precio"),getDetalle(res.getInt("ID_Conferencia")).getFechaPresentacion(), getDetalle(res.getInt("ID_Conferencia")).getHoraInicial(), getDetalle(res.getInt("ID_Conferencia")).getHoraFinalizacion());
                x++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Hola");
        }
        return con; //retorna un array de objetos con todas las conferencias creadas por el ususario
    }
    
    public conferencia getDetalle(int idConferencia){
        conferencia con = new conferencia();
        try {
            PreparedStatement buscar = cn.prepareStatement("select * from detalle_conferencias where ID_Conferencia = ? ");
            buscar.setInt(1, idConferencia);
            ResultSet res = buscar.executeQuery();
            while(res.next()){
                System.out.println("Hola 2");
                con = new conferencia (res.getInt("ID_Conferencia"), res.getDate("Fecha_Presentacion"), res.getTime("Hora_Inicial"), res.getTime("Hora_Finalizacion"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public int totalConferencias(int idUsuario){//obtiene el total de conferencias creadas por un usuario
        int total = 0;
        try {
            PreparedStatement contar = cn.prepareStatement("select count(ID_Usuario) from conferencia where ID_Usuario = ?");
            contar.setInt(1, idUsuario);
            ResultSet res = contar.executeQuery();
            if(res.next()){
                total = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;//retorna el total
    }
    
    public void ingresarConferencista(conferencia confe){//Se ingresan los conferencistas para las conferencias
        if(verificarConferencistas(confe.getIdConferencia()) ==true){
            resultado ="Ya no se pueden ingresar mas conferencistas";
        }else{
            try {
            PreparedStatement insertar = cn.prepareStatement("insert into conferencia_conferencistas (ID_Usuario, ID_Conferencia) values (?,?)");
            insertar.setInt(1, confe.getIdUsuario());
            insertar.setInt(2, confe.getIdConferencia());
            insertar.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public boolean verificarConferencistas(int idConferencia){
        boolean verificar = false;
        int total = 0;
        try {
            PreparedStatement contar = cn.prepareStatement("select count(ID_Conferencia) from conferencia_conferencistas where ID_Conferencia = ?");
            contar.setInt(1, idConferencia);
            ResultSet res = contar.executeQuery();
            if(res.next()){
                total = res.getInt(1);
            }
            if(total ==3){
                verificar = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return verificar;
    }
    
    public void masFechas(conferencia confe){//Se ingresan mas fechas para la conferencia
        try {
            PreparedStatement insertar = cn.prepareStatement("insert into detalle_conferencia (ID_Conferencia, Fecha_Presentacion,Hora_Inicial, Hora_Finalizacion) values (?,?,?,?)");
            insertar.setInt(1, confe.getIdConferencia());
            insertar.setDate(2, confe.getFechaPresentacion());
            insertar.setTime(3, confe.getHoraInicial());
            insertar.setTime(4, confe.getHoraFinalizacion());
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
