/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import principal.Constantes;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public class DiseñoInventarioPrinc {
    
        public final Color COLOR_BANNER_SUP;
    public final Color COLOR_BANNER_LAT;
    public final Color COLOR_FONDO;
    
    
    public final Rectangle BANNER_SUP;
    public final Rectangle BANNER_LAT;
    public  final Rectangle FONDO;
    
    
    public final int MARGEN_HORIZ_ETIQUET;
    public final int MARGEN_VERT_ETIQUET;
    public final int ANCHO_ETIQUET;
    public final int ALTO_ETIQUET;
    
    
    
    public DiseñoInventarioPrinc(){
        
        
       COLOR_BANNER_SUP=new Color(0xFF0000 ); //rojo
        
      COLOR_BANNER_LAT= new Color(0x808080 ); //gris
                
         COLOR_FONDO=new Color(0x0000FF );//azul
                
           
         BANNER_SUP= new Rectangle(0,0, Constantes.ANCHO_JUEGO,20);   //x,y,ancho.alto
             BANNER_LAT= new Rectangle(0, BANNER_SUP.height,140,Constantes.ALTO_JUEGO-BANNER_SUP.height);   
        
             FONDO= new Rectangle(BANNER_LAT.x+BANNER_LAT.width,BANNER_LAT.y,+Constantes.ALTO_JUEGO-BANNER_SUP.width,+Constantes.ALTO_JUEGO-BANNER_SUP.height);
           
             
             
             
             MARGEN_HORIZ_ETIQUET=20;
             MARGEN_VERT_ETIQUET=20;
             
        ANCHO_ETIQUET=100;
        ALTO_ETIQUET=20;
             
             
    }
    

    
    
     public void dibujar(final Graphics g){
        
         DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,BANNER_SUP ,COLOR_BANNER_SUP);
         
           DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,BANNER_LAT ,COLOR_BANNER_LAT);
           
          //   Dibujador.dibujarRectanguloRelleno(g,FONDO , COLOR_FONDO);
         
         
         
         
    }
    
    
    
    
    
    
}
