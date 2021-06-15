/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;
import GRAFICOS.LectorCanvas;

/**
 *
 * @author samuel ludueña 2021
 */
public class GeneradorDeTooltips {
    
    
    
    
   private static Point generaTool(final Point puntInic){
        
        
        final int x = puntInic.x;
        
        final int y= puntInic.y;
        
        final Point centroCanvas= new Point(Constantes.CENTRO_PANTALLA_X,Constantes.CENTRO_PANTALLA_Y);
        
        
        
        final Point centroCanvasEscal= new Point (EscaladorDeImagen.escalarPuntoArriba(centroCanvas).x,
                EscaladorDeImagen.escalarPuntoAbajo(centroCanvas).y   );
        
        
        final int MARGEN_CURSOR= 5;
        
        
        
        final Point puntFinal= new Point();
        
        
        if(x <= centroCanvasEscal.x){
            
            if(y <= centroCanvasEscal.y){
           
                puntFinal.x = x + Constantes.LADO_CURSOR + MARGEN_CURSOR;
                puntFinal.y = y +  Constantes.LADO_CURSOR + MARGEN_CURSOR;
                
                
                
            }else{
                
                puntFinal.x = x + Constantes.LADO_CURSOR + MARGEN_CURSOR;
                puntFinal.y = y -  Constantes.LADO_CURSOR - MARGEN_CURSOR;
                
                
                
                
            }
        }
        else{
            if(y <= centroCanvasEscal.y){
                
                  puntFinal.x =   x - Constantes.LADO_CURSOR - MARGEN_CURSOR;
                  puntFinal.y =   y +  Constantes.LADO_CURSOR + MARGEN_CURSOR;
                
                
                
                
            }else{
                
                 puntFinal.x = x - Constantes.LADO_CURSOR - MARGEN_CURSOR;
                puntFinal.y = y -  Constantes.LADO_CURSOR - MARGEN_CURSOR;
                
                
                
            }
            
        }
        
        
        
        
        
        
        
        return puntFinal;
    }
    
     public static void dibujToolTipPeso(final Graphics g, final LectorCanvas sd, final String texto ){
        
        
        final Point posicRaton= sd.getRaton().getPosicion();
        
        final Point posicToolTip= GeneradorDeTooltips.generaTool(posicRaton);
        
                final String pistaPosic= GeneradorDeTooltips.obtienePosicTooltip(posicRaton); //noreste noreste sudoeste sudeste
                
                
                
                final Point posicToolTipEscal= EscaladorDeImagen.escalarPuntoAbajo(posicToolTip);
                
               
                
          //      final String infoPeso= pesoActual + "/" + limitPeso;
                
                
                final int ancho= MedidorString.medirAnchoPixel(g, texto);  //trasnforma el infopeso en valores enteros
                        
            final int alto= MedidorString.medirAltoPixel(g, texto);
           
            final int margenFuente=4;//de esta manera la fuente de texto no se pegara con los bordes del cuadrado que lo encierra
            
               Rectangle tooltip=null;
            
          
            
            
       
            
            switch(pistaPosic){
               
                case "NOROESTE":
                    tooltip= new Rectangle(posicToolTipEscal.x,posicToolTipEscal.y, ancho + margenFuente * 2,alto);  //el margen debe ir a la izquierda y a la derecha y a lser doble se multiplica por 2. al alto no se aplica margen ya que tiene uno
                
                    break;
                    
                case "NORESTE":
                    
                       tooltip= new Rectangle(posicToolTipEscal.x - ancho,posicToolTipEscal.y, ancho + margenFuente * 2,alto);
                    
                    break;
                    
                    case"SUDOESTE":
                                  tooltip= new Rectangle(posicToolTipEscal.x ,posicToolTipEscal.y - alto, ancho + margenFuente * 2,alto);
                        
                        
                        break;
                        
                    case "SUDESTE":
                          tooltip= new Rectangle(posicToolTipEscal.x - ancho,posicToolTipEscal.y - alto, ancho + margenFuente * 2,alto);
                     
                          break;
                
                
                
                
                
                
                
                
                
            }
            
              DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, tooltip, Color.black);
         
              DibujadorRectangulosImagenes.dibujString( g, texto, 
                      new Point  (tooltip.x + margenFuente ,  tooltip.y + tooltip.height - margenFuente) , Color.white  ); //g,s,p
            
    }
    
    
    private static String obtienePosicTooltip(final Point puntInic){
        
        final int x = puntInic.x;
        
        final int y= puntInic.y;
        
                final Point centroCanvas= new Point(Constantes.CENTRO_PANTALLA_X,Constantes.CENTRO_PANTALLA_Y);
        
               final Point centroCanvasEscal= new Point (EscaladorDeImagen.escalarPuntoArriba(centroCanvas).x,
                EscaladorDeImagen.escalarPuntoAbajo(centroCanvas).y   );
        
        
               
               String posic= "";
               
               
                
        if(x <= centroCanvasEscal.x){
            
            if(y<=centroCanvasEscal.y){
           
                posic="NOROESTE";
                
           
                
                
                
            }else{
                
                    posic="SUDOESTE";
                
                
                
                
                
            }
        }
        else{
            if(y <= centroCanvasEscal.y){
                
                    posic="NORESTE";
                            
               
                
                
                
                
            }else{
                    posic="SUDESTE";
                    
           
                
                
                
            }
            
        }
               
           return  posic;   
               
               
               
    }
    
    
    
    
    
}
