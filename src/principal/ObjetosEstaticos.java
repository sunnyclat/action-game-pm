/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Enemigos.Enemigos;
import GESTOR_MAPA.GestorMapa;
import Personajes.Personaje;
import ITEMSYARMAS.ItemsDelInventario;
import GESTOR_MAPA.GestorMapaTiled;
import GRAFICOS.LectorCanvas;
import MAQUINA_DE_ESTADO.GestorDeEstados;
import MenuJuego.EstadoMenu;
import MenuJuego.EstadoMenuPausa;
import PERIFERICOS.Teclado;
import Personajes.InventarioPersonaje;
import SONID.Audio;

/**
 *
 * @author samuel ludueña 2021
 */
public class ObjetosEstaticos {

    
      
       public static GestorMapaTiled mt= new GestorMapaTiled(Constantes.RUTA_MAPA_JSON);
    
   // public static GestorMapa mapa= new GestorMapa (Constantes.RUTA_PALETA);
    public static Personaje persona= new Personaje ();
  
    public static ItemsDelInventario inventario = new ItemsDelInventario();
    
       
    public static EstadoMenuPausa menuPausa= new EstadoMenuPausa();
    
    
    public static final Teclado teclado= new Teclado();
    
    
    
    public static GestorDeEstados ge= new GestorDeEstados ();
    
    public static EstadoMenu em= new EstadoMenu();
    
    public static ItemsDelInventario itInv= new ItemsDelInventario();
   
    
    
    public static InventarioPersonaje invPersona= new InventarioPersonaje();
    
}
