/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.vista.simulacion;

/**
 *
 * @author juancarlos
 */
public class VariablesSimulacion {
     
    //CambioDeZona cambioDeZona;
    public int posicionRelativaX;
    public int posicionRelativaY;
    
    
    public int cantidadSemaforos;
    public int cantidadDeVehiculos;
    
    public int totalSemaforos;
    public int totalVehiculos;
    
    public VariablesSimulacion() {
         
    }

    public int getPosicionRelativaX() {
        return posicionRelativaX;
    }

    public void setPosicionRelativaX(int posicionRelativaX) {
        this.posicionRelativaX = posicionRelativaX;
    }

    public int getPosicionRelativaY() {
        return posicionRelativaY;
    }

    public void setPosicionRelativaY(int posicionRelativaY) {
        this.posicionRelativaY = posicionRelativaY;
    }

    public int getCantidadSemaforos() {
        return cantidadSemaforos;
    }

    public void setCantidadSemaforos(int cantidadSemaforos) {
        this.cantidadSemaforos = cantidadSemaforos;
    }

    public int getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public void setCantidadDeVehiculos(int cantidadDeVehiculos) {
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public int getTotalSemaforos() {
        return totalSemaforos;
    }

    public void setTotalSemaforos(int totalSemaforos) {
        this.totalSemaforos = totalSemaforos;
    }

    public int getTotalVehiculos() {
        return totalVehiculos;
    }

    public void setTotalVehiculos(int totalVehiculos) {
        this.totalVehiculos = totalVehiculos;
    }
    
    
}
