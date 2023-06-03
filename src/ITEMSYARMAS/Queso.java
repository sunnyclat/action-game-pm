<<<<<<< HEAD
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
public class Queso extends Consumibles {

    public Queso(String nombre, Sprite sprite, int id, String descripcion, int cantidad, int generaVida) {
        super(nombre, sprite, id, descripcion, cantidad,generaVida);
    }

  
  public Queso(int id, String nombre, String descripcion, int cantidad, int generaVida) {
        super(id, nombre, descripcion, cantidad,generaVida);
    }


    

    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import SPRITES.Sprite;

/**
 *
 * @author samuel ludueña 2021
 */
public class Queso extends Consumibles{
    
    public Queso(String nombre, Sprite sprite, int id, String descripcion, int cantidad) {
        super(nombre, sprite, id, descripcion, cantidad);
    }
    

        public Queso(int id, String nombre, String descripcion, int cantidad, int generaVida) {
        super(id, nombre, descripcion, cantidad,generaVida);
    }
 
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
