/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import INVENTARIO.EstructSeccionInventarioPrinc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import principal.Constantes;
import principal.ObjetosEstaticos;
import GRAFICOS.LectorCanvas;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public abstract class SeccionesInventario {
    
    protected final String nombreSecc;
    protected final Rectangle etiquetMenu;
    
    protected final int margenGeneral=8;
       protected final Rectangle barraPeso;
    
    
    public SeccionesInventario(final String nombreSecc,final Rectangle etiquetMenu, final EstructSeccionInventarioPrinc em ){
        
        
        this.nombreSecc=nombreSecc;
        this.etiquetMenu=etiquetMenu;
        
         int anchoBarra= 100;
        int altoBarra= 8;
        
        
          barraPeso= new Rectangle(Constantes.ANCHO_JUEGO - anchoBarra - 8, em.BANNER_SUP.height + 8,ObjetosEstaticos.persona.limitPeso,altoBarra );
        
    }
    
    public abstract void actualizar();
    
    public abstract void dibujar(final Graphics g, LectorCanvas sd);
    
    
    public void dibujEtiqueInact(final Graphics g){
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,etiquetMenu,Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, nombreSecc, etiquetMenu.x+15,etiquetMenu.y+12,Color.white);
        
        
        
        
    }
    
    
     protected void dibujLimitPeso(final Graphics g){
        
        final Rectangle contentBarra= new Rectangle( barraPeso.x +1, barraPeso.y+1,
                barraPeso.width/(ObjetosEstaticos.persona.limitPeso/ObjetosEstaticos.persona.pesoActual),barraPeso.height -2);
        
        DibujadorRectangulosImagenes.dibujString(g, "PESO: ", barraPeso.x - 30, barraPeso.y + 7, Color.BLACK);
       
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, barraPeso,Color.GRAY);
          
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, contentBarra,Color.RED);
              
              
    }
    
    
    
    
    
     public void dibujEtiqueAct(final Graphics g){
      
         DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,etiquetMenu,Color.ORANGE);
  
        
        final Rectangle marcaAct= new Rectangle (etiquetMenu.x,etiquetMenu.y,5,etiquetMenu.height);
    //    final Color colorAct= new Color(0xff6700);   //pusimos en el argumento de abajo esto, esto depende de uno
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, marcaAct,new Color(0xff6700)); //puede ser mas lioso poner varias instancias dentro de rectangulo, pero dpeende de cada uno
        
       DibujadorRectangulosImagenes.dibujString(g, nombreSecc, etiquetMenu.x+15,etiquetMenu.y+12,Color.white);
        
        
        
        
        
        
    }
    
    
    
    public void dibujEtiqueInacResalt(final Graphics g){
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, etiquetMenu,Color.WHITE);
        
        
        
               DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,new Rectangle(etiquetMenu.x + etiquetMenu.width -10,etiquetMenu.y +5,5,
                       etiquetMenu.height-10),new Color(0x2a2a2a));
        
               DibujadorRectangulosImagenes.dibujString(g, nombreSecc, etiquetMenu.x+15,etiquetMenu.y+12,Color.BLACK);
    }
    
    
    
    public void dibujEtiqueActResalt(final Graphics g){
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,etiquetMenu,Color.ORANGE);
  
        
        final Rectangle marcaAct= new Rectangle (etiquetMenu.x,etiquetMenu.y,5,etiquetMenu.height);
      
      
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, marcaAct,new Color(0xff6700));
        
        
        
          DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,new Rectangle(etiquetMenu.x + etiquetMenu.width -10,etiquetMenu.y +5,5,
                  etiquetMenu.height -10),new Color(0x2a2a2a));
        
        
        
       DibujadorRectangulosImagenes.dibujString(g, nombreSecc, etiquetMenu.x +15,etiquetMenu.y +12,Color.BLACK);
        
        
    }
    
    public Rectangle obtieneEtiqueMenuEscal(){
   
        final Rectangle etiqueEscal= new Rectangle((int) (etiquetMenu.x * Constantes.FACTOR_ESCAL_X),
                (int) (etiquetMenu.y * Constantes.FACTOR_ESCAL_Y),(int) (etiquetMenu.width * Constantes.FACTOR_ESCAL_X),
                (int) (etiquetMenu.height * Constantes.FACTOR_ESCAL_Y));
        
        
        return etiqueEscal;
        
        
        
    }
    
    
    
    public Rectangle getEtiquetMenu(){
        return etiquetMenu;
    }
    
    
    
    
    public String getNombreSecc(){
        return nombreSecc;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
