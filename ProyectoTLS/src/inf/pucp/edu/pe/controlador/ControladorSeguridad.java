/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;

import inf.pucp.edu.pe.modelo.ConnectionDB;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis
 */
public class ControladorSeguridad {

    public String codificar(String pass) {

        String passwordToHash = pass;
        String generatedPassword = null;
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;

    }

    public int Login(String usuario, String password) {

        int result = 0;

        ConnectionDB objConn = new ConnectionDB();
        Connection conn = null;

        try {
            conn = objConn.open();
        } catch (SQLException ex) {
            //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null,ex);
        }

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String SqlString = null;

            SqlString = "SELECT u.Usuario, u.Contrasena FROM usuario u WHERE u.Usuario=\'" + usuario + "\'";

            pstmt = conn.prepareStatement(SqlString);
            rs = pstmt.executeQuery();

            String uUser=null;
            String uPass=null;
            
            while(rs.next()){
            uUser = rs.getString("Usuario");
            uPass = rs.getString("Contrasena");
            }
            String pass= codificar(password);
            if (pass.equals(uPass)) {
               result=1; 
            }
        } catch (Exception ex) {
            System.out.println("No hay conexion con BD");
        }finally{
             try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
               System.out.println("Conectar al servidor");
            }
        }

        return result;  // 0 si no coincide y 1 si coinciden        
    }
}
