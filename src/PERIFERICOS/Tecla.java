/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PERIFERICOS;

/**
 *
 * @author samuel ludueña 2021
 */
public class Tecla {
    private boolean pulsed= false;
    private long lastPulsed= System.nanoTime();  //nanotime es para medir el tiempo de una manera muy precisa


public void teclaPulsed(){
    pulsed=true;
    
    
    lastPulsed= System.nanoTime();
}

public void teclaReleased(){
    pulsed=false;
}


public boolean getIsPulsed(){
return pulsed;    
}

public long getLastPulsed(){
    return lastPulsed;
}


}
