/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Enemigos.Enemigos;
import java.awt.Graphics;
import principal.Constantes;
import SPRITES.HojaSprites;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import java.awt.Point;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Zombie extends Enemigos {
    
    

    
 
    
    
    
    public Zombie(int idEnemigo, String nombre, int vidaMax, final String quejaRuta, final String muerteRuta, int ataqueMin, int ataqueMax, double ataquexSegundo,String rutaSonidoAtaque) {
        super(idEnemigo, nombre, vidaMax, quejaRuta, muerteRuta,ataqueMin,ataqueMax,ataquexSegundo,rutaSonidoAtaque);
        
   
        
        if( hojaZombie == null){ //si no hay un zombie
           
   //       hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );
   

   
   hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );

   
        }
        
        
     
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
       
     
        
    
    @Override
    public void dibujarr(final Graphics g, final int puntoX, final int puntoY){
        

                
   
        
    //    DibujadorRectangulosImagenes.dibujImagen(g, hojaZombie.getSprite(0).getImagen(),puntoX ,puntoY);  //punto x e y marcan el lugar de la hoja en donde esta la imagen
        
    
    DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());
    
    movimientos2();

         imagenActual = hojaZombie.getSprite(direccion,estados).getImagen();
        
DibujadorRectangulosImagenes.dibujImagen(g, imagenActual, puntoX, puntoY);
  

 

  
  
// dibujarr(g,puntoX, puntoY);
        
 
        
     
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
