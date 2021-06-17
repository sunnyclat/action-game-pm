/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import ITEMSYARMAS.Consumibles;
import ITEMSYARMAS.Items;
import ITEMSYARMAS.Manzana;

/**
 *
 * @author samuel ludueña 2021
 */
public class InventarioPersonaje {
    
    private Items manzana;
    private Items item;
    
    
    private Consumibles consum;
    
    
    
    
    
    
    public InventarioPersonaje(Consumibles consum){
        
        
        
        this.consum=consum;
        
        
        
        
    }
    
    
    
    
    public InventarioPersonaje(){
        
        

        
        
        
        
    }
    
    
        public Consumibles getConsum(){
        
        
        
        
        
        
       return consum;
        
    }
    
    
    
    public Items getManzana(){
        
        
        
        
        
        
       return manzana;
        
    }
    
    
    
    
    
      public void setManzana(Manzana manzana){
        
        
        
        
        
      this.manzana=manzana;
        
    }
    
    
}
