/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.pucp.edu.pe.modelo;

import java.util.ArrayList;

/**
 *
 * @author fatima
 */
public class Seg {
    private int seg;
    private ArrayList<Integer> coordenadas;

    public Seg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }

    public ArrayList<Integer> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Integer> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Seg(int seg, ArrayList<Integer> coordenadas) {
        this.seg = seg;
        this.coordenadas = coordenadas;
    }
    
    
}
