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
import java.io.InputStream;
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
    public static InputStream zona; 
    public int dimensionX=100;
    public int dimensionY=100;
    
    public BufferedImage getCuadra(){    
        try {
            if(Panel.escala==4){
//                InputStream is = getClass().getResourceAsStream("/res/sprites/" + pathRelativeToThis);
//                BufferedImage img = ImageIO.read(is);
//                is.close()
               zona= getClass().getResourceAsStream("/res/cuadra00.png");
               zonaCuadrada = ImageIO.read(zona);
                //zonaCuadrada=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("res/cuadra00.png"));
            }
            else if(Panel.escala==10){
                zona= getClass().getResourceAsStream("/res/cuadra11.png");
               zonaCuadrada = ImageIO.read(zona);
               //zonaCuadrada = ImageIO.read(new File(getClass().getResource("/res/cuadra11.png").toURI()));
               // zonaCuadrada=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("res/cuadra11.png"));
            }else if(Panel.escala==20){
               zona= getClass().getResourceAsStream("/res/cuadra2.png");
               zonaCuadrada = ImageIO.read(zona);
               //zonaCuadrada=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("res/cuadra2.png"));
               //zonaCuadrada = ImageIO.read(new File(getClass().getResource("/res/cuadra2.png").toURI()));
            }
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
        return zonaCuadrada;                
    }
}

