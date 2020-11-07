
package BD;
import Models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class conferenciaBD {
    conexion con = new conexion();
    Connection cn = conexion.getConnection();
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
    
    public boolean actualizarConferencia(conferencia confe){//inserta en la base de datos los principales datos de una conferencia
        boolean result = false;
        try {
            PreparedStatement actualizarC = cn.prepareStatement(
                    "UPDATE conferencia SET Nombre_Conferencia = ?,"
                    + " Cupo_Total = ?, Precio = ? WHERE ID_Conferencia = ?");
            actualizarC.setString(1, confe.getNombreConferencia());
            actualizarC.setInt(2, confe.getCupoTotal());
            actualizarC.setInt(3, confe.getPrecio());
            actualizarC.setInt(4, confe.getIdUsuario());

            actualizarC.executeUpdate();

            PreparedStatement actualizarDC = cn.prepareStatement(
                    "UPDATE detalles_conferencia SET Fecha_Presentacion = ?,"
                    + "Hora_Inicial = ?, Hora_Finalizacion = ?  WHERE ID_Conferencia = ?");
            actualizarDC.setDate(1, confe.getFechaPresentacion());
            actualizarDC.setTime(2, confe.getHoraInicial());
            actualizarDC.setTime(3, confe.getHoraFinalizacion());
            actualizarDC.setInt(4, confe.getIdUsuario());
            actualizarDC.executeUpdate();
            
            result = true;
            
        } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
        return result;
    }
    
    public conferencia[] getConferencias(int idUsuario){//consigue todas las conferencias creadas por un usuario
        conferencia[] con = new conferencia[totalConferencias(idUsuario)];
        int x = 0;
        boolean costo;
        try {
            PreparedStatement buscar = cn.prepareStatement("select conferencia.ID_Conferencia, conferencia.Nombre_Conferencia, conferencia.Cupo_Total, conferencia.Precio, detalles_conferencia.Fecha_Presentacion, detalles_conferencia.Hora_Inicial, detalles_conferencia.Hora_Finalizacion from conferencia INNER JOIN detalles_conferencia on conferencia.ID_Conferencia = detalles_conferencia.ID_Conferencia where conferencia.ID_Usuario = ?");
            buscar.setInt(1, idUsuario);
            ResultSet res = buscar.executeQuery();
            while(res.next()){
                con[x] = new conferencia (res.getInt("ID_Conferencia"), res.getString("Nombre_Conferencia"), res.getInt("Cupo_Total"), res.getInt("Precio"),res.getDate("Fecha_Presentacion"), res.getTime("Hora_Inicial"), res.getTime("Hora_Finalizacion"));
                x++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(conferenciaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con; //retorna un array de objetos con todas las conferencias creadas por el ususario
    }
    
    public boolean eliminarConferencias(int IDConferencia){//obtiene el total de conferencias creadas por un usuario
        boolean result = false;
        try {
            PreparedStatement eliminarD = cn.prepareStatement("DELETE FROM detalles_conferencia WHERE ID_Conferencia = ?");
            eliminarD.setInt(1, IDConferencia);
            //guardo el resultado en res
            eliminarD.executeUpdate();

            PreparedStatement eliminarC = cn.prepareStatement("DELETE FROM conferencia WHERE ID_Conferencia = ?");
            eliminarC.setInt(1, IDConferencia);
            //guardo el resultado en res
            eliminarC.executeUpdate();

            result = true;
        } catch (SQLException ex) {
            //verifica que se haya realizado con exito
            JOptionPane.showMessageDialog(null, "Algo salio mal al guardar los datos");
        }
        return true;
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
    
    public ArrayList<conferencia> consultarConferencia(int ID_u) 
    {
        ArrayList<conferencia> conferencias = new ArrayList<>();
        ResultSet salida;
        conferencia conf;
        try 
        {
            PreparedStatement sql = cn.prepareStatement("SELECT conferencia.ID_Conferencia, conferencia.ID_Usuario, conferencia.Nombre_Conferencia, conferencia.Cupo_Total, conferencia.Precio, detalles_conferencia.Fecha_Presentacion, detalles_conferencia.Hora_Inicial, detalles_conferencia.Hora_Finalizacion FROM conferencia INNER JOIN detalles_conferencia ON conferencia.ID_Conferencia = detalles_conferencia.ID_Conferencia WHERE conferencia.ID_Usuario != ?"); 
            sql.setInt(1,ID_u);
            salida = sql.executeQuery();
        
            System.out.print("ID RECIBIDA EN consulatConferencia: " + ID_u);
            
            while(salida.next())
            {
                conf = new conferencia();
                conf.setIdUsuario(salida.getInt("conferencia.ID_Usuario"));
                conf.setIdConferencia(salida.getInt("conferencia.ID_Conferencia"));
                conf.setNombreConferencia(salida.getString("conferencia.Nombre_Conferencia"));
                conf.setCupoTotal(salida.getInt("conferencia.Cupo_Total"));
                conf.setPrecio(salida.getInt("conferencia.Precio"));
                conf.setFechaPresentacion(salida.getDate("detalles_conferencia.Fecha_Presentacion"));
                conf.setHoraInicial(salida.getTime("detalles_conferencia.Hora_Inicial"));
                conf.setHoraFinalizacion(salida.getTime("detalles_conferencia.Hora_Finalizacion"));
               // conf.setCosto(salida.getBoolean("conferencia.Costo"));
               
                 //System.out.println(salida.next());
                 conferencias.add(conf);
                System.out.println("Agregado");
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return conferencias;
    }
    
    
    public ArrayList<conferencia_participante> consultarParticipantes(int ID_c, int ID_u, boolean opc) 
    {
        ArrayList<conferencia_participante> participantes = new ArrayList<>();
        ResultSet salida;
        conferencia_participante part;
        try 
        {
            /*BUSCAR AL USUARIO ESPECIFICAMENTE EN UNA CONFERENCIA*/
            if(opc == true){
            PreparedStatement sql = cn.prepareStatement("SELECT * FROM conferencia_participante  WHERE ID_Usuario = ? AND ID_Conferencia = ?");            
             sql.setInt(1,ID_u);
             sql.setInt(2,ID_c);
            salida = sql.executeQuery();
            }else{
            /*BUSCAR TODOS LOS USUARIO PARTICIPANTES*/
             PreparedStatement sql = cn.prepareStatement("SELECT * FROM conferencia_participante");            
             //sql.setInt(1,5);
             //sql.setInt(2,ID_c);
             salida = sql.executeQuery();
            }
            while(salida.next())
            {
                part = new conferencia_participante();
                part.setID_Usuario(salida.getInt("ID_Usuario"));
                part.setID_Conferencia(salida.getInt("ID_Conferencia"));
                part.setCodigo_Participante(salida.getInt("Codigo_Participante"));
               
                participantes.add(part);
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return participantes;
    }
    
    public void InsertarParticipante(int ID_u, int ID_c, int Codigo_p) 
    {
    try
        {
            PreparedStatement x = cn.prepareStatement("insert into conferencia_participante(ID_Usuario, ID_Conferencia, Codigo_Participante) values (?,?,?)");
            x.setInt(1, ID_u);
            x.setInt(2, ID_c);
            x.setInt(3, Codigo_p);
            x.executeUpdate();            
        }
        catch(SQLException e)
        {
            System.out.println("Error al introducir datos");
        }
    }
}
