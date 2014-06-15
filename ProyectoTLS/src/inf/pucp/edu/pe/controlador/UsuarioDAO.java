/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;


import inf.pucp.edu.pe.modelo.ConnectionDB;
import inf.pucp.edu.pe.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author fatima
 */
public class UsuarioDAO {
    
    public int addUser(Usuario usr){
        int result=0;
                
        ConnectionDB objConn=new ConnectionDB();
        Connection conn = null;
        
        try{
            conn=objConn.open();
        }catch (SQLException ex){
          //  Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        
        try{
            String SqlString=null;
            SqlString="INSERT INTO usuario(DNI, Nombre, Apellido, Email, Direccion, Usuario, Sexo, Contrasena, EstadoBloqueo, Perfil) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(SqlString);
            pstmt.setString(1, usr.getDni());
            pstmt.setString(2, usr.getNombres());
            pstmt.setString(3, usr.getApellidos());
            pstmt.setString(4, usr.getEmail());
            pstmt.setString(5, usr.getDireccion());
            pstmt.setString(6, usr.getUsuario());
            pstmt.setInt(7, usr.getSexo());
            pstmt.setString(8, usr.getContrasena());
            pstmt.setInt(9, usr.getEstadoBloqueo());
            pstmt.setInt(10, usr.getPerfil());
            
            result=pstmt.executeUpdate();
            pstmt.close();
            
            if (result==0){
                throw new Exception();
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if (conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        
        return result;        
    }
    
}
