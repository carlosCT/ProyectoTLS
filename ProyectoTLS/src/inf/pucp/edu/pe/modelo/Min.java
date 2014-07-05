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
public class Min {
    private int min;
    private ArrayList<Seg> seg;

    public Min() {
        
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public ArrayList<Seg> getSeg() {
        return seg;
    }

    public void setSeg(ArrayList<Seg> seg) {
        this.seg = seg;
    }

    public Min(int min, ArrayList<Seg> seg) {
        this.min = min;
        this.seg = seg;
    }
}
