/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import GESTOR_MAPA.GestorMapaTiled;
import INVENTARIO.InventarioInferior;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import principal.Constantes;
import principal.ObjetosEstaticos;

import Personajes.Personaje;
import SPRITES.HojaSprites;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.InformacionDebug;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import MenuJuego.EstadoMenuPausa;
import SONID.Audio;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoJuego implements InterfazGestionadorEstados {


String ruta1;
String ruta2;


String ruta=Constantes.RUTA_MAPA_JSON;

    BufferedImage logo;
    
    InventarioInferior invInferior;
    
    

    public EstadoJuego() {

        

        
        
        
        
        
        
    
  invInferior= new InventarioInferior();
        

    
          
    
    
    
    }

    private void recargarJuego() {

     //   final String ruta = Constantes.RUTA_MAPA_JSON2 + ObjetosEstaticos.mt.getSigMap();//ruta del segundo mapa

 
     
     
     
     
     
    ruta1 = Constantes.RUTA_MAPA_JSON;
    ruta2=Constantes.RUTA_MAPA_JSON2;
   
    
   
   
    if(!(ruta.contentEquals(Constantes.RUTA_MAPA_JSON2))){
   
   ruta=Constantes.RUTA_MAPA_JSON2;
        
        
   

     

                     ObjetosEstaticos.mt= new GestorMapaTiled(ruta);
     
        
        
             
     ObjetosEstaticos.persona.setIntPosicX(ObjetosEstaticos.mt.puntoInicial.getX());       
     ObjetosEstaticos.persona.setIntPosicY(ObjetosEstaticos.mt.puntoInicial.getY());
     
    
  //  ruta = Constantes.RUTA_MAPA_JSON;
    
    
        System.out.println("pase 1");

   
     }else{
        
          ruta=Constantes.RUTA_MAPA_JSON;
    
          System.out.println("pase 2");
        
        
                ObjetosEstaticos.mt= new GestorMapaTiled(ruta);
     
        
        
             
     ObjetosEstaticos.persona.setIntPosicX(ObjetosEstaticos.mt.puntoInicial.getX());       
     ObjetosEstaticos.persona.setIntPosicY(ObjetosEstaticos.mt.puntoInicial.getY());
     
        
        
    }
         
  
        
     


    }


    @Override
    public void actualizar() {

        
        if ( (ObjetosEstaticos.persona.getLIMITE_ARRIBA().intersects(ObjetosEstaticos.mt.getZonaSalida() ))) {
            recargarJuego();

        }

        /*
            if(ObjetosEstaticos.persona.getLimite_abajo().intersects(ObjetosEstaticos.mt.getZonaSalida()  )){
            recargarJuego();
        }
        
            
                if(ObjetosEstaticos.persona.getLimite_izquierda().intersects(ObjetosEstaticos.mt.getZonaSalida()  )){
            recargarJuego();
        }
        
                
                    if(ObjetosEstaticos.persona.getLimite_derecha().intersects(ObjetosEstaticos.mt.getZonaSalida()  )){
            recargarJuego();
        }
        */
         
              




        
 ObjetosEstaticos.persona.actualizar();
     
        

        ObjetosEstaticos.mt.actualizar( );
        
        
      
  
        
   
    }

    @Override
    public void dibujar(Graphics g) {
   
        
   
        
       ObjetosEstaticos.mt.dibujar(g);
      

        ObjetosEstaticos.persona.dibujadoDelPersonaje(g); //llama al metodo de personaje donde termian dibujandolo aca
        
        invInferior.dibujar(g);
         
        
        InformacionDebug.enviaDatos("X = " + ObjetosEstaticos.persona.obtenIntPosicX());
        InformacionDebug.enviaDatos("Y = " + ObjetosEstaticos.persona.obtenIntPosicY());

         DibujadorRectangulosImagenes.dibujString(g, "F5: GUARDA PARTIDA ", 10, 30, Color.ORANGE);

        DibujadorRectangulosImagenes.dibujString(g, "F9: CARGA PARTIDA ", 10, 40, Color.ORANGE);

        DibujadorRectangulosImagenes.dibujString(g, "E: AGARRAR OBJETO ", 10, 50, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "CTRL IZQ: ATACAR ", 10, 60, Color.ORANGE);

        DibujadorRectangulosImagenes.dibujString(g, "SHIFT IZQ: CORRER ", 10, 70, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "W: ARRIBA ", 10, 80, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "S: ABAJO ", 10, 90, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "A: IZQ ", 10, 100, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "D: DER ", 10, 110, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "I: INVENTARIO ", 10, 120, Color.ORANGE);
        DibujadorRectangulosImagenes.dibujString(g, "P: PAUSA ", 10, 130, Color.ORANGE);

        
        

        //CONEXION SIGUIENTE MAPA
        
       
        
        
               // DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, (int)ObjetosEstaticos.mt.getZonaSalida().getX(), (int)ObjetosEstaticos.mt.getZonaSalida().getY(), Constantes.LADO_SPRITE, Constantes.LADO_SPRITE, Color.white);
        
               DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, (int)ObjetosEstaticos.mt.getZonaSalida().getX(), (int)ObjetosEstaticos.mt.getZonaSalida().getY(), 20, 20, Color.white);
               
               
    //    InformacionDebug.enviaDatos("MAPA SIGUIENTE = " + ObjetosEstaticos.mt.getSalida());
       
        InformacionDebug.enviaDatos("X = " + ObjetosEstaticos.mt.getSalida().getX()
                + "Y = " + ObjetosEstaticos.mt.getSalida().getY());
        
        
        
        
        
        
        
        


    }



}
