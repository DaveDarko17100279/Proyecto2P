/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aldor
 */ 
public class conexion {
     private static Connection con;
    private static final String driver ="com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url= "jdbc:mysql://localhost:3306/conferencia";

    public conexion() {
        con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(con != null){
                System.out.println("Conexion exitosa");
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida");
        }
    }
    
    //conexion a la BD
    public Connection getConnection(){
        return con;
    }
    //desconectar la bd
    public void desconectar(){
        con = null;
    }
}
