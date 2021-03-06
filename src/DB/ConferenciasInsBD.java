
package DB;

import Models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConferenciasInsBD {
    
    usuarioGeneral Usu = new usuarioGeneral();
    conexion con = new conexion();
    Connection cn = conexion.getConnection();
    String resultado;
    int ID;
    
    public ConferenciasInsBD(int id) {
        this.ID = id;
    }
    
    public  ArrayList<conferencia> getConferenciasIns(){
        try{
                      
           PreparedStatement Muestra = cn.prepareStatement("SELECT `conferencia_participante`.`ID_Usuario`"
                    + " AS ID_Participante, `conferencia`.*, `detalles_conferencia`.* "
                    + "FROM `conferencia_participante` LEFT JOIN `conferencia` ON `conferencia_participante`.`ID_Conferencia` = `conferencia`.`ID_Conferencia` LEFT JOIN `detalles_conferencia` ON `detalles_conferencia`.`ID_Conferencia` = `conferencia`.`ID_Conferencia` "
                    + "WHERE `conferencia_participante`.`ID_Usuario` = ? AND `conferencia`.`ID_Conferencia` = `conferencia_participante`.`ID_Conferencia` AND `detalles_conferencia`.`ID_Conferencia` = `conferencia`.`ID_Conferencia`");
            Muestra.setInt(1, ID);
            ResultSet rs = Muestra.executeQuery();
             ArrayList<conferencia> list = new ArrayList<conferencia>();
             while(rs.next()){
                conferencia u = new conferencia(
                                                 Integer.parseInt(rs.getString("ID_Conferencia")),
                                                 rs.getString("Nombre_Conferencia"),                        
                                                 Integer.parseInt(rs.getString("Cupo_Total")),
                                                 Integer.parseInt(rs.getString("Precio")),
                                                 rs.getDate("Fecha_Presentacion"),
                                                 rs.getTime("Hora_Inicial"),
                                                 rs.getTime("Hora_Finalizacion")
                                                 //Integer.parseInt(rs.getString("ID_Participante")),
                                                 //rs.getBoolean("Costo")
                 );
                  list.add(u);
             }
             return list;
        }catch(Exception ex){
             ex.printStackTrace();
        }
        return null;
    }
  
    

    
}
