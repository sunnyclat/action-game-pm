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

//  private Audio musica2 = new Audio(Constantes.MUSICA_INTRO);
  //  private Audio musica1 = new Audio(Constantes.MUSICA_VENOM);

    BufferedImage logo;
    
    InventarioInferior invInferior;
    
    

    public EstadoJuego() {

        
     //  musica1.reproduceMusica();
        
        
        
        
        
        
    
  invInferior= new InventarioInferior();
        
        
     //   logo = CargadorRecursos.cargarImageCompatibleTranslucida(Constantes.RUTA_LOGOTIPO);
    
          
    
    
    
    }
/*
    private void recargarJuego() {

        final String ruta = "/recurS/texto/" + ObjetosEstaticos.mt.getSigMap();//ruta del segundo mapa

        
        
        ObjetosEstaticos.mt= new GestorMapaTiled(ruta);
     
  //   ObjetosEstaticos.persona.setIntPosicX(ObjetosEstaticos.mt.getPosicInic().x);         //de esta forma se arregla el bug al entrar a otro mapa.
   //  ObjetosEstaticos.persona.setIntPosicY(ObjetosEstaticos.mt.getPosicInic().y);

    }
*/

    @Override
    public void actualizar() {
/*
        if (ObjetosEstaticos.persona.getLIMITE_ARRIBA().intersects(ObjetosEstaticos.mt.getZonaSalida() ) ) {
            recargarJuego();

        }

        
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
     
        
      //     ElementosPrincipales.mapa.actualizar( );
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
        
        /*
        DatosDebug.enviaDatos("MAPA SIGUIENTE = " + ElementosPrincipales.mapa.getSigMap());
        DatosDebug.enviaDatos("X = " + ElementosPrincipales.mapa.getPosicSalida().getX() 
                + "Y = " + ElementosPrincipales.mapa.getPosicSalida().getY());
        */
        
        
        
        
        
        
        


    }



}
