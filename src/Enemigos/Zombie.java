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
import java.awt.Color;
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
    
    
    
    /*
    
    @Override
        public void dibujarBarraVida(final Graphics g, final int puntoX, final int puntoY){
        
    //    g.setColor(Color.green);
        
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntoX, puntoY - 5, Constantes.LADO_SPRITE * (int) vidaAct / vidaMax, 2);
        
     //   dibujaDistancia(g,puntoX,puntoY);
        
        
    }
    
    
    
    */
       
     
        
    
    @Override
    public void dibujarr(final Graphics g, final int puntoX, final int puntoY){
        

                
    
  
        

            movimientos2();
  
    DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());
    


         imagenActual = hojaZombie.getSprite(direccion,estados).getImagen();
   
        
DibujadorRectangulosImagenes.dibujImagen(g, imagenActual, puntoX, puntoY);


  
            dibujarBarraVida(g,puntoX,puntoY);

 
        
     
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
