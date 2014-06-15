/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.awt.Rectangle;

/**
 *
 * @author juancarlos
 */
public class Semaforo {
    private int posicionX;
    private int posicionY;
    private int estadoLuz;
    private int dimensionX;
    private int dimensionY;
    
    public Semaforo() {
     
    }

    public Semaforo(int posicionX, int posicionY, int estadoLuz) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.estadoLuz = estadoLuz;
        /*DIMENSIONES*/
        this.dimensionX=6;
        this.dimensionY=6;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(int estadoLuz) {
        this.estadoLuz = estadoLuz;
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
        return new Rectangle(this.posicionX-offset, this.posicionY, this.dimensionX, this.dimensionY);
    }

    

    
    
}
