/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;
import SPRITES.HojaSprites;
import SPRITES.Sprite;

/**
 *
 * @author samuel ludueña 2021
 */
public abstract class Items {

  //  public static HojaSprites hojaItems = new HojaSprites(Constantes.RUTA_ITEMS, Constantes.LADO_SPRITE, false);

    protected final int id;
    protected final String nombre;
    protected final String descrip;
 //   protected final Sprite sprite;

    private int cant;
    private int cantMax;
    
    
    protected Rectangle posicMenu;  //dibuja el item dentro del menu
    protected Rectangle posicMouse; //dibuja el item flotando al lado del cursor al hacerle click

    public Items(final int id, final String nombre, final String descripcion, final int cantidad) {

        this.id = id;
        this.nombre = nombre;
        this.descrip = descripcion;
   //     this.sprite = hojaItems.getSprite(id);

       this.cant = cantidad;
        cantMax = 99;
        
        
        
        
        posicMenu= new Rectangle(0,0,0,0);
        posicMouse= new Rectangle(0,0,0,0);
        
        
        
        
        

    }

    public Items(String nombre, Sprite sprite, final int id, final String descripcion, final int cantidad) {
        this(id, nombre, descripcion,cantidad);

        if (cant <= cantMax) {

            this.cant = cantidad;
        }

    }

    public abstract Sprite getSprite();


    
    
    public boolean incremCant(final int  incremento){
        
        boolean incremented=false;
        
        
        if(cant + incremento <= cantMax){
            cant += incremento;
            
            incremented=true;
            
        }
        
        return incremented;
        
        
        
    }
    
    
    
        public boolean decremCant(final int  decremento){
        
        boolean decremented=false;
        
        
        if(cant - decremento >= 0){
            cant -= decremento;
            
            decremented=true;
            
        }
        
        return decremented;
        
        
        
    }
    
        
        public String getNombre(){
            return nombre;
        }
        
        
        
          
        public String getDescripcion(){
            return descrip;
        }
        

        
        
        
        public Rectangle getPosicMenu(){
            return posicMenu;
        }
        
        
            public Rectangle getPosicMouse(){
            return posicMouse;
        }
        
            
            
            public void setPosicMenu(final Rectangle posicMenu){
                this.posicMenu=posicMenu;
            }
            
            
               public void setPosicMouse(final Rectangle posicMouse){
                this.posicMouse=posicMouse;
            }
            
            
    
    
    public int getCant(){
        
        return cant;
    }
    
    public int getId(){
        return id;
    }
    
    
    
    
    
    
}
