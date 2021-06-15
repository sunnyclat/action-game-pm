/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import principal.Constantes;
import principal.ObjetosEstaticos;
import Personajes.Personaje;
import Personajes.Personaje;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

/**
 *
 * @author samuel ludueña 2021
 */
public class InventarioInferior {
    
    
    private Rectangle areaInv;   //zona inferior donde estara el inventario
    private Rectangle bordeAreaInv; //borde que envuelve al inventario
    
    
    //usamos colorpicker
    
    private Color negroSatur;
    private Color rojoClaro;
    private Color rojoOsc;
    private Color azulClaro;
    private Color azulOsc;
     private Color verdeClaro;
     private Color verdeOsc;
     private Color naranjClaro;
     private Color naranjOsc;
    
    
    
  //  Graphics g;
    
    //si a una clase la inicio aca, ya no hace falta pasarla por parametro a un metodo para usarlo en un argumento.
    //si a la clase la paso por parametro en cada metodo que la use, no hace falta que la inicie aca.
    
    
    
    public InventarioInferior(){
     
        int altoInv=64;
         
     //    areaInv= new Rectangle(0,Constantes.ALTO_JUEGO-altoInv,Constantes.ANCHO_JUEGO,altoInv); // x,y,ancho,alto
        
    areaInv= new Rectangle(0,Constantes.ALTO_JUEGO-altoInv,Constantes.ANCHO_JUEGO,-altoInv); 
     

    // bordeAreaInv= new Rectangle(areaInv.x,areaInv.y-1,areaInv.width,1); //un pixel arriba asi esta un pixel arriba de neustro menu
        
  bordeAreaInv= new Rectangle(areaInv.x,areaInv.y-1,0,1);

  //    negroSatur= new Color(23,23,23); //rojo 23 //verde 23 //azul 23
    
        
  negroSatur= new Color(23,23,23); //rojo 23 //verde 23 //azul 23
  
  
        rojoClaro= new Color(255, 0, 0);   //todo a tope. bien rojo puro
     rojoOsc= new Color(150, 0, 0);
     
     azulClaro=new Color(0,200,255);
       azulOsc=new Color(0,132,168);
       
       verdeClaro=new Color(2, 245, 35);
               verdeOsc=new Color(0, 36, 0);
               
               
               
                naranjClaro=new Color(252, 186, 3);
              naranjOsc=new Color(125, 92, 1);
     
    }     
         
         
         
   public void dibujar( final Graphics g){
        
        dibujAreaInv(g);
        
        dibujBarraVida(g);
        
        dibujBarraPoder(g);
      
        dibujBarraStamina(g);
       
        dibujBarraExp(g);
        
   //     dibujRanurObj(g);
    }     
         
         
         
         private void dibujAreaInv(final Graphics g){
             
             
             DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv,negroSatur);
             
             DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, bordeAreaInv,Color.RED);
             
             
             
         }
         
         
         
      private void dibujBarraVida(final Graphics g){
      
          
          final int  medidaVertic= 4;          //medida vertical de la misma barra
                  final int medidaHoriz= 100;  //medida horizontal de la misma barra
                  
                  //efecto de dos barras formando una sola, tipo 3d
                  
                  
                   final int anchoDurac= medidaHoriz * ObjetosEstaticos.persona.getVidaMax() /  Personaje.VIDA_MAX;
                  
                  
                  
                  DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,areaInv.x+45,areaInv.y + medidaVertic,anchoDurac,medidaVertic,rojoClaro);
                  
                  DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g,areaInv.x+45,areaInv.y + medidaVertic*2,anchoDurac,medidaVertic,rojoOsc);
    
                  
                  g.setColor(Color.WHITE);
                 
                  DibujadorRectangulosImagenes.dibujString(g,"VIDA",areaInv.x + 1, areaInv.y + medidaVertic+8); 
                      DibujadorRectangulosImagenes.dibujString(g,"1000",medidaHoriz +46 ,areaInv.y + medidaVertic*3);
      }   
         
        

    private void dibujBarraPoder(final Graphics g){
      
        final int medidaVert=4;
        
        final int medidaHoriz=100;
        
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45,areaInv.y + medidaVert*4,medidaHoriz,medidaVert,azulClaro);
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45,areaInv.y + medidaVert*5,medidaHoriz,medidaVert,azulOsc);
        
    
           g.setColor(Color.WHITE);
       
           DibujadorRectangulosImagenes.dibujString(g,"PODER",areaInv.x +1, areaInv.y + medidaVert*6); 
                      DibujadorRectangulosImagenes.dibujString(g,"1000",medidaHoriz +46 ,areaInv.y + medidaVert*6);
        
        
    }
    
    
    private void dibujBarraStamina(final Graphics g){
        
              final int medidaVert=4;
        
        final int medidaHoriz=100;
        
      //  final int ancho=100 * stamina/600;
        
   final int anchoDurac= medidaHoriz * ObjetosEstaticos.persona.getStamina()  /  Personaje.STAMINA_TOTAL;
        
        
         DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45, areaInv.y + medidaVert*7,anchoDurac, medidaVert,verdeClaro);
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45, areaInv.y + medidaVert*8,anchoDurac, medidaVert,verdeOsc);
        
        
        g.setColor(Color.WHITE);
       
           DibujadorRectangulosImagenes.dibujString(g,"RESIS",areaInv.x +1, areaInv.y + medidaVert*9); 
                      DibujadorRectangulosImagenes.dibujString(g,"1000",medidaHoriz +46 ,areaInv.y + medidaVert*9);
        
        
    }
    
    
  
    
    private void dibujBarraExp(final Graphics g){
                 
        final int medidaVert=4;
        
        final int medidaHoriz=100;
        
        
          DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45,areaInv.y + medidaVert*10,medidaHoriz,medidaVert,naranjClaro);
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, areaInv.x +45,areaInv.y + medidaVert*11,medidaHoriz,medidaVert,naranjOsc);
        
        
        
          g.setColor(Color.WHITE);
       
           DibujadorRectangulosImagenes.dibujString(g,"EXPER",areaInv.x +1, areaInv.y + medidaVert*12); 
                      DibujadorRectangulosImagenes.dibujString(g,"1000",medidaHoriz +46 ,areaInv.y + medidaVert*12);
        
        
        
        
    }
    
    
    
    private void dibujRanurObj(final Graphics g){
        
        final int anchRan=32;
                final int cantRan=10;
                final int espacRan=10;
                
                
        final int anchTotal= anchRan*cantRan + espacRan*cantRan;
        
        final int xInic= Constantes.ALTO_JUEGO - anchTotal;
        
        final int anchRanEsp= anchRan + espacRan;
        
        
        g.setColor(Color.white);
        
        for(int i=0; i< cantRan; i++){
          
            int xActual= xInic + anchRanEsp * i;
            
          
            
        //    Rectangle ranura= new Rectangle(xActual,areaInv.y+20,anchRan,anchRan);   //4 para que el inventario este un poco mas abajo
        
            
              Rectangle ranura= new Rectangle(xActual+250,areaInv.y+10,anchRan,anchRan);
            
            
      //  DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, ranura);
        
        
        DibujadorRectangulosImagenes.dibujString(g,"" + i , xActual + 265, areaInv.y + 54);
        
        
        
        
            
        }
        
       
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
