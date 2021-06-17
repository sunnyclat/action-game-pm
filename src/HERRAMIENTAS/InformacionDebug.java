/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HERRAMIENTAS;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author samuel ludueña 2021
 */
public class InformacionDebug {
    
    
    private static ArrayList<String> datos= new ArrayList<String>();
    
    
    public static void enviaDatos(final String dato){
 
        
        datos.add(dato);
    }
    
    
    public static void dibujaDatos(final Graphics g){
      
        g.setColor(Color.yellow);
        
        for(int i=0;i<datos.size();i++){
            DibujadorRectangulosImagenes.dibujString(g, datos.get(i), 20,60 + i*10);
        }
        
        
        datos.clear();
        
        
    }
    
    public static void vaciarDatos(){
        datos.clear();
    }
    
    
    
    
    
    
    
}
