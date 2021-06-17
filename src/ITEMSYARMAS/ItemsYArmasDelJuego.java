/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ITEMSYARMAS;

//import static principal.inventario.Items.hojaItems;

/**
 *
 * @author samuel ludueña 2021
 */
public class ItemsYArmasDelJuego {
    


    public static Items obtenItem(final int idItem) {

        Items item = null;

        switch (idItem) {

            case 0:
                item = new Manzana(idItem, "Manzana roja", "",4,10);
                break;

            case 1:
                item = new Consumibles(idItem, "queso", "",5,10);
                break;

            case 2:
                item = new Consumibles(idItem, "pocion", "",7,20);
                break;

            case 3:
                item = new Consumibles(idItem, "jamon", "",8,8);
                break;
            case 4:
                item = new Consumibles(idItem, "bolsa dinero", "",9,10);
                break;

            case 5:
                item = new Espada(idItem, "espada", "", 40, 41,false,true,0.2,1);
                break;
                
            case 6:
                item = new Pistola(idItem, "pistola", "", 7, 10,false,true,0.4,1);
                break;
            
            case 7:
                item = new SinArmas(idItem, "desarmado", "", 0, 0,false,true,0,0);
                break;
           
             case 8:
                item = new SinArmas2(idItem, "desarmado", "", 0, 0,false,true,0,0);
                break;
  
                
         
                
        }

        return item;

    }

    /*
     public static Items [] item= new Items[]{
        
        
           
      new Items(0,"Manzana roja", ""),
         new Items(1,"queso", ""),
            new Items(2,"pocion", ""),
              new Items(3,"jamon", ""),
                  new Items(4,"espada", ""),
                    new Items(5,"bolsa dinero", ""),};
     */
}
