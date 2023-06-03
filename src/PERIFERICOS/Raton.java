/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PERIFERICOS;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import principal.Constantes;
import GRAFICOS.LectorCanvas;
import principal.Constantes;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.InformacionDebug;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public class Raton extends MouseAdapter {
    
    
    
    private final Cursor cursor;
    private Point posicion; //nos guarda un punto x e y
    
    private boolean click;
        private boolean click2;
    
    public Raton (final LectorCanvas sd){
        Toolkit config= Toolkit.getDefaultToolkit();

    
     BufferedImage icono= CargadorRecursos.cargarImageCompatibleTranslucida(Constantes.RUTA_CURSOR);
        
     Constantes.LADO_CURSOR=icono.getWidth();
     
     
        Point punto= new Point(0,0);
        
        
        this.cursor=config.createCustomCursor( icono,punto, "cursor1");
        
        posicion=new Point();
        ActualizaPosic(sd);
        
        
        click=false;
        click2=false;
    }

private void ActualizaPosic(final LectorCanvas sd){
    final Point posicInicial= MouseInfo.getPointerInfo().getLocation(); //nos da la informacion de la posicion de nuestro mouse


    SwingUtilities.convertPointFromScreen(posicInicial,sd );
    
    
    
    
posicion.setLocation(posicInicial.getX(),posicInicial.getY()); //le pasamos la posicion de nuestro mouse al objeto


}
    
public void actualizar(final LectorCanvas sd){
    ActualizaPosic(sd);
    

    
}

public void dibujar(Graphics g){
 //   g.setColor(Color.PINK);
    
 //   g.drawString("MOUSE X: "+ posicion.getX(),10,200);
 //       g.drawString("MOUSE Y: "+ posicion.getY(),10,210);
        
  //      DibujoDebug.dibujString(g,"RX: " + posicion.getX(),10, 200);
   //          DibujoDebug.dibujString(g,"RY: "+ posicion.getY(),10, 210);
        
        
           InformacionDebug.enviaDatos("RX: " + posicion.getX());
     InformacionDebug.enviaDatos("RY: " + posicion.getY()); 
        
        
        
        
}



public Point getPosicion(){
    return posicion;
}

public Rectangle obtieneRectanguloPosicion(){
    
    final Rectangle area= new Rectangle(posicion.x,posicion.y,1,1);
    
    
    
    return area;
    
}
/*
public void mouseClicked(MouseEvent e){
  
    if(!click){
            click=true;
    }

}
*/

    @Override
    public void mousePressed(MouseEvent e){
    
        if(SwingUtilities.isLeftMouseButton(e)){
            
            click=true;
            
            
        }else if(SwingUtilities.isRightMouseButton(e)){
            click2=true;
        }
        
        
        
        
        
        
}



    @Override
    public void mouseReleased(MouseEvent e){
         if(SwingUtilities.isLeftMouseButton(e)){
            
            click=false;
            
            
        }else if(SwingUtilities.isRightMouseButton(e)){
            click2=false;
        }
        
}




public boolean getClick2(){
    return click2;
}




public void reiniciarClick(){
    if(click){
        
        click=false;
    }
}


public boolean getClick(){
    return click;
}


public boolean getClickk(){

    

    return click=true;
}
    



    public Cursor getCursor(){
        return this.cursor;
    }
    
    
    
    
    
}
