/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.awt.Rectangle;
import java.util.ArrayList;
import principal.Constantes;
import Personajes.Personaje;
import SPRITES.Sprite;

/**
 *
 * @author samuel ludueña 2021
 */
public class Pistola extends Armas {


    public Pistola(int id, String nombre, String descripcion, int minimAtaque, int maximAtaque,
            boolean automatica, boolean penetrante, double ataquesPorSegundo, int cantidad) {
      
        
        super(id, nombre, descripcion, minimAtaque, maximAtaque, automatica, penetrante, ataquesPorSegundo,Constantes.DISPARO_PISTOLA_SONIDO,cantidad);
    }


    
    
    
    
    
    
    
    @Override
    public ArrayList<Rectangle> getAlcance(final Personaje persona) {

        
        final ArrayList<Rectangle> alcance = new ArrayList();  //no volvemos a poner rectangle ya que ya fue declarada en la clase abstracta
        
        
        
        final Rectangle alcance_1= new Rectangle();
        
        final int SpritesAlcanc= 12;
        
        
        if(persona.direccion == 0 || persona.direccion == 1){ //mira abajo o arriba (0,1)
            
            alcance_1.width = 1; //alcance de un pixel
            alcance_1.height= SpritesAlcanc * Constantes.LADO_SPRITE; //320 pixeles ya que es 10*32
            alcance_1.x= Constantes.CENTRO_PANTALLA_X;
           
            
            if(persona.direccion == 0){
                alcance_1.y = Constantes.CENTRO_PANTALLA_Y - 9;
            } else{
                alcance_1.y = Constantes.CENTRO_PANTALLA_Y - 9 - alcance_1.height;
                
                
                
            }
            
            
            
            
        } else{                                             //mira forzosamente a 2 o a 3
            
            alcance_1.width= SpritesAlcanc * Constantes.LADO_SPRITE;
            
              alcance_1.height = 1;
              
              
              
              alcance_1.y = Constantes.CENTRO_PANTALLA_Y - 3;
              
              
              
              
              if(persona.direccion == 3){ //si mira a la izquierda
                 
              
              alcance_1.x = Constantes.CENTRO_PANTALLA_X - alcance_1.width;
              
              
              
              
              
              
              
        }else{
                  
                  alcance_1.x = Constantes.CENTRO_PANTALLA_X;
                  
                  
              }
        
        
        
        
        
        
  
    }
    
    
    
        alcance.add(alcance_1);
        
        
        
          return alcance;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


      @Override
    public Sprite getSprite(){

 
     return hojaArma1.getSprite(id - 6 );
      
     
    } 

    @Override
    public void generacionVida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

}
