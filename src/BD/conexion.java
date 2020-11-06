
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
     private static Connection con = null;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url= "jdbc:mysql://localhost/conferencia";

    public conexion() {
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(con != null){
                System.out.println("Conexion exitosa");
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el Driver");
        }
        catch (SQLException ex) {
            System.out.println("Error de conexión DB");
        }
    }
    
    //conexion a la BD
   static public Connection getConnection(){
        return con;
    }
    //desconectar la bd
    public void desconectar(){
        con = null;
    }
}
