/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR_MAPA;

import java.awt.Rectangle;

/**
 *
 * @author samuel ludueña 2021
 */
public class CapasColisiones extends CapasTiled{
    
    private Rectangle[] colisiones;
    
    
    
    public CapasColisiones(double ancho, double alto, double x, double y, Rectangle[] colis) {
        super(ancho, alto, x, y);
        this.colisiones=colis;
    }
    
    
    
    public Rectangle[] getColisiones(){
        return colisiones;
    }
    
}
