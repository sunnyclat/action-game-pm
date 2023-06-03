<<<<<<< HEAD
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
=======
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
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
