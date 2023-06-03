/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import HERRAMIENTAS.DibujadorRectangulosImagenes;
import SPRITES.HojaSprites;
import java.awt.Graphics;
import principal.Constantes;

/**
 *
 * @author SAMU
 */
public class Jefes  extends Enemigos {
    
    public Jefes(int idEnemigo, String nombre, int vidaMax, String quejaRuta, String muerteRuta, int ataqueMin, int ataqueMax, double ataquexSegundo, String rutaSonidoAtaque) {
        super(idEnemigo, nombre, vidaMax, quejaRuta, muerteRuta, ataqueMin, ataqueMax, ataquexSegundo, rutaSonidoAtaque);
        
        
                if( hojaJefe1 == null){ 
        
    hojaJefe1 = new HojaSprites (Constantes.RUTA_JEFES + idEnemigo + ".png", Constantes.LADO_SPRITE, false );
        
        
        
        
                }
        
        
    }
    
    
    
        
    @Override
    public void dibujarr(final Graphics g, final int puntoX, final int puntoY){
    
        
        
        
        
        
        
        
    DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());
    
    
    
             
      movimientos2();
      
      
      
      
       imagenActual2 = hojaJefe1.getSprite(direccion,estados).getImagen();
       
       
        DibujadorRectangulosImagenes.dibujImagen(g, imagenActual2, puntoX, puntoY);
        
        
         dibujarBarraVida(g,puntoX,puntoY);
    
    
}





}