/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.modelo;

/**
 *
 * @author fatima
 */
public class Usuario {
    
    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private String usuario;
    private int sexo;
    private String contrasena;
    private int estadoBloqueo;  //1:bloqueado, 0:normal
    private int perfil;

    public Usuario(){
        
    }
    
    public Usuario(String usuario, String password){
        this.usuario=usuario;
        this.contrasena=password;
    }
    
    
    public Usuario(String dni, String nombres, String apellidos, String email, String direccion, 
                String usuario, int sexo, String contrasena, int estadoBloqueo, int perfil){
        this.dni=dni;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.email=email;
        this.direccion=direccion;
        this.usuario=usuario;
        this.sexo=sexo;
        this.contrasena=contrasena;
        this.estadoBloqueo=estadoBloqueo;
        this.perfil=perfil;
    }
    
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstadoBloqueo() {
        return estadoBloqueo;
    }

    public void setEstadoBloqueo(int estadoBloqueo) {
        this.estadoBloqueo = estadoBloqueo;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
}
