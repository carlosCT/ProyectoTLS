/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inf.pucp.edu.pe.modelo;

import inf.pucp.edu.pe.vista.simulacion.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author juancarlos
 */
public class Cuadra {
    
    public static BufferedImage zonaCuadrada;
    public int dimensionX=100;
    public int dimensionY=100;
    
    public BufferedImage getCuadra(){    
        try {
            zonaCuadrada = ImageIO.read(new File(getClass().getResource("/res/cuadra2.png").toURI()));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return zonaCuadrada;                
    }
}

