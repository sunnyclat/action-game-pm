/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import principal.Constantes;
import Enemigos.Enemigos;
import Personajes.Personaje;
import ITEMSYARMAS.ItemsYArmasDelJuego;
import ITEMSYARMAS.Items;
import SPRITES.HojaSprites;
import SPRITES.Sprite;
import SONID.Audio;

/**
 *
 * @author samuel ludueña 2021
 */
public abstract class  Armas extends Items {
    
    public Audio sonidoArma;

    public static HojaSprites hojaArma1= new HojaSprites(Constantes.RUTA_ARMA_PISTOLA,Constantes.LADO_SPRITE, false);
        public static HojaSprites hojaArma2= new HojaSprites(Constantes.RUTA_ARMA_ESPADA,Constantes.LADO_SPRITE, false);

         
    
    protected int minAtaque;
    protected int maxAtaque;
 
    protected boolean automatica;  //dispara sola o no
    protected boolean penetrante;  //nos indica si la bala alcanzaria al enemigo de detras tambien
    protected double ataquesPorSegundo; //veces que se dispare por segundo
    protected int actualizSigAtaque;  //cuantas actualizaciones hasta el proximo disparo
    
    
    
    public Armas(int id, String nombre, String descripcion, int minimAtaque, int maximAtaque,
    final boolean automatica, final boolean penetrante, final double ataquesPorSeg,
    final String rutaSonidoArma, final int cantidad) {
        super(id, nombre, descripcion,cantidad);
        
        
        this.minAtaque=minimAtaque;
        this.maxAtaque=maximAtaque;
        this.automatica=automatica;
        this.penetrante=penetrante;
        this.ataquesPorSegundo=ataquesPorSeg;
        this.actualizSigAtaque=0;
       
        this.sonidoArma= new Audio (rutaSonidoArma);
        
        
        
        
        
    }


    
    
    /*
        public Armas(String nombre, Sprite sprite, int id, String descripcion, int cantidad,int minimAtaque, int maximAtaque) {
        super(nombre, sprite, id, descripcion, cantidad);
        
        
        
                this.minAtaque=minimAtaque;
        this.maxAtaque=maximAtaque;
    }
*/
 
        
        
        public abstract ArrayList<Rectangle> getAlcance(final Personaje persona);
        
        
        
        public void actualizar(){
            
            
            if (actualizSigAtaque  >0){
                
                
                actualizSigAtaque--; //le restamos uno para estar listos la sigiente vez
                
                
            }
        }
        
        
    
        public void atacarr(final ArrayList <Enemigos> enemigos ){
            
           if(actualizSigAtaque  > 0 ) { //el arma no esta preparada para atacar otra vez
               
               return;
               
               
               
               
           }
            
           
           actualizSigAtaque = (int)(ataquesPorSegundo * 60);
           
           
           //reproducir sonido disparo
           
           sonidoArma.reproduceSonido();
           
           
           
           
           
           
           
           
           //hacemos el ataque
           if(enemigos.isEmpty()){  //verificamos que el arraylist de enemigos esta vacio
               
               
               return;
           }
           
           float ataqueActual = obtieneAtaqueMedioo();
           
           
           for(Enemigos enemigo : enemigos){
               
               enemigo.perdidaVidaDelEnemigoo(ataqueActual);
               
                  System.out.println("ataque al ENEMIGO");
               
               
           }
           
           
        
           
           
           
           
           
           
           
           
           
           
           
           
           
            
            
        }
        
        
        
        
        
        
        public void atacarJef(final ArrayList <Enemigos> jefes ){
            
            
            
            
           if(actualizSigAtaque  > 0 ) { //el arma no esta preparada para atacar otra vez
               
               return;
               
               
               
               
           }
            
           
           actualizSigAtaque = (int)(ataquesPorSegundo * 60);
           
           
           //reproducir sonido disparo
           
           sonidoArma.reproduceSonido();
           
           
           
           
           
           
           
           
           //hacemos el ataque
           if(jefes.isEmpty()){  //verificamos que el arraylist de enemigos esta vacio
               
               
               return;
           }
           
           
             
           
           
           float ataqueActual = obtieneAtaqueMedioo();
           
           
           
           
           
           
           
           for(Enemigos jefe : jefes){
               
               
                System.out.println("ataque al JEFE");
               jefe.perdidaVidaDelEnemigoo(ataqueActual);
               
            
               
           }
           
           
        
           
           
           
           
           
           
           
           
           
           
           
           
           
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public boolean esAutomatica(){
            return automatica;
        }
        
           public boolean esPenetrantee(){
            return penetrante;
        }
        
    /*
    @Override
    public Sprite getSprite(){

 
     return hojaArma1.getSprite(id - 6 );
      
     
    }
    */
      
           
        /*   
    @Override
    public Sprite getSprite2(){

 
     
      return hojaArma2.getSprite(id - 5 );
     
     
    }
   */

    
    protected int obtieneAtaqueMedioo(){
     
        
        Random random= new Random();
        
        
        return random.nextInt(maxAtaque - minAtaque) + minAtaque;
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
