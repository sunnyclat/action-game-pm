/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import principal.Constantes;
import principal.GestorPrincipal;
//import static principal.GestorPrincipal.file;
import static principal.GestorPrincipal.sd;
import static principal.GestorPrincipal.vent;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


/**
 *
 * @author samuel ludueña 2021
 */
public class DibujadorRectangulosImagenes {
    
    //final constante, siendo objeto pide instanciarse en el constructor y no se puede heredar. una variable acumuladora o contadora no puede ponerse en final
//no se puede sobrecargar a un metodo 
    
//static  convierte en globales las variables de una clase.
    //si un metodo es static, 1-tienen que ser variables static su contenido
    // 2-los metodos al ser static, pueden llamarse de la clase desde cualquier otra clase, 
 //      sin tener que crearse un objeto y antes importar la clase, o pasarse por parametro el objeto de la clase para usarse 
//3-los metodos al ser static no se pueden llamar desde el objeto de esa clase, solo desde la clase.
   
    

//si una variable es final y estatica no se les puede asignar un valor
    
    
   public static JPanel jp; 
    private  static int contDibuj=0;            
    
JLabel background ;

      public static JPanel pp= new JPanel();     
       
  public  static EmbeddedMediaPlayer empp;
    public static String filee= Constantes.BULLETS_WALL;
    
        public static String file2= "bullets.gif";
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y){
    
        contDibuj++;
        g.drawImage(img,x,y,null);
        
        
        
    }
    
    
     public  static void dibujImagen(final Graphics g, final BufferedImage img, final Point p){
       contDibuj++;
          g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    
    
    
    
       
     public  static void dibujImagen2(final Graphics g, final Image img, final Point p){
   
  
//            jp.setLayout(new BorderLayout());
         contDibuj++;
             g.drawImage(img,p.x,p.y,sd);
             
             
           
          
         //	g.dispose();
                
               
         /*
         jp.add(new JPanel(){
             
             public void paintComponent(Graphics g){
                 
                 
                 
                 super.paintComponent(g);
                          
 // super.paint(g);
                         g.drawImage(img,p.x,p.y,this);
             }
             
             
         });
         
         
         */
         
         
        
         
         
         
         

          
          
          
        
        
        
    }
    
   
     
     
     
     public static void video(){
         
         
           
 
   //     Graphics2D g = (Graphics2D) g;

//vent.createBufferStrategy(1);



//pp.setLayout(new FlowLayout(FlowLayout.CENTER,Constantes.ANCHO_FULL_SCREEN,Constantes.ANCHO_FULL_SCREEN));


//pp.setLayout(new FlowLayout(FlowLayout.CENTER,Constantes.ANCHO_FULL_SCREEN,Constantes.ANCHO_FULL_SCREEN));

    //    pp.setOpaque(false);
   
        
        pp.add(sd);
 
     vent.add(pp);

         
           NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"lib");
       
       Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
       
       MediaPlayerFactory mpf= new MediaPlayerFactory();

     
 

        empp =  mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(vent));
              
                    
            
          
                    
                    
           empp.setVideoSurface(mpf.newVideoSurface(sd));
           
           
            empp.setEnableMouseInputHandling(true);

       
       
       empp.setEnableKeyInputHandling(true);
       

            
                 empp.prepareMedia(filee);
        


               empp.setRepeat(true);
 
 
       empp.play();
               
         
             
     
   
            
     }
    
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y, final Point p){
       contDibuj++;
        g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    public static void dibujString(final Graphics g,final String s, final int x, final int y ){
       contDibuj++;
        g.drawString(s, x, y);
    }
    
        
    public static void dibujString(final Graphics g,final String s, final Point p, final Color c ){
      contDibuj++;
          g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
    
            
    public static void dibujString(final Graphics g,final String s, final Point p){
      contDibuj++;
   
        g.drawString(s, p.x, p.y);
    }
    
    
    
    
        public static void dibujString(final Graphics g,final String s, final int x, final int y, final Color c ){
      contDibuj++;
        g.setColor(c);
        g.drawString(s, x, y);
    }
    
            public static void dibujString(final Graphics g,final String s, final int x, final Point p, final Color c ){
    contDibuj++;
        g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
            
            
          public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto){
                    contDibuj++;
                    g.fillRect(x, y,ancho,alto);
                    
                    
                    
          }  
            
            
            
                public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r){
                   
                    
                    contDibuj++;
            
                    g.fillRect(r.x,r.y,r.width,r.height);
                  
                  
                           
          }  
            
            
                
                 public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                    contDibuj++;
                    g.setColor(c);
                    g.fillRect(x, y,ancho,alto);
                    
                    
                    
          }  
                 
                 
                            public static void dibujarRectanguloRelleno2(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                    contDibuj++;
                  //  g.setColor(c);
                 //   g.fillRect(x, y,ancho,alto);
                 
        //   GestorPrincipal.
                    
                    
                    
          }  
            
                 
                 
                 
                 
                
                
              public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
               public static void dibujarRectanguloRelleno2(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
              
              
              public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto){
                   contDibuj++;
                    g.drawRect(x, y,ancho,alto);
          }  
            
            
            
                public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r){
                    contDibuj++;
                    g.drawRect(r.x,r.y,r.width,r.height);
          }  
            
            
                
                 public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(x, y,ancho,alto);
          }  
                
                
              public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(r.x,r.y,r.width,r.height);   
                
              }
             
              
              
              
              
              public static int getContDibuj(){
                  return contDibuj;
              }
              
              
              public static void RestartContDibuj(){
                  contDibuj=0;
              }
              
              
            
    
    
}
