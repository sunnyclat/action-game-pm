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
public class Pocion extends Consumibles {

    

    
    
    public Pocion(String nombre, Sprite sprite, int id, String descripcion, int cantidad,int generaVida) {
        super(nombre, sprite, id, descripcion,cantidad,generaVida);
        
        
    
    }

    public Pocion(int id, String nombre, String descripcion, int cantidad, int generaVida) {
        super(id, nombre, descripcion, cantidad,generaVida);
        
    
  
    }

   

}
