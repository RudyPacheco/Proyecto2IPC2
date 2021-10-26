/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AndaryuS
 */
public class conexionDB {

    public static String URL = "jdbc:mysql://localhost:3306/dynamo_journals";
    public static String USER = "system32";
    public static String PASSWORD = "password";
    public static Connection conexion =null;

    
    public conexionDB(){
    
}
    
    public static Connection getConexion(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en conexion");
             e.printStackTrace(System.out);
        }
        
        return conexion;
    }
    
    public static void getCloseConexion(){
        if (conexion!=null) {
            try {
                conexion.close();
            } catch (SQLException e) {
            
            }
        }
    }
    
    
    
}
