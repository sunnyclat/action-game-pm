/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PERIFERICOS;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.Clip;
import HERRAMIENTAS.CargadorRecursos;
import ITEMSYARMAS.Armas;
import ITEMSYARMAS.SinArmas;
import principal.Constantes;
import principal.ObjetosEstaticos;
import principal.guardaYCargaPartida;

/**
 *
 * @author samuel ludueña 2021
 */
public class Teclado implements KeyListener {

    public Tecla arriba = new Tecla();
    public Tecla abajo = new Tecla();
    public Tecla izquierda = new Tecla();
    public Tecla derecha = new Tecla();
    
    
    public boolean play= false;
     public Tecla opciones= new Tecla();

    public boolean agarrando = false;
    public boolean correr = false;
    public boolean debug = false;  //boolean que muestre o no la informacion debug
    public boolean inventario = false;
    public boolean teclaMenuPausa=false;
    public boolean ataque = false;

    @Override
    public void keyPressed(KeyEvent ke) {

        switch (ke.getKeyCode()) {

            case KeyEvent.VK_W:
                arriba.teclaPulsed();
                break;

            case KeyEvent.VK_S:
                abajo.teclaPulsed();
                break;

            case KeyEvent.VK_A:
                izquierda.teclaPulsed();
                break;

            case KeyEvent.VK_D:
                derecha.teclaPulsed();
                break;

            case KeyEvent.VK_SHIFT:
                correr = true;
                break;

            case KeyEvent.VK_F2:
                debug = !debug; //si es true, hazlo false y si es false hazlo true

                break;

            case KeyEvent.VK_I:

                inventario = !inventario;
                break;

            case KeyEvent.VK_E:
                agarrando = true;

                break;

            case KeyEvent.VK_CONTROL:
                
                
      

                ataque = true;
        
            
                break;

            case KeyEvent.VK_ESCAPE:
                System.exit(0); //ponemos 0 porque es el que funciona

                break;
                    case KeyEvent.VK_F5:
                        
                guardaYCargaPartida.save();
                break;
                
                  case KeyEvent.VK_F9:
                      
                        guardaYCargaPartida.load();
                break;
                 case KeyEvent.VK_P:
             //    teclaMenuPausa =! teclaMenuPausa;
                      teclaMenuPausa =true;
                 break;
                 
                 case KeyEvent.VK_J:
                      play =true;
                break;
                  case KeyEvent.VK_O:
                       opciones.teclaPulsed();
                break;
                
                
        }

    






}

    @Override
    public void keyReleased(KeyEvent ke) {

        switch (ke.getKeyCode()) {

            case KeyEvent.VK_W:
                arriba.teclaReleased();
                break;

            case KeyEvent.VK_S:
                abajo.teclaReleased();
                break;

            case KeyEvent.VK_A:
                izquierda.teclaReleased();
                break;

            case KeyEvent.VK_D:
                derecha.teclaReleased();
                break;
            case KeyEvent.VK_E:
                agarrando = false;
                break;
            case KeyEvent.VK_SHIFT:
                correr = false;
                break;

            case KeyEvent.VK_CONTROL:

                ataque = false;
                break;
        }

    }
    
    
    public boolean getTeclaMenu(){
       
        
        return teclaMenuPausa=true;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

}
