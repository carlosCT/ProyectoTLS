/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author Juan Carlos
 */
public final class Vehiculo extends Thread{
    public int actualX;
    public int actualY;
    /*DATOS MOMENTANEOS*/
    private int meta;
    private int velocidad;
    public BufferedImage imagen;
    private int dimensionX;
    private int dimensionY;
    private int direccion;

    
    
    
    
    public Vehiculo() {       
    }

    public Vehiculo(int actualX, int actualY, int meta, int velocidad, int dimensionX, int dimensionY, int direccion) {
        this.actualX = actualX;        
        this.actualY = actualY;
        this.meta = meta;
        this.velocidad = velocidad;
        this.dimensionX= dimensionX;
        this.dimensionY= dimensionY;
        try {
            this.imagen = ImageIO.read(new File(getClass().getResource("/res/vehiculo.png").toURI()));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.direccion=direccion;
    }
    
    public int getActualX() {
        return actualX;
    }

    public void setActualX(int actualX) {
        this.actualX = actualX;
    }

    public int getActualY() {
        return actualY;
    }

    public void setActualY(int actualY) {
        this.actualY = actualY;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }     

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }
    
    public Rectangle getBounds(){
        int offset=6;
        return new Rectangle(this.actualX, this.actualY, this.dimensionX, this.dimensionY);
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    

}
