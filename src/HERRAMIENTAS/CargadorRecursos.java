/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import com.sun.scenario.Settings;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.gc;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author samuel ludueña 2021
 */
public class CargadorRecursos {
    
    
    public static BufferedImage cargarImageCompatibleOpaca(final String ruta){
        
        Image imagen= null;
        
        try {
            imagen= ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException e) {
           e.printStackTrace();
        }

       GraphicsConfiguration gcon=  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
       
       
       BufferedImage imagenAceler= gcon.createCompatibleImage(imagen.getWidth(null),imagen.getHeight(null),Transparency.OPAQUE);
       
       
       Graphics g= imagenAceler.getGraphics();
       g.drawImage(imagen, 0, 0, null);
       
       g.dispose();
       
       return imagenAceler;
       
    }
    
    
      public static BufferedImage cargarImageCompatibleTranslucida(final String ruta){
    
    
        Image imagen= null;
        
        try {
            imagen= ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException e) {
           e.printStackTrace();
        }

       GraphicsConfiguration gcon=  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
       
       
       BufferedImage imagenAceler= gcon.createCompatibleImage(imagen.getWidth(null),imagen.getHeight(null),Transparency.TRANSLUCENT);
       
       
       Graphics g= imagenAceler.getGraphics();
       g.drawImage(imagen, 0, 0, null);
       
       g.dispose();
       
       return imagenAceler;
    
    
    
    
    
    
    
    
    
    
}

      
      
      
      public static String leerTexto(final String ruta){
     
          String contenido=""; //es importante estar iniciado con algo adentro para que luego pueda sumarse con linea en el try
        
        
        InputStream entradaBytes=ClassLoader.class.getResourceAsStream(ruta);
          
        BufferedReader lector= new BufferedReader(new InputStreamReader(entradaBytes));
          
        String linea;
        
        try{
            
            while( (linea=lector.readLine() ) !=null)
            contenido +=linea;
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(entradaBytes != null){
                    entradaBytes.close();
                }
                if(lector != null){
                    lector.close();
                }
                
                
                
                
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
        
        
        
        
        
          return contenido;
      }
      
      

public static Font cargarFuentes(final String ruta){
  
    Font fuente= null;
    
    
    InputStream entrBytes= ClassLoader.class.getResourceAsStream(ruta);
    
    

        try {
            fuente= Font.createFont(Font.TRUETYPE_FONT,entrBytes);
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    
    
    fuente= fuente.deriveFont(10f);
    
    return fuente;
}
      
      
      
   public static Clip cargarSonido(final String ruta){
       
       
       Clip clip = null;
       
       
       try{
           
          InputStream is = ClassLoader.class.getResourceAsStream(ruta);
          AudioInputStream ais= AudioSystem.getAudioInputStream(new BufferedInputStream(is));
           
           DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat()); // interpreta el formato y se lo pasa al clip.class
           
           clip = (Clip) AudioSystem.getLine(info);  //guarda la informacion del audio info que tomamos anteriormente
           
           clip.open(ais);    //carga el audio en la memoria
           
     
           
           
           
              
          

 
           
           
           
      

             

   

         

           
           
           
           
       }catch(Exception e){
           
           e.printStackTrace(); //para reconocer que tipo de error es al haber uno
       }
       
       

       
       
       
       
       return clip;
       
   }  
  
      
      
      


}