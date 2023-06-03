/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SONID;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import HERRAMIENTAS.CargadorRecursos;
import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class Audio {
    
    
    final private Clip sonido;
    

    
   final private FloatControl volumen;
    
    
    
    
    
    
    public Audio (final String rutaSonido){


                
       
          sonido = CargadorRecursos.cargarSonido(rutaSonido);

        

       
        volumen= (FloatControl) sonido.getControl(FloatControl.Type.MASTER_GAIN);
        
        

   
        
                        

        


  
    
    
    }
    
    

    
    
    public void reproduceSonido(){  
                    

        sonido.stop();
        sonido.flush();
        

        sonido.setMicrosecondPosition(0); //seteamos el sonido al principio
 

 
      volumen.setValue(-18.0f);
   
   sonido.start();
    
    }
    
                              
    public void reproduceMusica(){  
     
 
       
           
           
           sonido.stop();
          
        sonido.flush();
        sonido.setMicrosecondPosition(0); 
        sonido.loop(Clip.LOOP_CONTINUOUSLY);
    

             volumen.setValue(-24.0f);

     //    volumen.setValue(-80.0f);
    }
    
      
      public void reproduceMusica2(){  
     
 
       sonido.stop();
           
            //     volumen.setValue(-80f);
         /* 
        sonido.flush();
        sonido.setMicrosecondPosition(0); 
        sonido.loop(Clip.LOOP_CONTINUOUSLY);
    

             volumen.setValue(-24.0f);
*/
     //    volumen.setValue(-80.0f);
    }
     
    
    
    
    
    
    
    
    
    
    
    public Long obtieneDuracion(){
        
        return sonido.getMicrosecondLength();
        
    }
    
    
    
}
