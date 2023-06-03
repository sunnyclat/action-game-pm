/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author samuel ludueña 2021
 */
public class guardaYCargaPartida {
   
    
   public static String ruta=Constantes.RUTA_ARCHIVO_GUARDADO;
    
   File directory= new File(ruta);
   
  public static File actualFile= new File(ruta,"saveFile.txt");
   
   public static int  vidaJugador;
   public static int posicionX;
   public static int posicionY;
    
    public static void load(){
      
        System.out.println("cargando");
                  
                  
            
                  
                  
        try{
            
            
            
                 BufferedReader br = new BufferedReader(new FileReader(actualFile) ); 

           
           if(br != null){
     
             posicionX= Integer.parseInt(br.readLine());
           posicionY= Integer.parseInt(br.readLine());
        
        vidaJugador= Integer.parseInt(br.readLine());
               System.out.println("cargo vida");
             
             }
  
           
           br.close();
        }
        catch(Exception e){
                 e.printStackTrace();
        }
        
       
    ObjetosEstaticos.persona.setVidaMax(vidaJugador);
     ObjetosEstaticos.persona.setIntPosicX(posicionX);
          ObjetosEstaticos.persona.setIntPosicY(posicionY);
        
    }
    
    
    public static void save(){
        
        
             System.out.println("guardando");
   
             
             try{
            
           BufferedWriter bw = new BufferedWriter(new FileWriter(actualFile)); 
            
        posicionX=  ObjetosEstaticos.persona.obtenIntPosicX();
        posicionY= ObjetosEstaticos.persona.obtenIntPosicY();
           vidaJugador=ObjetosEstaticos.persona.getVidaMax();
           


        
bw.write(""+posicionX);
bw.newLine();
bw.write(""+posicionY);
bw.newLine();
bw.write(""+vidaJugador);



           
           bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
    }
    
 
    
}
