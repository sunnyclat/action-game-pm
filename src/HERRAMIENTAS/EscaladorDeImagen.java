/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class EscaladorDeImagen {
    
    public static Rectangle escalaRectanguloArriba(final Rectangle rectangulo){
        
        final Rectangle rectResult= new Rectangle((int)
                (rectangulo.x*Constantes.FACTOR_ESCAL_X),
                (int)(rectangulo.y*Constantes.FACTOR_ESCAL_Y),
                (int)(rectangulo.width*Constantes.FACTOR_ESCAL_X),
                (int)(rectangulo.height*Constantes.FACTOR_ESCAL_Y) );
        
        return rectResult;
    }
    
    
    
    public static Point escalarPuntoArriba(final Point punto){
        
        
        final Point puntoResult= new Point((int)
                (punto.x*Constantes.FACTOR_ESCAL_X),
                (int)(punto.y*Constantes.FACTOR_ESCAL_Y)
                );
        
        return puntoResult;
        
        
    }
    
    
    
        public static Point escalarPuntoAbajo(final Point punto){
        
        
        final Point puntoResult= new Point((int)
                (punto.x / Constantes.FACTOR_ESCAL_X),
                (int)(punto.y / Constantes.FACTOR_ESCAL_Y)
                );
        
        return puntoResult;
        
        
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
