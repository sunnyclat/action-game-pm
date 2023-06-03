/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import GRAFICOS.LectorCanvas;
import GRAFICOS.Ventana;
import GESTOR_MAPA.GestorMapaTiled;
import GRAFICOS.paintVideo;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import MAQUINA_DE_ESTADO.GestorDeEstados;
import MenuJuego.EstadoMenu;
import static MenuJuego.EstadoMenu.emp;
//import static MenuJuego.EstadoMenu.file;
//import static MenuJuego.EstadoMenu.pp;
import MenuJuego.EstadoMenuPausa;
import PERIFERICOS.Teclado;
import SONID.Audio;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_logo_position_e;
import uk.co.caprica.vlcj.binding.internal.libvlc_marquee_position_e;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_player_t;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_stats_t;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.binding.internal.libvlc_position_e;
import uk.co.caprica.vlcj.binding.internal.libvlc_state_t;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.DeinterlaceMode;
import uk.co.caprica.vlcj.player.Equalizer;
import uk.co.caprica.vlcj.player.MediaDetails;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.TrackDescription;
import uk.co.caprica.vlcj.player.TrackInfo;
import uk.co.caprica.vlcj.player.TrackType;
import uk.co.caprica.vlcj.player.direct.DirectMediaPlayer;
//import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

//import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author SAMU
 */
public class GestorPrincipal {

    private boolean enFunc = false;
    private String titulo;
    private int ancho;
    private int alto;
 // public  static EmbeddedMediaPlayer empp;
//Graphics g;
    public static LectorCanvas sd;
    public static Ventana vent;
    private GestorDeEstados ge;
    
    
    public paintVideo pv;
    
  //  public Image img= new ImageIcon("bullets.gif").getImage();
   public Point p= new Point();
    
  //  public static JPanel pp= new JPanel();
  
    public boolean isMenu=false;
       //      public   static  String  file=Constantes.BULLETS_WALL;
    private final Teclado teclado;
   // EstadoMenu em= new EstadoMenu();

 //   EstadoMenuPausa emp= new EstadoMenuPausa();
  
    private static int fps;  //estos si son los valores finales por segundo
    private static int aps;

  private Audio musica1 = new Audio(Constantes.MUSICA_VENOM);
   private Audio musica2 = new Audio(Constantes.MUSICA_INTRO);
   
   
    Image img = Toolkit.getDefaultToolkit().getImage("bullets.gif");

    public GestorPrincipal(final String titulo, final int ancho, final int alto) {

        teclado = new Teclado();

        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;

    }

    public static void main(String[] args) {

      
        

  //    ObjetosEstaticos.m.MediaPlayer();
       
       
       
       

       
        inicio();

        
               
  
        
        
        
        
    }

    public static void inicio() {

        //PARA OPENGL EN LINUX/MAC
        //     System.setProperty("sun.java2d.opengl", "True");
        //PARA DIRECTX EN WINDOWS
        System.setProperty("sun.java2d.d3d", "True"); //enciende directx3d
        System.setProperty("sun.java2d.ddforcevram", "True");  //se use eficientemente la vram                                

        System.setProperty("sun.java2d.transaccel", "True"); //mejora rendimiento con graficos transparentes

        GestorPrincipal gp = new GestorPrincipal("Partner Manner", Constantes.ANCHO_FULL_SCREEN, Constantes.ALTO_FULL_SCREEN);

        gp.iniciarJuego();  //1

        gp.iniciarBuclePrinc();

    }

    private void iniciarJuego() {

        enFunc = true;

        inicializarComps(); //2


//musica2.reproduceMusica();
        musica2.reproduceMusica();
        
        

    
                
                
                
 
        /*
        if(ObjetosEstaticos.teclado.play==true){
  
            musica2.l;
            }
        */
        
        
        
        
        
    }

