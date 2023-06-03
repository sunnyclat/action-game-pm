<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import principal.Constantes;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsDelPiso {
    
    private static final BufferedImage sprite = CargadorRecursos.cargarImageCompatibleTranslucida(Constantes.RUTA_ITEMS_SUELO);
    
    
    private Point posic;
    private static Items[] items;
    
    
    
    public ItemsDelPiso(final Point posicion, final int [] itemss, final int [] cantidades){
        
        this.posic=posicion;
        this.items=new Items[itemss.length];
        
        
        
        for(int i=0;i<itemss.length;i++){
            this.items[i]=ItemsYArmasDelJuego.obtenItem(itemss[i]);
            this.items[i].incremCant(cantidades[i]);
            
        }
        
        
        
        
        
        
    }
    
    
    public ItemsDelPiso(){
        
        
    }
    
    
    
    
    
    
    public void dibujar( final Graphics g,  final int puntX, final int puntY ){
        
        
        DibujadorRectangulosImagenes.dibujImagen(g, sprite, puntX, puntY);
        
        
        
        
    }
    
    
    public Point getPosic(){
        return posic;
    }
    
    
    
    
    public static Items[] getItems(){
        return items;
    }
    
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import principal.Constantes;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsDelPiso {
    
    private static final BufferedImage sprite = CargadorRecursos.cargarImageCompatibleTranslucida(Constantes.RUTA_ITEMS_SUELO);
    
    
    private Point posic;
    private Items[] items;
    
    
    
    public ItemsDelPiso(final Point posicion, final int [] itemss, final int [] cantidades){
        
        this.posic=posicion;
        this.items=new Items[itemss.length];
        
        
        
        for(int i=0;i<itemss.length;i++){
            this.items[i]=ItemsYArmasDelJuego.obtenItem(itemss[i]);
            this.items[i].incremCant(cantidades[i]);
            
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
    public void dibujar( final Graphics g,  final int puntX, final int puntY ){
        
        
        DibujadorRectangulosImagenes.dibujImagen(g, sprite, puntX, puntY);
        
        
        
        
    }
    
    
    public Point getPosic(){
        return posic;
    }
    
    
    
    
    public Items[] getItems(){
        return items;
    }
    
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
