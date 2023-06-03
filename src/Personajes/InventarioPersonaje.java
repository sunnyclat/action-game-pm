/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import ITEMSYARMAS.Consumibles;
import ITEMSYARMAS.Items;
import ITEMSYARMAS.Pocion;


/**
 *
 * @author samuel ludueña 2021
 */
public class InventarioPersonaje {
    

    
    
    private Consumibles manzana;
    private Consumibles pocion;
    
  private Items item;
    
    
    
    
    
    
    
    
    
    public InventarioPersonaje(Consumibles manzana, Consumibles pocion){
        
        
        
        this.manzana=manzana;
        
        
this.pocion=pocion;
        
        
        
        
    }
    
    
    
    
    public InventarioPersonaje(){
        
        

        
        
        
        
    }
    
    
    
    
    
          public Consumibles getPocion(){
        
        
        
        
        
        
       return pocion;
        
    }
    
 
    
        public Consumibles getManzana(){
        
        
        
        
        
        
       return manzana;
        
    }
    
        
    
    
    
    
 
    
}
