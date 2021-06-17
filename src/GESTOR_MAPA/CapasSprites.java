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
public class CapasSprites extends CapasTiled {
    
    private int [] sprites;
    
    
    public CapasSprites(double ancho, double alto, double x, double y, int[] sprites) {
        super(ancho, alto, x, y);
        this.sprites=sprites;
    }

    public int[] getSprites() {
        return  sprites;
    }
    
    
    
    
    
    
    
    
    
}