    private void iniciarBuclePrinc() {

     
        
        
        
        int apsAcum = 0;
        int fpsAcum = 0;

        //CREAMOS NUESTRO TEMPORIZADOR
        final int NS_POR_SEGUNDO = 1000000000;  //equivalencia de cuantos nanosegundos hay en un segundo
        final byte APS_OBJETIVO = 60;  //60 actualizaciones por segundo. Mientras mas bajo este numero es mejor, ya que cada vez que representa menos cantidad de veces en las que se actualizara. Tampoco que llegue muy bajo.
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;  //cuanto tiempo debe pasar hasta llegar al objetivo de actualizar 60 veces por segundo.

        long referenciaActualizacion = System.nanoTime(); //tiempo atribuido en nanosegundos en tal momento exacto.
        long referenciaContador = System.nanoTime();//esto va a ser el contador (FPS). Nada que ver con el temporizador.

        double tiempoTranscurrido;  //fijamos una variable
        double delta = 0; //la cantidad de tiempo que pasa hasta que se realiza una actualizacion (en todos los juegos se usa este mismo nombre).

        //una vez entrado en este ciclo del temporizador, se seguira ejecutando y lo de arriba del temporizador no se ejecuta mas.
        while (enFunc) {

            final long inicioBucle = System.nanoTime(); //aca se tomaria una referencia como de inicio del cronometro para el tiempo que empieza transcurrirse usando el nanotime.

            tiempoTranscurrido = inicioBucle - referenciaActualizacion; //medimos el tiempo que ha pasado desde que se tomo la primera referencia de nanotime (fuera del bucle) y la que se inicio dentro del bucle.
            referenciaActualizacion = inicioBucle; //volvemos a aplicar el tiempo de cuando se inicio el bucle. De esta manera las mediciones seran precisas y constantes.

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;  //dividimos el tiempo calculado entre inicio y referencia de actualizacion, por la cantidad de nanosegundos que transcurren por actualizacion. Esto lo almacenamos en delta.

            while (delta >= 1) {

                actualizar(); //cuando delta sea mayor a 1, se actualizara el juego..
                apsAcum++;  //AHORA IRA APS ACA YA QUE NO ES UNA VARIABLE GLOBAL

                delta--;//..y se le restara 1 a delta.

            }
            
  

dibujar();
    
  //EstadoMenu.fondoVideo();
  
  
            fpsAcum++; //AHORA IRA FPS ACA YA QUE NO ES UNA VARIABLE GLOBAL. 

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                //nuestro contador se actualizara cada segundo

                aps = apsAcum;
                fps = fpsAcum;

                apsAcum = 0;
                fpsAcum = 0;

                referenciaContador = System.nanoTime();  //actualizamos por ultima vez la referencia de tiempo.

            }
        }

    }
    
    
    

    private void actualizar() {



       


     
 




   
             ge.actualizar();
             
   // EstadoMenu.play();
   

      
             //     ge.cambiarEstadoActual(3);
  
                 
          if  (ObjetosEstaticos.teclado.play  ){

     
              ge.cambiarEstadoActual(0);
              
      


      musica2.reproduceMusica2();
       


    

       
      if (ObjetosEstaticos.teclado.inventario  ) {
            
    
  
   
    ge.cambiarEstadoActual(1);
     
    
   
     
     
      }
   
         
         
    if (ObjetosEstaticos.teclado.teclaMenuPausa ) {
         
    
           
      //       g.clearRect(0, 0, Constantes.ALTO_FULL_SCREEN, Constantes.ALTO_FULL_SCREEN);
           ge.cambiarEstadoActual(2);
        }
  

                  
          } 
                 

   





      

      
      
      
      
        

          







      
         
 
                 
        

        
        
           //     ge.musica();

        sd.actualizar();
        
           
    

    }

    private void dibujar() {
    
        
  
        sd.dibujar(ge);
         
        
    }



    public static int getAps() {
        return aps;
    }

    public static int getfps() {
        return fps;
    }
    
 
    
    
    

    private void inicializarComps() {
        
        

         

        
  
        sd = new LectorCanvas(ancho, alto);
      
        
        
        
        
        
        
         
    
    
           

       
    
    
    
    
//pv= new paintVideo();

   

        
        
          

        
        
        
        
      //      vent = new Ventana(titulo, sd,pv);
        
          

         vent= new Ventana(titulo,sd);


         
          //  DibujadorRectangulosImagenes.video();
              
             //  vent.add(pp);  
              
     
  
                     
                     
                                  

           
             






                

                  
                
              
            
            
  
            



        










 /*
 
           NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
       
       Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
       
       MediaPlayerFactory mpf= new MediaPlayerFactory();

     
 
           
        empp =  mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(vent));
              
                    
            
          
                    
                    
           empp.setVideoSurface(mpf.newVideoSurface(sd));
           
           
            empp.setEnableMouseInputHandling(true);

       
       
       empp.setEnableKeyInputHandling(true);
       

            
                 empp.prepareMedia(file);
        


               empp.setRepeat(true);
 
 
            

        
        
         //      empp.playMedia(file);
 
  
 */
    
    
    
    /*
 if(ObjetosEstaticos.teclado.play){
empp.release();
 }

*/
       
                   
   
        ge = new GestorDeEstados(sd);
        
         


        
    
        
 
    }
    
    

 
    
    
    
}    
        








