/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import HERRAMIENTAS.DibujadorRectangulosImagenes;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author samuel ludueña 2021
 */
public class Media {
    
    
     public static EmbeddedMediaPlayer emp;
    
    
    
    public Media(){
        
        
        
        
  
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    public void MediaPlayer(){

             
             
             
             
                 
       //creamos un gui para reproducir el video
      
           //JFRAME (VENTANA)
           
       /*
           JFrame f= new JFrame();
           
           
           f.setLocation(100,100);
       f.setSize(1000,600);
       
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       f.setVisible(true);
       */
       
       
       //creamos intancia al canvas que reproducira el video
       
       
       //CANVAS
       
       
       Canvas c= new Canvas();
       
       //fondo
       
       c.setBackground(Color.black);
      JPanel p= new JPanel();
       p.setLayout(new BorderLayout());
       
       
       //el video va a tomar toda la superficie de la ventana
       /*
       p.add(c);
       f.add(p);
       */
       
       //leemos el video con el vlcj y cargamos el native vlc
       
       
       NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
       
       Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
       
       
       //iniciamos el media player
       
       MediaPlayerFactory mpf= new MediaPlayerFactory();
       
       //controlamos las interacciones con el usuario
       
   /*    
      emp =  mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
       
       
       
       emp.setVideoSurface(mpf.newVideoSurface(c));
       */
       //fullscreen
       
   //    emp.toggleFullScreen();
       
       
       
       //escondemos el cursor
       
   //    emp.setEnableMouseInputHandling(false);
       
       
       //deshabilitamos el keyboard
       
       
  //     emp.setEnableKeyInputHandling(false);
       
       
  
       

       
       //leemos el archivo
            String file=Constantes.BULLETS_WALL;
       
       /*
       
                      g.setFont(Constantes.FUENTE3.deriveFont(40f));
                   
                           
    DibujadorRectangulosImagenes.dibujString(g, "PARTNER", 50, 50, Color.red);
    DibujadorRectangulosImagenes.dibujString(g, "MANNER", 250, 80, Color.blue);
    

    
    g.setFont(Constantes.FUENTE2.deriveFont(20f));
    
    
     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 240, 175, 155, 30, Color.white);
     
     
    DibujadorRectangulosImagenes.dibujString(g, "Empezar Partida", 240, 200, Color.white);

   DibujadorRectangulosImagenes.dibujString(g, "Opciones", 270, 230, Color.white);
   
   DibujadorRectangulosImagenes.dibujString(g, "Cargar Partida", 255, 260, Color.white);
   
        DibujadorRectangulosImagenes.dibujString(g, "Salir", 295, 290, Color.white);
       
        
        */
        
               
       
       //preparamso el archivo para leerse
       
       
       emp.prepareMedia(file);
        
        
        
        
        
        
       emp.play();
       
        
        
        
        
        
        
        
        
    
                   
    
    
                   }
    
    
    
    public static void play(){
        
        
               emp.play();
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
