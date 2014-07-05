/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.controlador;


import inf.pucp.edu.pe.modelo.ConnectionDB;
import inf.pucp.edu.pe.modelo.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            SqlString="INSERT INTO Usuario(DNI, Nombre, Apellido, Email, Direccion, Usuario, Sexo, Contrasena, EstadoBloqueo, Perfil) "
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
    
   
     public void updateUser(Usuario user){
      //Pasos para la conexion a base de datos
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //Registramos el driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //obtenemos la conexion
            conn=new DBConfig().getConnection();
            
            pstmt=conn.prepareStatement("update Usuario set Nombre=?, Apellido=?, Email=?, Direccion=?, usuario=?"+
                     "Sexo=?, Perfil=? WHERE DNI=?" );
            
          
            pstmt.setString(1, user.getNombres());
            pstmt.setString(2, user.getApellidos());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getDireccion());
            pstmt.setString(5, user.getUsuario());
            pstmt.setInt(6, user.getSexo());
            pstmt.setInt(7, user.getPerfil()); 
            
            //Paso 4: Ejecutar la sentencia
            pstmt.executeUpdate();
            System.out.println("La actualizacion se realizo con exito");
            
        } catch (SQLException ex) {
            
        }finally{
            try{//cerramos la conexion
                  conn.close();
            }
            catch(Exception e){e.printStackTrace();}  
        }
    }
     
     
 
     
     public ArrayList<Usuario> allUser(){
        ArrayList<Usuario> list = new ArrayList<Usuario>();
       //Pasos para la conexion a la BD
       Connection conn=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
       try{
           //paso1:Registramos el driver
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           //Paso 2: Obtenemos conexion
//           conn=DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g9",
//                    "inf282g9", "madrugada");
            conn= new DBConfig().getConnection();
           //paso3: Preparamos la sentencia
           pstmt=conn.prepareStatement(
                   "SELECT * FROM usuario");
        
           rs=pstmt.executeQuery();
           //paso 4 y medio:Evaluamos los resultados
           while(rs.next()){      
             
              //DNI, Nombre, Apellido, Email, Direccion, Usuario, Sexo, Contrasena, EstadoBloqueo, Perfil
               String Dni= rs.getString("DNI");
               String Nombre=rs.getString("Nombre");
               String Apellido=rs.getString("Apellido");
               String Email=rs.getString("Email");
               String Direccion=rs.getString("Direccion");
               String Usuario= rs.getString("Usuario");
               int Sexo =rs.getInt("Sexo");
               String Contrasena=rs.getString("Contrasena");
               int EstadoBloqueo=rs.getInt("EstadoBloqueo");
               int Perfil= rs.getInt("Perfil");
//               Usuario(String dni, String nombres, String apellidos, String email, String direccion, 
//                String usuario, int sexo, String contrasena, int estadoBloqueo, int perfil)
               Usuario usuario= new Usuario(Dni, Nombre, Apellido, Email, Direccion, Usuario, Sexo, Contrasena,
               EstadoBloqueo, Perfil);
              
               list.add(usuario);
           }
       } catch (SQLException ex) {
           
        } finally {
            try {//Paso 5: Cerramos la conexión
            conn.close(); } catch(Exception e) {e.printStackTrace();}
        }
       return list;
           
  
     }
     
     public void deleteUser(Usuario user){
         Connection conn=null;
       PreparedStatement pstmt=null;
      
        try {
            //paso1:Registramos el driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    
            conn= new DBConfig().getConnection();
            
            pstmt= conn.prepareStatement("update Usuario set EstadoBloqueo=? WHERE DNI=?");
           pstmt.setInt(1, 0);
           pstmt.setString(2, user.getDni());
           
            pstmt.executeUpdate();
            System.out.println("se actualizo con exito");
                
        } catch (SQLException ex) {    
            
        }finally{
           try {
               conn.close();
           } catch (Exception e){ e.printStackTrace();
           }
        }
       
     }

    public void ChangePassword(String usuario, String password) {
        //Pasos para la conexion a base de datos
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //Registramos el driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //obtenemos la conexion
            conn=new DBConfig().getConnection();
            
            pstmt=conn.prepareStatement("update usuario set Contrasena=? WHERE DNI=?" );
            
          
            pstmt.setString(1, password);
            pstmt.setString(2, usuario);
            
            //Paso 4: Ejecutar la sentencia
            pstmt.executeUpdate();
            System.out.println("La actualizacion se realizo con exito");
            
        } catch (SQLException ex) {
            
        }finally{
            try{//cerramos la conexion
                  conn.close();
            }
            catch(Exception e){e.printStackTrace();}  
        }
    }

    public int validatePassword(String usuario, String inPasswordNow) {
        int igual=0;
        String contrasena="";
       //Pasos para la conexion a la BD
       Connection conn=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
       try{
           //paso1:Registramos el driver
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           //Paso 2: Obtenemos conexion
//           conn=DriverManager.getConnection("jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g9",
//                    "inf282g9", "madrugada");
            conn= new DBConfig().getConnection();
           //paso3: Preparamos la sentencia
           pstmt=conn.prepareStatement(
                   "SELECT * FROM usuario WHERE DNI=?");
           pstmt.setString(1, usuario);     
           rs=pstmt.executeQuery();
           //paso 4 y medio:Evaluamos los resultados
           while(rs.next()){      
             
               contrasena= rs.getString("Contrasena");
           }
       } catch (SQLException ex) {
           
        } finally {
            try {//Paso 5: Cerramos la conexión
            conn.close(); } catch(Exception e) {e.printStackTrace();}
        }
       
       if(contrasena.equals(inPasswordNow)){
           igual=1;
       }
       return igual;
           
  
    }
     
    
}
