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
import principal.GestorPrincipal;
import principal.Constantes;
import principal.ObjetosEstaticos;
import GRAFICOS.LectorCanvas;
import ITEMSYARMAS.Items;
import ITEMSYARMAS.Armas;

import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import HERRAMIENTAS.GeneradorDeTooltips;
import HERRAMIENTAS.MedidorString;
import ITEMSYARMAS.Espada;
import ITEMSYARMAS.Pistola;
import ITEMSYARMAS.SinArmas;


/**
 *
 * @author samuel ludueña 2021
 */
public class EstructSeccionInventarioEquipo extends SeccionesInventario {

    
    DiseñoInventarioPrinc em= new DiseñoInventarioPrinc();
    
    //los paneles son las secciones items, equipo y atributos del menu equipo
    
    
    
    final Rectangle panelItems= new Rectangle(em.FONDO.x + 8,
    barraPeso.y+ barraPeso.height + 8,248,Constantes.ALTO_JUEGO- barraPeso.y - barraPeso.height - 8 * 2);
    
    final Rectangle tituloRectPanelItems= new Rectangle(panelItems.x,panelItems.y,panelItems.width,24);
    
   
    
    
    final Rectangle panelEquipo= new Rectangle(panelItems.x + panelItems.width + 8, panelItems.y,88, panelItems.height);
    
     final Rectangle tituloRectPanelEquipo= new Rectangle(panelEquipo.x,panelEquipo.y,panelEquipo.width,24);
    
    
     
     final Rectangle panelAtributos= new Rectangle (panelEquipo.x + panelEquipo.width + 8,panelItems.y,
             132,panelEquipo.height );
     
      final Rectangle tituloRectPanelAtributos= new Rectangle(panelAtributos.x,panelAtributos.y, panelAtributos.width, 24);

      
      final Rectangle etiqueArma= new Rectangle(tituloRectPanelEquipo.x + 8,tituloRectPanelEquipo.y + tituloRectPanelEquipo.height + 8,
              tituloRectPanelEquipo.width - 8 * 2, 8 * 2 + MedidorString.medirAltoPixel(GestorPrincipal.sd.getGraphics(), "ARMA")   );
      
      
      
      final Rectangle contieneArma= new Rectangle(etiqueArma.x + 1, etiqueArma.y + etiqueArma.height,
              etiqueArma.width - 2, Constantes.LADO_SPRITE);
      
      Items ItemSeleccionado= null;
      
      
      
    public EstructSeccionInventarioEquipo(String nombreSecc, Rectangle etiquetMenu,DiseñoInventarioPrinc em) {
        super(nombreSecc, etiquetMenu,em);
    }

