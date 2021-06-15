/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import Enemigos.Enemigos;
import principal.Constantes;
import ITEMSYARMAS.Items;
import Personajes.Personaje;
import SPRITES.HojaSprites;
import SPRITES.Sprite;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public  class Consumibles extends Items {
        private int cant;
        private int genVida;
        
      Personaje persona;
    
        public static HojaSprites hojaConsumibles= new HojaSprites(Constantes.RUTA_CONSUMIBLES,Constantes.LADO_SPRITE, false);

        
        
        
        public Consumibles(String nombre, Sprite sprite, int id, String descripcion, int cantidad) {
        super(nombre, sprite, id, descripcion, cantidad);
        
        
      
    }
        
      
        
        
    public Consumibles(int id, String nombre, String descripcion,int cantidad, int generaVida) {
        super(id, nombre, descripcion,cantidad);
        
        
        this.cant=cantidad;
        this.genVida=generaVida;
        
        
   }
  
        
        
        
        public void generacionVidaPersonaje(Personaje persona){
            
            
            
            
            
      
            
        persona.cargaVidaPersonaje(genVida);
            
            
            
            
            
            
        }
        
        
        
        
        
        

    
    
    @Override
    public Sprite getSprite() {
     return hojaConsumibles.getSprite(id);
    }

 
    
}
