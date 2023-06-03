<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.util.ArrayList;
import SPRITES.HojaSprites;
import principal.Constantes;
import GESTOR_MAPA.ItemsMapaTiled;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsDelInventario {



    public final ArrayList<Items> items;
      


    
    
    
  //  public final ArrayList<Consumibles> consum2;
    
   
    
    
    
    public ItemsDelInventario() {



        items = new ArrayList<Items>();
       
        
       
  
    
        
        
     //   consum2=new ArrayList<Consumibles>();
        
        
    }
/*
    
    public void agarrarItemsMapa(final ItemsDelPiso vi){
        
        for ( Items item : vi.getItems() ){
            
            if(itemExiste(item)){
                incremItems(item, item.getCant());
                
            }else{
                
                items.add(item);
                
            }
            
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
    }
    
    */
    
    public void agarrarItemDeMapaTiled(final ItemsMapaTiled itemTiled){
      
        if(itemExiste(itemTiled.getItem())){
        
            
            incremItems(itemTiled.getItem(), itemTiled.getItem().getCant());
                
            }else{
                
                items.add(itemTiled.getItem());
                
            }
            
      
      
      
      
      
      
    }
    
    
    
    
    
    
    public boolean incremItems(final Items item, final int cant){
        
        boolean increm=false;
        
        for(Items itemAct: items){
         
            if(itemAct.getId()== item.getId()){
               
                itemAct.incremCant(cant);
                increm=true;
                break;
                
                
                
                
            }
        }
        
        return increm;
        
    }
    
    
    
    
        

    
    
    
    
    
    public boolean itemExiste(final Items item){
      
        boolean existeItem= false;
        
        for(Items itemAct : items){
            
            if(itemAct.getId()== item.getId()){
                existeItem=true;
                break;
            }
            
            
            
            
        }        
        
        return existeItem;
        
        
    }
    
    
    public ArrayList <Items> obtieneConsumible(){
        
        
        ArrayList <Items> consum= new ArrayList <Items>();
        
       for ( Items i : items ){
        
           if(i instanceof Consumibles){
             
               
               consum.add(i);
           }
           
           
           
           
       } 
        
       return consum;
       
       
       
       
       
    }
    
   
 
    public void setConsumible(int cantidad){
        
        
        
        
    }
    
    
    
    
    
       public ArrayList <Items> obtieneArmas(){
          
            ArrayList <Items> armas= new ArrayList <Items>();
           
           for(Items i : items){
               if( i instanceof Armas){
                   armas.add(i);
               }
           }
           
           
           return armas;
       }
    
    
    
    
    
    public Items obtieneIdItm(final int id){
        
        for ( Items i : items){
         
            
            
            if(i.getId() == id){
                return i;
            }
        }
  
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

import java.util.ArrayList;
import SPRITES.HojaSprites;
import principal.Constantes;
import GESTOR_MAPA.ItemsMapaTiled;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsDelInventario {



    public final ArrayList<Items> items;

    public ItemsDelInventario() {



        items = new ArrayList<Items>();

      
        
        
    }
/*
    
    public void agarrarItemsMapa(final ItemsDelPiso vi){
        
        for ( Items item : vi.getItems() ){
            
            if(itemExiste(item)){
                incremItems(item, item.getCant());
                
            }else{
                
                items.add(item);
                
            }
            
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
    }
    
    */
    
  
    
    
    public void agarrarItemDeMapaTiled(final ItemsMapaTiled itemTiled){
      
        if(itemExiste(itemTiled.getItem())){
        
            
            incremItems(itemTiled.getItem(), itemTiled.getItem().getCant());
                
            }else{
                
                items.add(itemTiled.getItem());
                
            }
            
      
      
      
      
      
      
    }
    
    
    
    
    
    
    public boolean incremItems(final Items item, final int cant){
        
        boolean increm=false;
        
        for(Items itemAct: items){
         
            if(itemAct.getId()== item.getId()){
               
                itemAct.incremCant(cant);
                increm=true;
                break;
                
                
                
                
            }
        }
        
        return increm;
        
    }
    
    
    public boolean itemExiste(final Items item){
      
        boolean existeItem= false;
        
        for(Items itemAct : items){
            
            if(itemAct.getId()== item.getId()){
                existeItem=true;
                break;
            }
            
            
            
            
        }        
        
        return existeItem;
        
        
    }
    
    
    public ArrayList <Items> obtieneConsumible(){
        
        
        
        
        ArrayList <Items> consum= new ArrayList <Items>();

        
        
        
        
        
       for ( Items i : items ){
        
           if(i instanceof Consumibles){
               consum.add(i);
           }
           
           
        
           
       } 
        
       return consum;
       
       
       
       
       
    }
    
    
    
    
       public ArrayList <Items> obtieneArmas(){
          
            ArrayList <Items> armas= new ArrayList <Items>();
           
           for(Items i : items){
               if( i instanceof Armas){
                   armas.add(i);
               }
           }
           
           
           return armas;
       }
    
    
    
    
    
    public Items obtieneIdItm(final int id){
        
        for ( Items i : items){
            if(i.getId() == id){
                return i;
            }
        }
  
        return null;
    }
    
    
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
