/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

/**
 *
 * @author juancarlos
 */
public class Zona {
    
    private int PosXInicial;
    private int PosYInicial;
    private int posXFinal;
    private int posYFinal;

    public Zona() {
    }

    public Zona(int PosXInicial, int PosYInicial, int posXFinal, int posYFinal) {
        this.PosXInicial = PosXInicial;
        this.PosYInicial = PosYInicial;
        this.posXFinal = posXFinal;
        this.posYFinal = posYFinal;
    }
    
    
    public Zona zonaActual(Zona arregloZona[], int posx, int posy){
        int i;
        for(i=1; i<=arregloZona.length; i++){
            if(arregloZona[i].getPosXInicial()==posx && arregloZona[i].getPosYInicial()==posy)break;
        }
        return arregloZona[i];        
    }

    public int getPosXFinal() {
        return posXFinal;
    }

    public int getPosYFinal() {
        return posYFinal;
    }

    public int getPosXInicial() {
        return PosXInicial;
    }

    public int getPosYInicial() {
        return PosYInicial;
    }

    public void setPosXFinal(int posXFinal) {
        this.posXFinal = posXFinal;
    }

    public void setPosXInicial(int PosXInicial) {
        this.PosXInicial = PosXInicial;
    }

    public void setPosYFinal(int posYFinal) {
        this.posYFinal = posYFinal;
    }

    public void setPosYInicial(int PosYInicial) {
        this.PosYInicial = PosYInicial;
    }
        
    
}
