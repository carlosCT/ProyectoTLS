/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class Coordernada implements Serializable {
    
    public int x;
    public int y;

       public Coordernada (){};
   
   public Coordernada ( int x , int y){
       this.x=x;
       this.y=y;
   }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
