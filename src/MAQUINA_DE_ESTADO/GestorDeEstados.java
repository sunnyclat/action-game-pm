/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAQUINA_DE_ESTADO;

import principal.EstadoJuego;
import INVENTARIO.EstadoInventario;
import java.awt.Graphics;
import GRAFICOS.LectorCanvas;
import MenuJuego.EstadoMenu;
import MenuJuego.EstadoMenuPausa;
import SONID.Audio;
import principal.Constantes;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class GestorDeEstados {
    
    private InterfazGestionadorEstados[] estados;  //array
    private InterfazGestionadorEstados estadoActual; //objeto
 
       boolean is2=false;
       boolean is0=false;
  private Audio musica1 = new Audio(Constantes.MUSICA_VENOM);
     private Audio musica2 = new Audio(Constantes.MUSICA_INTRO);
    

     

public GestorDeEstados(final LectorCanvas sd){


   //    musica2.reproduceMusica(); 
    
    
    
    
    inicEstados(sd);
inicEstadoActual();

   
                



}

public GestorDeEstados(){
    
    
    
}



private void inicEstados(final LectorCanvas sd){
   
  
    
    
    estados=new InterfazGestionadorEstados[5];
   
    //implementan la clase interfaz
    estados[0]= new EstadoJuego();    //juego en si
    estados[1]= new EstadoInventario(sd);          //inventario
    estados[2]= new EstadoMenuPausa();
    estados[3]=new EstadoMenu();

     

}


public void inicEstadoActual(){
    estadoActual= estados[3]; //posicion 0 del array dentro del objeto

    
  
        
    /*    
if(estadoActual== estados[3]){
 musica2.reproduceMusica();
}





    
    
    if(estadoActual ==estados[0])
    musica1.reproduceMusica();
    */
    

}


public boolean inicEstadoActual2(){
   
 
    
    
    if(estadoActual== estados[2]){             //posicion 0 del array dentro del objeto

    is2=true;
        }
        
    /*    
if(estadoActual== estados[3]){
 musica2.reproduceMusica();
}





    
    
    if(estadoActual ==estados[0])
    musica1.reproduceMusica();
    */
    
return is2;
}


public boolean inicEstadoActual0(){
   
 
    
    
    if(estadoActual== estados[0]){             //posicion 0 del array dentro del objeto

    is0=true;
        }
        
    /*    
if(estadoActual== estados[3]){
 musica2.reproduceMusica();
}





    
    
    if(estadoActual ==estados[0])
    musica1.reproduceMusica();
    */
    
return is0;
}







public void actualizar(){    //actualiza estado actual
    estadoActual.actualizar();
}
 
public void dibujar(final Graphics g){  //dibuja estado actual
    estadoActual.dibujar(g);
}




public void cambiarEstadoActual(final int nuevoEstado){    //puedo cambiar de un estado a otro
    estadoActual= estados[nuevoEstado];
    

    
    
}



public InterfazGestionadorEstados getEstadoActual(){
    return estadoActual;
}




}