/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;
import principal.ObjetosEstaticos;
import GRAFICOS.LectorCanvas;
import ITEMSYARMAS.ItemsDelInventario;
import ITEMSYARMAS.Items;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import HERRAMIENTAS.GeneradorDeTooltips;
import static HERRAMIENTAS.GeneradorDeTooltips.dibujToolTipPeso;
import HERRAMIENTAS.MedidorString;

/**
 *
 * @author samuel ludueña 2021
 */
public class Inventario extends SeccionesInventario {


    

    
   EstructSeccionInventarioPrinc em;
    
    public Inventario(String nombreSecc, Rectangle etiquetMenu,EstructSeccionInventarioPrinc em) {
        super(nombreSecc, etiquetMenu,em);
        
        int anchoBarra= 100;
        int altoBarra= 8;
        

        
        this.em=em;
        
 
    }

    @Override
    public void actualizar() {

 actualizaPosicMenu();
        
        
    }

    @Override
    public void dibujar(Graphics g,LectorCanvas sd) {

        dibujLimitPeso(g); 
        
        dibujElementInv(g,em);
        
//dibujSpritesInv(g,em);
                
        dibujPaginador(g,em);
        
        if(sd.getRaton().obtieneRectanguloPosicion().
                intersects(EscaladorDeImagen.escalaRectanguloArriba(barraPeso) ) ){
         
                      
      
           
            GeneradorDeTooltips.dibujToolTipPeso(g,sd,ObjetosEstaticos.persona.limitPeso+"/"+ ObjetosEstaticos.persona.pesoActual);
            
     
            
        }
                
        
        dibujaItemsConsumibles(g,em);
        
        
    }
    
    
   
    
    
    private void dibujElementInv(final Graphics g, EstructSeccionInventarioPrinc em){
        
        final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
        
        g.setColor(Color.WHITE);
        
        
        
        
        for(int j=0; j < 7;j++){
        for(int i=0; i<12;i++){
                 
            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,puntInic.x + i * (Constantes.LADO_SPRITE + margenGeneral ) , 
                    puntInic.y+j*((Constantes.LADO_SPRITE + margenGeneral )),32,32);
        }
 
        
        
        
    }
   
    
        
        
        
        
        
        
       }
    
    

    
    
    
    
        private void dibujPaginador(final Graphics g, EstructSeccionInventarioPrinc em){
         
            final int anchoBoton= 32;
            final int altoBoton=16;
            
     
           
           
              final Rectangle anterior= new Rectangle( em.FONDO.x + 400 , em.FONDO.y +310 , anchoBoton , altoBoton    );
            
            
              final Rectangle siguiente= new Rectangle(  anterior.x + anterior.width + margenGeneral, anterior.y, anchoBoton,altoBoton  );
            
              
              
              g.setColor(Color.GREEN);
                    

                    DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,anterior);
              
                    DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,siguiente);
              
        
              
         
              
        }
    
     private void dibujaItemsConsumibles(final Graphics g,EstructSeccionInventarioPrinc em ){
       
         
                 

         
         
        if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
            return;
        }
        
   
        
     
     
                   final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
     
     
     
     
     final int lado= Constantes.LADO_SPRITE;
        
        
        
        
        for(int i=0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++){
            
            int idActual= ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();
            
            Items itemActual= ObjetosEstaticos.inventario.obtieneIdItm(idActual);
            
            DibujadorRectangulosImagenes.dibujImagen(g, itemActual.getSprite().getImagen(),itemActual.getPosicMenu().x,itemActual.getPosicMenu().y );
            
            
            
            g.setColor(Color.black);
            
            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntInic.x + i * (lado + 8) + lado - 12,
                 puntInic.y + 32 - 8,12,8);
            
            g.setColor(Color.white);
            
            
            String texto;
            
            if(itemActual.getCant() < 10){
           
                 texto= "0" + itemActual.getCant();
                
            }else{
                texto= "" + itemActual.getCant();
            }
            
            
            g.setFont(g.getFont().deriveFont(10f));
            
            DibujadorRectangulosImagenes.dibujString(g, texto, puntInic.x + i * (lado + 8) + lado -
                    MedidorString.medirAnchoPixel(g, texto), puntInic.y + 31);
            
            
            
            
            
            
            
        }
        
         g.setFont(g.getFont().deriveFont(12f));
        
        
        
        
        
        
        
    }
    
     private void actualizaPosicMenu(){
   
        if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
            return;
        }
        
        
        
       for( int i=0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++){

           
            final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
           
           
           final int lado= Constantes.LADO_SPRITE;
           
           
           int idActual = ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();
           
           ObjetosEstaticos.inventario.obtieneIdItm(idActual).setPosicMenu
        (new Rectangle(puntInic.x + i * (lado + 8),puntInic.y,lado,lado));
           
           
           
           
           
           
           
       } 
        
        
        
        
        
    }
    
    
    
}