    @Override
    public void actualizar() {
       
        actualizaPosicItemEnMenuEquip();
         actualizarSeleccionMouse();
         actualizaItemSeleccionado();

    }

    
   private void actualizarSeleccionMouse(){
        
       Rectangle posicionMouse= GestorPrincipal.sd.getRaton().obtieneRectanguloPosicion();
       
       
       
       if(posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (panelItems)   )    ){ //items del menu equipo
          
           
           if(ObjetosEstaticos.inventario.obtieneArmas().isEmpty()){
               return;
           }
          
           
           for(Items i : ObjetosEstaticos.inventario.obtieneArmas()){
               
               
               if(GestorPrincipal.sd.getRaton().getClick() &&
                       posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (i.getPosicEnMenu()) )){
                   
                   ItemSeleccionado= i;  //selecciono al item.
                   
           
                 
                 
                 
                 
                 
                 
               }
               
               
               
               
               
               
               
               
               
           }
           
           
           
           
           
           
           
       }else if(posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (panelEquipo)   )    ){ //equipo (objeto equipado) del menu equipo
           
           if(ItemSeleccionado != null && ItemSeleccionado instanceof Armas
                   && GestorPrincipal.sd.getRaton().getClick() 
                   && posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba(contieneArma))){
               
               
                             ObjetosEstaticos.persona.getEquipoPersonaje().setSinArmas((Armas)ItemSeleccionado);
               ObjetosEstaticos.persona.getEquipoPersonaje().setEspada((Armas)ItemSeleccionado);
               ObjetosEstaticos.persona.getEquipoPersonaje().setPistola((Armas)ItemSeleccionado);
               
               
               ItemSeleccionado= null;  //cuando haga click para ponerlo en equipo desaparece.
               
           }
           
           
           
           
           
       }else if(posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (panelAtributos)   )    ){
           
       }
       
       
       
       
       
       
       
       
    }
   
   
   
   /*
   
      public void eliminarItemSeleccionn(){
        ItemSeleccionado= null;
    }
   
     */ 
      
      
      
      
      /*
   public Items getItemseleccion(){
       return ItemSeleccionado;
   }
   */
   
   private void actualizaItemSeleccionado(){
       
       if(ItemSeleccionado != null){
         
           if(GestorPrincipal.sd.getRaton().getClick2()){
               ItemSeleccionado = null;
           return;
           }
           
           
           
           
           
           Point posicionRaton = EscaladorDeImagen.escalarPuntoAbajo(GestorPrincipal.sd.getRaton().getPosicion());  //traemos nuestra posicion del cursor
           
           ItemSeleccionado.setPosicMouse(                                                                    //traemos la posicion del mouse al item seleccionado asi se dibuja
           new Rectangle(posicionRaton.x,posicionRaton.y, Constantes.LADO_SPRITE,Constantes.LADO_SPRITE));
           
       }
       
       
       
       
       
       
       
       
   }
   
   
    
    private void actualizaPosicItemEnMenuEquip(){  //posicion del item dentro del menu equipo
   
        if(ObjetosEstaticos.inventario.obtieneArmas().isEmpty()){
            return;
        }
        
        
        
       for( int i=0; i < ObjetosEstaticos.inventario.obtieneArmas().size(); i++){
        
           final Point puntInic= new Point(tituloRectPanelItems.x + 8,
                   tituloRectPanelItems.y + tituloRectPanelItems.height + 8 );
           
           final int lado= Constantes.LADO_SPRITE;
           
           
           int idActual = ObjetosEstaticos.inventario.obtieneArmas().get(i).getId();
           
           ObjetosEstaticos.inventario.obtieneIdItm(idActual).setPosicMenu
        
        (new Rectangle(puntInic.x + i * (lado + 8),puntInic.y,lado,lado));
           
           
           
           
           
           
           
       } 
        
        
        
        
        
    }
    
    
    
    
    

    public void dibujar(Graphics g, LectorCanvas sd) {
  
        
        dibujLimitPeso(g); 
  
  
dibujaPaneles(g);


    

  if(sd.getRaton().obtieneRectanguloPosicion().
                intersects(EscaladorDeImagen.escalaRectanguloArriba(barraPeso) ) ){
         
                      
      
           
            GeneradorDeTooltips.dibujToolTipPeso(g,sd,ObjetosEstaticos.persona.limitPeso+"/"+ ObjetosEstaticos.persona.pesoActual);
            
     
            
        }
  
  
    }
    
    
    private void dibujaPaneles(final Graphics g){  //trae metodos dibuja panel items y panel arma equipada
        
          
  dibujaPanelItems(g, panelItems,tituloRectPanelItems,"ITEMS");
    
  dibujaPanelEquipo(g,panelEquipo,tituloRectPanelEquipo,"EQUIPO");
    
 // dibujaPanelAtributos(g, panelAtributos,tituloRectPanelAtributos,"ATRIBUTOS");
        
        
        
    }
    
    
    
    private void dibujaPanelItems(final Graphics g, final Rectangle panel, final Rectangle tituloPanel, final String nombrePanel){  //trae metodo dibujado arma equipada
        
        
       
        dibujaPanel(g, panel,tituloPanel,nombrePanel);
           dibujaItemsEquip(g,panel,tituloPanel);
        //dibujar items
    
        
        
        
    }
    
    private void dibujaPanelEquipo(final Graphics g, final Rectangle panel, final Rectangle tituloPanel, final String nombrePanel){  //dibuja el arma equipada
        
        
        
        dibujaPanel(g, panel,tituloPanel,nombrePanel);
      
        //dibujamos ranuras equipo
        
        g.setColor(Color.BLACK);
        
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, etiqueArma);
        
        DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, contieneArma);
        
            
  
        
            

           
           
           
            if( !(ObjetosEstaticos.persona.getEquipoPersonaje().getPistola() instanceof Pistola) ){
            
            Point coordImagen= new Point (contieneArma.x + contieneArma.width / 2 - Constantes.LADO_SPRITE / 2,
           contieneArma.y );
            
          DibujadorRectangulosImagenes.dibujImagen(g, ObjetosEstaticos.persona.getEquipoPersonaje().getPistola().getSprite().getImagen(), coordImagen);
            
          
            }
           
           
          
          
          
            if( !(ObjetosEstaticos.persona.getEquipoPersonaje().getEspada() instanceof Espada) ){
            
            Point coordImagen= new Point (contieneArma.x + contieneArma.width / 2 - Constantes.LADO_SPRITE / 2,
           contieneArma.y );
            
          DibujadorRectangulosImagenes.dibujImagen(g, ObjetosEstaticos.persona.getEquipoPersonaje().getEspada().getSprite().getImagen(), coordImagen);
            
          
            }
           
          
          
          
          
          
       
        g.setColor(Color.yellow);
    
        
        DibujadorRectangulosImagenes.dibujString(g, "ARMA",
                new Point(etiqueArma.x + etiqueArma.width / 2 - MedidorString.medirAnchoPixel(g, "ARMA") / 2,
                etiqueArma.y + etiqueArma.height / 2 + MedidorString.medirAltoPixel(g, "ARMA") / 2));
        
        
          //dibujamos area equipada
        
    
        
        
        
        
        
        
        
    }
    

    
    private void dibujaItemsEquip(final Graphics g,final Rectangle panelItems, final Rectangle tituloPanel ){ //aca dibuja los items del equipo
       
        if(ObjetosEstaticos.inventario.obtieneArmas().isEmpty()){
            return;
        }
        
        
        final Point puntInic= new Point(tituloPanel.x + 8, tituloPanel.y + tituloPanel.height + 8);
        
        
        final int lado= Constantes.LADO_SPRITE;
        
        
        
        
        for(int i=0; i < ObjetosEstaticos.inventario.obtieneArmas().size(); i++){
            
            int idActual= ObjetosEstaticos.inventario.obtieneArmas().get(i).getId();
            
            Items itemActual= ObjetosEstaticos.inventario.obtieneIdItm(idActual);
            
            DibujadorRectangulosImagenes.dibujImagen(g, itemActual.getSprite().getImagen(),itemActual.getPosicEnMenu().x,itemActual.getPosicEnMenu().y );
            
            
            
     
            
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
        
        if(ItemSeleccionado != null){
          
            DibujadorRectangulosImagenes.dibujImagen(g, ItemSeleccionado.getSprite().getImagen(),
                    new Point(ItemSeleccionado.getPosicMouse().x, ItemSeleccionado.getPosicMouse().y )          );
        }
        
        
        
        
        
    }
    
    
    
    private void dibujaPanel(final Graphics g, final Rectangle panel, final Rectangle tituloPanel,final String nombrePanel  ){
        
        g.setColor(Color.white);
  

  
  DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, panel);
    DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, tituloPanel);
    
    g.setColor(Color.red);
   
    DibujadorRectangulosImagenes.dibujString(g, nombrePanel,
            new Point(
                    tituloPanel.x +   tituloPanel.width / 2 
                            - MedidorString.medirAnchoPixel(g, nombrePanel) / 2 ,
                    tituloPanel.y +  tituloPanel.height  
                            - MedidorString.medirAltoPixel(g, nombrePanel) / 2 - 5 ) ) ;
         g.setColor(Color.white);
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
