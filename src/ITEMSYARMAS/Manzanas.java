/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import SPRITES.Sprite;

/**
 *
 * @author SAMU
 */
public class Manzanas extends Consumibles{
    
// public static int cantidad=0;
    
    
    
    public Manzanas(String nombre, Sprite sprite, int id, String descripcion, int cantidad,int generaVida) {
        super(nombre, sprite, id, descripcion, cantidad,generaVida);
       
        this.cantidad=cantidad;
        
    
    }
    
    
    
      public Manzanas(int id, String nombre, String descripcion, int cantidad, int generaVida) {
        super(id, nombre, descripcion, cantidad,generaVida);

        
    }
      
      /*
      public static int getCantidadd(){
          
          
          
          return cantidad;
      }
      
      */
      
      
      
      
      
     
}
