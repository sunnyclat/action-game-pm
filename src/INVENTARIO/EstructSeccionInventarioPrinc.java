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
import ITEMSYARMAS.Manzanas;
import ITEMSYARMAS.Pocion;

import principal.GestorPrincipal;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstructSeccionInventarioPrinc extends SeccionesInventario {

    int canttt = 0;
    Items ItemSeleccionado = null;

    Items itemActual;
    int cantt = 0;
    int cant3 = 0;
    int cant4 = 0;

    int idActual;
    int manzana;
    int pocion;
    
    
        boolean flag = false;

    DiseñoInventarioPrinc em;

    public EstructSeccionInventarioPrinc(String nombreSecc, Rectangle etiquetMenu, DiseñoInventarioPrinc em) {
        super(nombreSecc, etiquetMenu, em);

        int anchoBarra = 100;
        int altoBarra = 8;

        this.em = em;

    }

    @Override
    public void actualizar() {

        actualizaPosicItemEnMenuPrinc();

        actualizarSeleccionMouse();
        //  actualizaItemSeleccionado();

    }

    @Override
    public void dibujar(Graphics g, LectorCanvas sd) {

        dibujLimitPeso(g);

        dibujCuadradosInv(g, em);



        if (sd.getRaton().obtieneRectanguloPosicion().
                intersects(EscaladorDeImagen.escalaRectanguloArriba(barraPeso))) {

            GeneradorDeTooltips.dibujToolTipPeso(g, sd, ObjetosEstaticos.persona.limitPeso + "/" + ObjetosEstaticos.persona.pesoActual);

        }

        dibujaItemsConsumibles(g, em);
        
        
                DibujadorRectangulosImagenes.dibujString(g, "Vida: " + ObjetosEstaticos.persona.getVidaMax(), 20, 160, Color.red);

    }

    private void dibujCuadradosInv(final Graphics g, DiseñoInventarioPrinc em) {  //dibuja los cuadrados del inventario en donde iran los items

        final Point puntInic = new Point(em.FONDO.x + 16, barraPeso.y + barraPeso.height + margenGeneral);

        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 12; i++) {

                DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntInic.x + i * (Constantes.LADO_SPRITE + margenGeneral),
                        puntInic.y + j * ((Constantes.LADO_SPRITE + margenGeneral)), 32, 32, Color.white);
            }

        }

    }

    private void dibujaItemsConsumibles(final Graphics g, DiseñoInventarioPrinc em) {

        if (ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()) {
            return;
        }

        final Point puntInic = new Point(em.FONDO.x + 16, barraPeso.y + barraPeso.height + margenGeneral);

        final int lado = Constantes.LADO_SPRITE;

        for (int i = 0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++) {

            idActual = ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();

            itemActual = ObjetosEstaticos.inventario.obtieneIdItm(idActual);

            DibujadorRectangulosImagenes.dibujImagen(g, itemActual.getSprite().getImagen(), itemActual.getPosicEnMenu().x, itemActual.getPosicEnMenu().y);

            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntInic.x + i * (lado + 8) + lado - 12,
                    puntInic.y + 32 - 8, 12, 8);

           g.setColor(Color.black);

            String texto;

            if (itemActual.getCant() > 0) {

                texto = "0" + itemActual.getCant();

            } else {
                texto = "" + itemActual.getCant();
            }

            g.setFont(g.getFont().deriveFont(10f));

            DibujadorRectangulosImagenes.dibujString(g, texto, puntInic.x + i * (lado + 8) + lado
                    - MedidorString.medirAnchoPixel(g, texto), puntInic.y + 31);

        }

        g.setFont(g.getFont().deriveFont(12f));

        if (ItemSeleccionado != null) {

            DibujadorRectangulosImagenes.dibujImagen(g, ItemSeleccionado.getSprite().getImagen(),
                    new Point(ItemSeleccionado.getPosicMouse().x, ItemSeleccionado.getPosicMouse().y));
        }

    }

    private void actualizaPosicItemEnMenuPrinc() {

        /*
        if(ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()){
            return;
        }
        
         */
        for (int i = 0; i < ObjetosEstaticos.inventario.obtieneConsumible().size(); i++) {

            final Point puntInic = new Point(em.FONDO.x + 16, barraPeso.y + barraPeso.height + margenGeneral);

            final int lado = Constantes.LADO_SPRITE;

            idActual = ObjetosEstaticos.inventario.obtieneConsumible().get(i).getId();

            //   System.out.println(idActual);
            if (!ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()) {

                ObjetosEstaticos.inventario.obtieneIdItm(idActual).setPosicMenu(new Rectangle(puntInic.x + i * (lado + 8), puntInic.y, lado, lado));

            }

        }

    }

    private void actualizarSeleccionMouse() {

        Rectangle posicionMouse = GestorPrincipal.sd.getRaton().obtieneRectanguloPosicion();

//int cantt=0;
        // int cant2=ObjetosEstaticos.inventario.obtieneIdItm(idActual).getCant();   
        // int cant3=0;
        //     int cant4=0;
        //   int cant3=0;
//      int cantt=0;
    

        if (ObjetosEstaticos.inventario.obtieneConsumible().isEmpty()) {
            return;
        }

        //      canttt=cant4;
        
        
        
        
        
        
        
        
        
        
        
        
        
        for (Items i : ObjetosEstaticos.inventario.obtieneConsumible()) {

            
            
            
            
            
              System.out.println("aqui1 " + cant4);
              
              
              
         
              
            
            if (GestorPrincipal.sd.getRaton().getClick()
                    && posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba(i.getPosicEnMenu())) ) {
                
                
                
                
                
                
                
                
                            
                    if(ObjetosEstaticos.persona.vidaMax==100){
                        
                        
                        return;
                    }
                    
                
                
                
                
                

                
                GestorPrincipal.sd.getRaton().reiniciarClick();
                
                cantt = i.getCant();

                cant3 = cantt;
                
                
                   System.out.println("aqui2 " + cant4);

                if (cant3 > 0) {
              
                    
                    //cant3 = cant3 - 1;

                    cant4 = cant3-1;
                    
                    
                    
                           if(cant4==0){
                  
                  ObjetosEstaticos.inventario.items.remove(i);
                  
              }
                    
                    

                }

                if (cant4 >= 0) {

                    i.setCant(cant4);

                    flag = true;
                    System.out.println("aqui3 " + cant4);

                    
             
                }

         

                
                
            
                
                
                
                
                
                
                

                if (i instanceof Manzanas) {
                    
                    
                    
        
                    
                    
                    
                    
                    int cant6=cant4;
                    
                    cant6=cant3-cant4;

                    manzana = ObjetosEstaticos.persona.cargadorManzana() * (cant6);
                    
                    
                    
                    
                    

                    ObjetosEstaticos.persona.cargaVidaPersonaje(manzana);

                    
       
                     
              
                }

                if (i instanceof Pocion) {

                    pocion = ObjetosEstaticos.persona.cargadorPocion() * cantt;

                    ObjetosEstaticos.persona.cargaVidaPersonaje(pocion);

                    /*
              if(cantt==0){
                  
                  ObjetosEstaticos.inventario.items.remove(i);
                  
              }
                     */
                }

            }

            //    }
      
        }

    }

    private void actualizaItemSeleccionado() {

        if (ItemSeleccionado != null) {

            /*
           
           if(GestorPrincipal.sd.getRaton().getClick2()){
               ItemSeleccionado = null;
           return;
           }
           
             */
            Point posicionRaton = EscaladorDeImagen.escalarPuntoAbajo(GestorPrincipal.sd.getRaton().getPosicion());

            ItemSeleccionado.setPosicMouse(
                    new Rectangle(posicionRaton.x, posicionRaton.y, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE));

        }

    }

    public void eliminarItemSeleccion() {
        ItemSeleccionado = null;
    }

}
