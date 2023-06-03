<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class Nodo {
    
    private Point posicion;
    private double distancia;
    
    public Nodo(final Point posicion, final double distancia){
    
    
    this.posicion=posicion;
    this.distancia=distancia;
    
    
    
    
}
    
    public Rectangle obtieneAreaPixeles(){
        
        return new Rectangle (posicion.x * Constantes.LADO_SPRITE, posicion.y * Constantes.LADO_SPRITE,
                Constantes.LADO_SPRITE,Constantes.LADO_SPRITE  );
        
        
        
        
    }
    
    
    public Rectangle getArea(){
        return new Rectangle(posicion.x, posicion.y, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
    }
    
    
    
    
    public Point getPosicion(){
        return posicion;
    }
    
      
    public double getDistancia(){
        return distancia;
    }
    
    public void setDistancia(double distancia){
        this.distancia=distancia;
    }
    
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class Nodo {
    
    private Point posicion;
    private double distancia;
    
    public Nodo(final Point posicion, final double distancia){
    
    
    this.posicion=posicion;
    this.distancia=distancia;
    
    
    
    
}
    
    public Rectangle obtieneAreaPixeles(){
        
        return new Rectangle (posicion.x * Constantes.LADO_SPRITE, posicion.y * Constantes.LADO_SPRITE,
                Constantes.LADO_SPRITE,Constantes.LADO_SPRITE  );
        
        
        
        
    }
    
    
    public Rectangle getArea(){
        return new Rectangle(posicion.x, posicion.y, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
    }
    
    
    
    
    public Point getPosicion(){
        return posicion;
    }
    
      
    public double getDistancia(){
        return distancia;
    }
    
    public void setDistancia(double distancia){
        this.distancia=distancia;
    }
    
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
