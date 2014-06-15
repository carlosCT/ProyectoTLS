package inf.pucp.edu.pe.algoritmoEntidades;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Espinoza
 */
public class Via {
    
    //<editor-fold desc="Atributos">
    
    private int puntoXInicial;
    private int puntoXFinal;
    
    private int puntoYInicial;
    private int puntoYFinal;
    
    private Cruce cruceInicial;
    private Cruce cruceFinal;
    
    // del cruce inicial al cruce final se considera velocidad POSITIVA.
    // del cruce final al cruce inicial se considera velocidad NEGATIVA.
    
    private ArrayList<Vehiculo> vehVelPos;
    private ArrayList<Vehiculo> vehVelNeg;
    
    //</editor-fold>

    //<editor-fold desc="Métodos Get">
    
    public int getPuntoXInicial() {
        return puntoXInicial;
    }

    public int getPuntoXFinal() {
        return puntoXFinal;
    }

    public int getPuntoYInicial() {
        return puntoYInicial;
    }

    public int getPuntoYFinal() {
        return puntoYFinal;
    }

    public ArrayList<Vehiculo> getVehVelPos() {
        return vehVelPos;
    }

    public ArrayList<Vehiculo> getVehVelNeg() {
        return vehVelNeg;
    }

    public Cruce getCruceInicial() {
        return cruceInicial;
    }

    public Cruce getCruceFinal() {
        return cruceFinal;
    }

    //</editor-fold>
    
    //<editor-fold desc="Métodos Set">
    
    public void setPuntoXInicial(int puntoXInicial) {
        this.puntoXInicial = puntoXInicial;
    }

    public void setPuntoXFinal(int puntoXFinal) {
        this.puntoXFinal = puntoXFinal;
    }

    public void setPuntoYInicial(int puntoYInicial) {
        this.puntoYInicial = puntoYInicial;
    }

    public void setPuntoYFinal(int puntoYFinal) {
        this.puntoYFinal = puntoYFinal;
    }
    

    public void setCruceInicial(Cruce cruceInicial) {
        this.cruceInicial = cruceInicial;
    }

    public void setCruceFinal(Cruce cruceFinal) {
        this.cruceFinal = cruceFinal;
    }

    public void setVehVelPos(ArrayList<Vehiculo> vehVelPos) {
        this.vehVelPos = vehVelPos;
    }

    public void setVehVelNeg(ArrayList<Vehiculo> vehVelNeg) {
        this.vehVelNeg = vehVelNeg;
    }
    
    //</editor-fold>
}
