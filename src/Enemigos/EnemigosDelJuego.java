/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class EnemigosDelJuego {
    
    public static Enemigos obtenEnemigos( final int idEnemigo){
  
        Enemigos enemig= null;
     
        
        switch(idEnemigo){
            
            case 1:
           //     enemig= new Zombie(idEnemigo,"ZOMBIE", 10, Constantes.SONIDO_QUEJA_ZOMBIE, Constantes.SONIDO_MUERTE_ZOMBIE);
             
                enemig= new Zombie(idEnemigo,"ZOMBIE", 40, Constantes.SONIDO_QUEJA_ZOMBIE, Constantes.SONIDO_MUERTE_ZOMBIE,1,10,0.4,Constantes.SONIDO_ATAQUE_ZOMBIE);
                
                break;
            
            case 2:
                
              enemig= new Jefes(idEnemigo,"BOSS", 5000, Constantes.SONIDO_QUEJA_ZOMBIE, Constantes.SONIDO_MUERTE_ZOMBIE,100,2000,0.10,Constantes.SONIDO_ATAQUE_ZOMBIE);         
              break;
                 /*              
            case 3:
                
                enemig= new Jefes(idEnemigo,"BOSS", 100, Constantes.SONIDO_QUEJA_ZOMBIE, Constantes.SONIDO_MUERTE_ZOMBIE,99,100,0.10,Constantes.SONIDO_ATAQUE_ZOMBIE);
                               break;
                               
                         */      
                               
                               
                               
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
          return enemig;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
