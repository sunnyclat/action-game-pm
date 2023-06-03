/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR_MAPA;

/**
 *
 * @author samuel ludueña 2021
 */
public abstract class CapasTiled {
    
    
    protected double ancho;
    protected double alto;
    protected double x;
    protected double y;
    
    


    public CapasTiled(double ancho, double alto, double x, double y) {
      
        this.ancho = ancho;
        this.alto = alto;
        this.x = x;
        this.y = y;
      
    }
    
    
    
    
    
    
    
}
