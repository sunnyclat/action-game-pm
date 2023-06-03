/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuJuego;

import GRAFICOS.LectorCanvas;
import GRAFICOS.Ventana;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import SONID.Audio;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import principal.Constantes;
import principal.GestorPrincipal;
//import static principal.GestorPrincipal.empp;
//import static principal.GestorPrincipal.file;
import static principal.GestorPrincipal.sd;
import static principal.GestorPrincipal.vent;
import principal.ObjetosEstaticos;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoMenu implements InterfazGestionadorEstados {

  public static Audio musica1 = new Audio(Constantes.MUSICA_VENOM);
public static Audio musica2 = new Audio(Constantes.MUSICA_INTRO);



public Image img= new ImageIcon("bullets3.gif").getImage();


//Image img = Toolkit.getDefaultToolkit().getImage("bullets.gif");


//BufferedImage img =Toolkit.getDefaultToolkit().createImage("bullets.gif");

  private Timer timer;
    private int delay;
    
    
    
 //private  Image img;

   public Point p= new Point();
   
	//Image image =   Toolkit.getDefaultToolkit().getImage("bullets.GIF");




//Image img= new ImageIcon(getClass().getResource("bullets.GIF")).getImage();


  public  static EmbeddedMediaPlayer emp;
  
   // public   String file= Constantes.BULLETS_WALL;
    
    
 //   public String file2="bullets.GIF";
                 

       JPanel pp= new JPanel();          

  
  
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
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
      public  void dibujo(Graphics g ){
                   

          
          
 //DibujadorRectangulosImagenes.video();

      




     DibujadorRectangulosImagenes.dibujImagen2(g, img, p);

      
    //     DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, 0, 0,Constantes.ANCHO_FULL_SCREEN,Constantes.ALTO_FULL_SCREEN, Color.white);
                
                    
        g.setFont(Constantes.FUENTE3.deriveFont(40f));
        
          DibujadorRectangulosImagenes.dibujString(g, "PARTNER", 50, 50, Color.red);
    DibujadorRectangulosImagenes.dibujString(g, "MANNER", 250, 80, Color.blue);
    
        
          

      g.setFont(Constantes.FUENTE2.deriveFont(20f));
    
     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 240, 175, 155, 30, Color.black);
     
     
    DibujadorRectangulosImagenes.dibujString(g, "Empezar Partida", 240, 200, Color.black);

   DibujadorRectangulosImagenes.dibujString(g, "Opciones", 270, 230, Color.black);
   
   DibujadorRectangulosImagenes.dibujString(g, "Cargar Partida", 255, 260, Color.black);
   
        DibujadorRectangulosImagenes.dibujString(g, "Salir", 295, 290, Color.black);
        
      
        
        
   
      //  g.drawImage(img, p.x, p.y, null);
        

     
                
              
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



            