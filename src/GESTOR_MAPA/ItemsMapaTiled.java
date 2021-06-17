/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR_MAPA;

import java.awt.Point;
import ITEMSYARMAS.Items;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsMapaTiled {
    
    private Point posicion;
    private Items item;
    
    public ItemsMapaTiled(Point posicion, Items item){
        this.posicion=posicion;
        this.item=item;
    } 
    
    
    
    public Point getPosicion(){
        return posicion;
    }
    
    
    public Items getItem(){
        return item;
    }
    
    
    
    
    
    
    
    
    
    
}
