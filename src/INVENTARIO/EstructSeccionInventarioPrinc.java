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
import ITEMSYARMAS.Armas;
import ITEMSYARMAS.Consumibles;
import ITEMSYARMAS.Manzana;
import principal.GestorPrincipal;
import static principal.ObjetosEstaticos.persona;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstructSeccionInventarioPrinc extends SeccionesInventario {


          Items ItemSeleccionado= null;
int idActual;
    
   DiseñoInventarioPrinc em;
    
    public EstructSeccionInventarioPrinc(String nombreSecc, Rectangle etiquetMenu,DiseñoInventarioPrinc em) {
        super(nombreSecc, etiquetMenu,em);
        
        int anchoBarra= 100;
        int altoBarra= 8;
        

        
        this.em=em;
        
 
    }

    @Override
    public void actualizar() {

 actualizaPosicItemEnMenuPrinc();
 
 
    actualizarSeleccionMouse();
      //  actualizaItemSeleccionado();
 
    }

    @Override
    public void dibujar(Graphics g,LectorCanvas sd) {

        dibujLimitPeso(g); 
        
        dibujCuadradosInv(g,em);
        

        
        if(sd.getRaton().obtieneRectanguloPosicion().
                intersects(EscaladorDeImagen.escalaRectanguloArriba(barraPeso) ) ){
         
                      
      
           
            GeneradorDeTooltips.dibujToolTipPeso(g,sd,ObjetosEstaticos.persona.limitPeso+"/"+ ObjetosEstaticos.persona.pesoActual);
            
     
            
        }
                
        
        dibujaItemsConsumibles(g,em);
        
        
    }
    
    
   
    
    
    private void dibujCuadradosInv(final Graphics g, DiseñoInventarioPrinc em){  //dibuja los cuadrados del inventario en donde iran los items
        
        final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
        
   
        
        
        
        
        for(int j=0; j < 7;j++){
        for(int i=0; i<12;i++){
                 
            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,puntInic.x + i * (Constantes.LADO_SPRITE + margenGeneral ) , 
                    puntInic.y+j*((Constantes.LADO_SPRITE + margenGeneral )),32,32,Color.white);
        }
 
        
        
        
    }
   
    
        
        
        
        
        
        
       }
    
    

    
    
   
     private void dibujaItemsConsumibles(final Graphics g,DiseñoInventarioPrinc em ){
       
         
                 

         
         
        if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
            return;
        }
        
   
        
     
     
                   final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
     
     
     
     
     final int lado= Constantes.LADO_SPRITE;
        
        
        
        
        for(int i=0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++){
            
            
            
            int idActual= ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();
            
            Items itemActual= ObjetosEstaticos.inventario.obtieneIdItm(idActual);
            
           
            
            DibujadorRectangulosImagenes.dibujImagen(g, itemActual.getSprite().getImagen(),itemActual.getPosicEnMenu().x,itemActual.getPosicEnMenu().y );
            
            
         
            
            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntInic.x + i * (lado + 8) + lado - 12,
                 puntInic.y + 32 - 8,12,8);
            
            g.setColor(Color.black);
            
            
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
        
        
          if(ItemSeleccionado != null){
          
            DibujadorRectangulosImagenes.dibujImagen(g, ItemSeleccionado.getSprite().getImagen(),
                    new Point(ItemSeleccionado.getPosicMouse().x, ItemSeleccionado.getPosicMouse().y )          );
        }
        
        
        
        
    }
     
     
     
     
     
     
    
     private void actualizaPosicItemEnMenuPrinc(){
   
         /*
        if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
            return;
        }
        
       */
     
     
     
     
     
        
       for( int i=0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++){

           
        
            final Point puntInic= new Point(em.FONDO.x +16, barraPeso.y + barraPeso.height + margenGeneral );
           
           
           final int lado= Constantes.LADO_SPRITE;
           
           
            idActual = ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();
           
      
           
           
         if(!ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
        
                    ObjetosEstaticos.inventario.obtieneIdItm(idActual).setPosicMenu
        (new Rectangle(puntInic.x + i * (lado + 8),puntInic.y,lado,lado));
           
           
         }else{
             
             
             
                  
            //     ObjetosEstaticos.inventario.items.remove(i);
         }
          
           
           
       } 
        
        
        
        
     }
    



    
    
      private void actualizarSeleccionMouse(){
        
       Rectangle posicionMouse= GestorPrincipal.sd.getRaton().obtieneRectanguloPosicion();
       
       
       
      
          
           
           if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
               return;
           }
          
           
           for(Items i : ObjetosEstaticos.inventario.obtieneConsumible()){
               
               
               if(GestorPrincipal.sd.getRaton().getClick() &&
                       posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (i.getPosicEnMenu()) )){
                   
                //   ItemSeleccionado= null;
 
           
              
                   ObjetosEstaticos.inventario.items.remove(i);
                   
                   
                   
                     //      ObjetosEstaticos.invPersona.getConsum().generaVida();
                   
              
                   
                   System.out.println("tqoue item");
              
   
          
                     
                   
               }
               
               
               
               
          
               
               
               
               
           }
          
           
           
           
           
           
       }
      
      
      
      
       private void actualizaItemSeleccionado(){
       
       if(ItemSeleccionado != null){
         
           /*
           
           if(GestorPrincipal.sd.getRaton().getClick2()){
               ItemSeleccionado = null;
           return;
           }
           
           */
           
           
           
           Point posicionRaton = EscaladorDeImagen.escalarPuntoAbajo(GestorPrincipal.sd.getRaton().getPosicion());
           
           ItemSeleccionado.setPosicMouse(
           new Rectangle(posicionRaton.x,posicionRaton.y, Constantes.LADO_SPRITE,Constantes.LADO_SPRITE));
           
       }
       
       
       
       
       
       
       
       
   }
       
       
           public void eliminarItemSeleccion(){
        ItemSeleccionado= null;
    }
   

       
       
       
       
    }
     
     
     
     
     
     
     
     
     
     
     
    

