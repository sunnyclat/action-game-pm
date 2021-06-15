/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author samuel ludueña 2021
 */
public class MedidorString {
    
    public static int medirAnchoPixel(final Graphics g,final String s){
     
        
        FontMetrics fm= g.getFontMetrics();
        
        
        
        
        
        
        
        
        
        
        
        
        
        return fm.stringWidth(s);
    }
    
    
    
    
     public static int medirAltoPixel(final Graphics g,final String s){
     
        
        FontMetrics fm= g.getFontMetrics();
        
        
        
        
        
        
        
        
        
        
        
        
        
        return (int) fm.getLineMetrics(s,g).getHeight();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
