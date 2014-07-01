/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Carlos
 */
public class DBConfig {
       public static int dbType;
    public static String dbName;
    public static String dbUser;
    public static String dbPassword;
    private Connection conn;
    
    public DBConfig() throws SQLException{
        conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + "tlssw", //inf282g9,
                    "root", "");
        
    }
    
    public Connection getConnection(){
        return conn;
    }
}
