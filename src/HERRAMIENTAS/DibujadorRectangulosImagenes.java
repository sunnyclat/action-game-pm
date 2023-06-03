<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author samuel ludueña 2021
 */
public class DibujadorRectangulosImagenes {
    
    //final constante, siendo objeto pide instanciarse en el constructor y no se puede heredar. una variable acumuladora o contadora no puede ponerse en final
//no se puede sobrecargar a un metodo 
    
//static  convierte en globales las variables de una clase.
    //si un metodo es static, 1-tienen que ser variables static su contenido
    // 2-los metodos al ser static, pueden llamarse de la clase desde cualquier otra clase, 
 //      sin tener que crearse un objeto y antes importar la clase, o pasarse por parametro el objeto de la clase para usarse 
//3-los metodos al ser static no se pueden llamar desde el objeto de esa clase, solo desde la clase.
   
    

//si una variable es final y estatica no se les puede asignar un valor
    
    
    
    
    private  static int contDibuj=0;            
    

    
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y){
    
        contDibuj++;
        g.drawImage(img,x,y,null);
        
        
        
    }
    
    
     public  static void dibujImagen(final Graphics g, final BufferedImage img, final Point p){
       contDibuj++;
          g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    
    
    
    
    
    
    
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y, final Point p){
       contDibuj++;
        g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    public static void dibujString(final Graphics g,final String s, final int x, final int y ){
       contDibuj++;
        g.drawString(s, x, y);
    }
    
        
    public static void dibujString(final Graphics g,final String s, final Point p, final Color c ){
      contDibuj++;
          g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
    
            
    public static void dibujString(final Graphics g,final String s, final Point p){
      contDibuj++;
   
        g.drawString(s, p.x, p.y);
    }
    
    
    
    
        public static void dibujString(final Graphics g,final String s, final int x, final int y, final Color c ){
      contDibuj++;
        g.setColor(c);
        g.drawString(s, x, y);
    }
    
            public static void dibujString(final Graphics g,final String s, final int x, final Point p, final Color c ){
    contDibuj++;
        g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
            
            
          public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto){
                    contDibuj++;
                //    g.fillRect(x, y,ancho,alto);
                    
                    
                    
          }  
            
            
            
                public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r){
                   
                    
                    contDibuj++;
            
                    g.fillRect(r.x,r.y,r.width,r.height);
                  
                  
                           
          }  
            
            
                
                 public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                    contDibuj++;
                    g.setColor(c);
                    g.fillRect(x, y,ancho,alto);
          }  
                
                
              public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
               public static void dibujarRectanguloRelleno2(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
              
              
              public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto){
                   contDibuj++;
                    g.drawRect(x, y,ancho,alto);
          }  
            
            
            
                public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r){
                    contDibuj++;
                    g.drawRect(r.x,r.y,r.width,r.height);
          }  
            
            
                
                 public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(x, y,ancho,alto);
          }  
                
                
              public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(r.x,r.y,r.width,r.height);   
                
              }
             
              
              
              
              
              public static int getContDibuj(){
                  return contDibuj;
              }
              
              
              public static void RestartContDibuj(){
                  contDibuj=0;
              }
              
              
            
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


/**
 *
 * @author samuel ludueña 2021
 */
public class DibujadorRectangulosImagenes {
    
    //final constante, siendo objeto pide instanciarse en el constructor y no se puede heredar. una variable acumuladora o contadora no puede ponerse en final
//no se puede sobrecargar a un metodo 
    
//static  convierte en globales las variables de una clase.
    //si un metodo es static, 1-tienen que ser variables static su contenido
    // 2-los metodos al ser static, pueden llamarse de la clase desde cualquier otra clase, 
 //      sin tener que crearse un objeto y antes importar la clase, o pasarse por parametro el objeto de la clase para usarse 
//3-los metodos al ser static no se pueden llamar desde el objeto de esa clase, solo desde la clase.
   
    

//si una variable es final y estatica no se les puede asignar un valor
    
    
    
    
    private  static int contDibuj=0;            
    

    
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y){
    
        contDibuj++;
        g.drawImage(img,x,y,null);
        
        
        
    }
    
    
     public  static void dibujImagen(final Graphics g, final BufferedImage img, final Point p){
       contDibuj++;
          g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    
    
    
    
    
    
    
    
    public  static void dibujImagen(final Graphics g, final BufferedImage img, final int x, final int y, final Point p){
       contDibuj++;
        g.drawImage(img,p.x,p.y,null);
        
        
        
    }
    
    public static void dibujString(final Graphics g,final String s, final int x, final int y ){
       contDibuj++;
        g.drawString(s, x, y);
    }
    
        
    public static void dibujString(final Graphics g,final String s, final Point p, final Color c ){
      contDibuj++;
          g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
    
            
    public static void dibujString(final Graphics g,final String s, final Point p){
      contDibuj++;
   
        g.drawString(s, p.x, p.y);
    }
    
    
    
    
        public static void dibujString(final Graphics g,final String s, final int x, final int y, final Color c ){
      contDibuj++;
        g.setColor(c);
        g.drawString(s, x, y);
    }
    
            public static void dibujString(final Graphics g,final String s, final int x, final Point p, final Color c ){
    contDibuj++;
        g.setColor(c);
        g.drawString(s, p.x, p.y);
    }
    
            
            
          public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto){
                    contDibuj++;
                //    g.fillRect(x, y,ancho,alto);
                    
                    
                    
          }  
            
            
            
                public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r){
                   
                    
                    contDibuj++;
            
                    g.fillRect(r.x,r.y,r.width,r.height);
                  
                  
                           
          }  
            
            
                
                 public static void dibujarRectanguloRelleno(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                    contDibuj++;
                    g.setColor(c);
                    g.fillRect(x, y,ancho,alto);
          }  
                
                
              public static void dibujarRectanguloRelleno(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
               public static void dibujarRectanguloRelleno2(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    
                   g.setColor(c);
                  
                    g.fillRect(r.x,r.y,r.width,r.height);   
                
              }
            
              
              
              
              public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto){
                   contDibuj++;
                    g.drawRect(x, y,ancho,alto);
          }  
            
            
            
                public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r){
                    contDibuj++;
                    g.drawRect(r.x,r.y,r.width,r.height);
          }  
            
            
                
                 public static void dibujarRectanguloVacio(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(x, y,ancho,alto);
          }  
                
                
              public static void dibujarRectanguloVacio(final Graphics g,final Rectangle r, final Color c){
                   contDibuj++;
                    g.setColor(c);
                    g.drawRect(r.x,r.y,r.width,r.height);   
                
              }
             
              
              
              
              
              public static int getContDibuj(){
                  return contDibuj;
              }
              
              
              public static void RestartContDibuj(){
                  contDibuj=0;
              }
              
              
            
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
