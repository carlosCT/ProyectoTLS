/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fatima
 */
public class ConnectionDB {
       
    /*Datos para conectarse a las BD propias*/
    
    public String url = "jdbc:mysql://localhost:3306/";
    public String dbName = "tlssw";
    //public String driver = Class.forName("com.mysql.jdbc.Driver");
    public String driver = "com.mysql.jdbc.Driver";
    public String userName = "root";
    public String password = "";

    /*Datos para conectarse a la BD de la PUCP*/
//        public String url = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/";
//        public String dbName = "inf282g2";
//        public String driver = "com.mysql.jdbc.Driver";
//        public String userName = "inf282g2";
//        public String password = "cableado";
    public ConnectionDB() {
    }

    public Connection open() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection(url + dbName, userName, password);
        System.out.println("Connected to the database");
        return conn;
    }
}
