/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuJuego;

import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import SONID.Audio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import principal.Constantes;
import principal.GestorPrincipal;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoMenu implements InterfazGestionadorEstados {

  public static Audio musica1 = new Audio(Constantes.MUSICA_VENOM);
public static Audio musica2 = new Audio(Constantes.MUSICA_INTRO);
   
  
  
  
  
  
  public EstadoMenu(){
      
//musica2.reproduceMusica();
      
      
      
      
      
      
  }
  
  
  
  
  
  @Override
    public void actualizar() {

actualiza();
    }

    @Override
    public void dibujar(Graphics g) {

        
        dibujo(g);
  
    
    }
    
    
    
      public void dibujo(Graphics g ){
                   
    

                  
                   
 
     

 
 

   
   
//g.setColor(Color.(0x174254));

//Color color=new Color(0x0b445c);

//g.setColor(color);

DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO_FULL_SCREEN,Constantes.ALTO_FULL_SCREEN, Color.black);
    


                      g.setFont(Constantes.FUENTE3.deriveFont(40f));
                   
                           
    DibujadorRectangulosImagenes.dibujString(g, "PARTNER", 50, 50, Color.red);
    DibujadorRectangulosImagenes.dibujString(g, "MANNER", 250, 80, Color.blue);
    
    
   //     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 280, 250, 80, 40, Color.white);
    
    g.setFont(Constantes.FUENTE2.deriveFont(20f));
    
    
     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 240, 175, 155, 30, Color.white);
     
     
    DibujadorRectangulosImagenes.dibujString(g, "Empezar Partida", 240, 200, Color.white);

   DibujadorRectangulosImagenes.dibujString(g, "Opciones", 270, 230, Color.white);
   
   DibujadorRectangulosImagenes.dibujString(g, "Cargar Partida", 255, 260, Color.white);
   
        DibujadorRectangulosImagenes.dibujString(g, "Salir", 295, 290, Color.white);
         
                   
                   
               }
      
      
      public  void actualiza(){
                   
          
      
                        final Rectangle cuadroJugar= new Rectangle(240, 175,155,30);
                    
                        Rectangle posicionMouse= GestorPrincipal.sd.getRaton().obtieneRectanguloPosicion();

                                  
            
                        
                    if(GestorPrincipal.sd.getRaton().getClick() &&
                       posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (cuadroJugar) )){
                   
       

   
      
       
          musica1.reproduceMusica();
            
       
       ObjetosEstaticos.teclado.play =true;
        
       
   

           
        
                 
                
           
                    
                    
      
              }
             
           
    
      }



}



            