/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author samuel ludueña 2021
 */
public class CreandoMarcos extends JFrame {
    
    
    
    
    
    
    
    
    
    
    public CreandoMarcos(){
        
        
    /*    
    setSize(500,500);
    
    
    
    setVisible(true);
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //pide un parametro entero en donde el programa se tiene que cerrar
    
  //     setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  
  */
  
  
          
              
Toolkit miPantalla= Toolkit.getDefaultToolkit(); //informacion de mi pantalla



Dimension tamPantalla;  //nos proporciona el tamaño de nuestra pantalla
        

 tamPantalla= miPantalla.getScreenSize(); //pasamos la informacion de nuestra pantalla al tamaño de nuestra pantalla de donde sacara las dimensiones ancho y alto
 
 int altoPantalla= tamPantalla.width;   //almacenamos el ancho  y alto pasados a la dimension de nuestra pantalla
 
 int anchoPantalla= tamPantalla.height;
 
     setSize(anchoPantalla,altoPantalla);
    
    
    setLocation(anchoPantalla,altoPantalla);
    
    
    
    Image miIcono= miPantalla.getImage("icono.gif");
    
    
    setIconImage(miIcono);
    
    
    
    
    }
    
    
   class Lamina extends JPanel{
       
       
       public void PaintComponent(Graphics g){
           
           
           super.paintComponent(g); //le pedimos que haga lo que ya hace por defecto tambien aparte de hacer lo que le indicamos abajo
           
           
       //    g.drawString("soy samu", 100, 100);
       
       
       Graphics2D g2= (Graphics2D)g;
       
       
       Rectangle2D recntagulo= new Rectangle2D.Double(100,100,200,150);
           
           
           
       }
       
       
       
       
       
       
       
       
       
   } 
    
    
    
}
