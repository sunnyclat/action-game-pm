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
public class Manzana extends Consumibles{
    
    public Manzana(String nombre, Sprite sprite, int id, String descripcion, int cantidad) {
        super(nombre, sprite, id, descripcion, cantidad);
    }
    
    public Manzana(int id, String nombre, String descripcion, int cantidad, int generaVida) {
        super(id, nombre, descripcion, cantidad, generaVida);
    }
    
}
