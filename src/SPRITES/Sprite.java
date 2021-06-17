/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPRITES;

import java.awt.image.BufferedImage;

/**
 *
 * @author samuel ludueña 2021
 */
public class Sprite {
    
    private final BufferedImage imagen;
  
    private final int alto;
    private final int ancho;
    
    
    public Sprite(final BufferedImage imagen){
        
        
        this.imagen=imagen;
        
        alto=imagen.getHeight();
        ancho=imagen.getWidth();
        
        
    }
    
    
    
    public BufferedImage getImagen(){
        return imagen;
    }
    
    public int getAncho(){
    return ancho;
}
    
    public int getAlto(){
        return alto;
        
    }
    
    
    
    
    
}
