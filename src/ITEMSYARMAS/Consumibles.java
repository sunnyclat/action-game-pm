<<<<<<< HEAD
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
import java.util.ArrayList;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Consumibles extends Items {
   

        private int genVida;
        
        private int id;
   
  public static int cantidad;
   
    
    
    
     private final String nombre;
    private final String descrip;
    
        public static HojaSprites hojaConsumibles= new HojaSprites(Constantes.RUTA_CONSUMIBLES,Constantes.LADO_SPRITE, false);

        
        
        
        public Consumibles(String nombre, Sprite sprite, int id, String descripcion, int cantidad,int generaVida) {
        super(nombre, sprite, id, descripcion, cantidad);
 
     
  
        
        
  
        this.cantidad=cantidad;
             this.nombre = nombre;
            this.descrip = descripcion;

    
            
    }
        
        
        
      
    
        
      
        
        
    public Consumibles(int id, String nombre, String descripcion,int cantidad,int generaVida) {
        super(id, nombre, descripcion,cantidad);
        
        
        this.id = id;
        this.nombre = nombre;
        this.descrip = descripcion;

 this.cantidad=cantidad;
       this.genVida=generaVida;
        

     
        
        
        
        
   }
  
   
    
    
     
        

        public int getIdConsum(){
            
            
            return id;
        }
        
        
        public int getGenVida(){
            
            return genVida;
            
        }
        
        
public static int getCantidad(){
    
    return cantidad;
}
        
        
            
        public void setGenVida(int genVida){
            
         this.genVida=genVida;
            
        }
        
        

    
    
    @Override
    public Sprite getSprite() {
     return hojaConsumibles.getSprite(id);
    }

 
    
 

 
    
}
=======
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
        
      
        
        
    public Consumibles(int id, String nombre, String descripcion,int cantidad,final int generaVida) {
        super(id, nombre, descripcion,cantidad);
        
        
        this.cant=cantidad;
        this.genVida=generaVida;
        
        

        
        
   }
  
        
        
      public void generaVida(){
          
          
      
          int Vida=genVida;
                  
                  persona.cargaVidaPersonaje(Vida);
          
              System.out.println("gene");
      }
        
        
        
        public int getGenVida(){
            
            return genVida;
            
        }
        
        
            
        public void setGenVida(int genVida){
            
         this.genVida=genVida;
            
        }
        
        

    
    
    @Override
    public Sprite getSprite() {
     return hojaConsumibles.getSprite(id);
    }

    @Override
    public void generacionVida() {
        generaVida();
    }



 
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
