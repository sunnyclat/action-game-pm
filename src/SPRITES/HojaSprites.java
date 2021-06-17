/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPRITES;

import java.awt.image.BufferedImage;
import HERRAMIENTAS.CargadorRecursos;

/**
 *
 * @author samuel ludueña 2021
 */
public class HojaSprites {
    
    
    
  final  private int anchoHojaPix;  //tamaño de la hoja de sprites.
  final  private int altoHojaPix;
    
  final  private int anchoHojaSprites; //cuantos sprites habra en el eje x y el eje y
final    private int altoHojaSprites;
    
final    private int anchoSprites;
final    private int altoSprites;
    
   // private BufferedImage imagen;
final  private Sprite[] sprites;
    
    
    public HojaSprites(final String ruta,final int tamañoSprites, final boolean opacidad){
    
      final  BufferedImage imagen; //lo ponemos como final ya que lo iniciaremos solo una vez en todo el metodo
        
        
        if(opacidad){
            imagen=CargadorRecursos.cargarImageCompatibleOpaca(ruta);
        }
        else{
            imagen=CargadorRecursos.cargarImageCompatibleTranslucida(ruta);
        }
        
        anchoHojaPix= imagen.getWidth();
        altoHojaPix=imagen.getHeight();
        
        anchoHojaSprites= anchoHojaPix / tamañoSprites; // si la hoja tiene 320pixeles, dividido por el tmaaño que es 32pixeles, sabremos que son 10 sprites en la hoja x
        altoHojaSprites=altoHojaPix / tamañoSprites; //lo mismo en la hoja y.
        
        anchoSprites= tamañoSprites;   //son lo mismo porque los sprites en este constructor son cuadrados.
        altoSprites=tamañoSprites;
        
        sprites=new Sprite[anchoHojaSprites*altoHojaSprites];
        
        extractSprites(imagen);
    }
    
    
    
    
    
    
    
     public HojaSprites(final String ruta,final int anchoSprites,final int altoSprites, final boolean opacidad){
    
      final  BufferedImage imagen; //lo ponemos como final ya que lo iniciaremos solo una vez en todo el metodo
        
        
        if(opacidad){
            imagen=CargadorRecursos.cargarImageCompatibleOpaca(ruta);
        }
        else{
            imagen=CargadorRecursos.cargarImageCompatibleTranslucida(ruta);
        }
        
        anchoHojaPix= imagen.getWidth();
        altoHojaPix=imagen.getHeight();
        
        anchoHojaSprites= anchoHojaPix / anchoSprites; //aca esta la diferencia en donde se divide el ancho de hoja por el ancho de sprites y lo mismo con alto.
        altoHojaSprites=altoHojaPix / altoSprites; 
        
        this.anchoSprites= anchoSprites;   //son lo mismo porque los sprites en este constructor son cuadrados.
        this.altoSprites=altoSprites;
        
        sprites=new Sprite[anchoHojaSprites*altoHojaSprites];
        
        extractSprites(imagen);
    }
    
    
    
    
    
    private void extractSprites(final BufferedImage imagen){
        
        for(int y=0;y<altoHojaSprites;y++){                  //recorremos alto de la hoja de sprite
            for(int x=0; x<anchoHojaSprites;x++){            //recorremos ancho de la hoja de sprite
             
                final int posX= x * anchoSprites;            //nos posicionamos en un pixel de la hoja
                        final int posY= y * altoSprites;            
                
                sprites[ x+y * anchoHojaSprites]=new Sprite(imagen.getSubimage(posX, posY, anchoSprites, altoSprites));
                // saca todos los sprites que existan de una hoja de sprites. 
                
            }
            
        }
        
        
        
        
    }
    
    
    
    public Sprite getSprite(final int indice){  //este trabaja con indices
        return sprites[indice];
        
    }
    
      /*  
    public Sprite getSprite2(final int indice){  //este trabaja con indices
        return sprites[indice];
        
    }
    
      */
    
    /*
    public  Sprite getSpritee(final int indice){  //este trabaja con indices
        return sprites[indice *anchoHojaSprites ];
        
    }
    */
    
    
    public Sprite getSprite(final int x, final int y){  //este trabaja con posiciones
       
        
        return sprites [x + y * anchoHojaSprites];
    }
    
    
    
    
}
