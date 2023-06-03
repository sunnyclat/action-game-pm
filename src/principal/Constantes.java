<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.Font;
import HERRAMIENTAS.CargadorRecursos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Constantes {

    public static final int LADO_SPRITE = 32;
    public static  int LADO_CURSOR=0;


    
    public static int ANCHO_JUEGO = 640;
    public static int ALTO_JUEGO = 360;
    

    public static int ANCHO_FULL_SCREEN = 1280;
    public static int ALTO_FULL_SCREEN = 720;

public static final int MARGEN_X = ANCHO_JUEGO / 2 - LADO_SPRITE / 2;  //nos da aproximadamente el centro
public static final int MARGEN_Y = ALTO_JUEGO / 2 - LADO_SPRITE / 2;
    
        public static double FACTOR_ESCAL_X = ANCHO_FULL_SCREEN / ANCHO_JUEGO;

    public static double FACTOR_ESCAL_Y = ALTO_FULL_SCREEN / ALTO_JUEGO;
    
    
   
    public static int CENTRO_PANTALLA_X = ANCHO_JUEGO / 2;
    public static int CENTRO_PANTALLA_Y = ALTO_JUEGO / 2;



//SONIDOS ARMAS
    
    public static String DISPARO_PISTOLA_SONIDO = "/recurS/sonidos/disparoPistola.wav";
       public static String GOLPE_PUNO_SONIDO = "/recurS/sonidos/punch2.wav";
         public static String ESPADAZO_SONIDO = "/recurS/sonidos/sword2.wav";
      
         
         //SONIDO RESUREC
         public static String RESUREC_SONIDO="/recurS/sonidos/resurecSonido.wav";
    
         //MUSICA
            public static String MUSICA_VENOM = "/recurS/musica/venom.wav";
    
            public static String MUSICA_INTRO = "/recurS/musica/introMetal2.wav";
    
            //SONIDOS QUEJAS
            
    public static String SONIDO_ATAQUE_ZOMBIE="/recurS/sonidos/sonidoAtaqueZombie.wav";
    public static String SONIDO_QUEJA_ZOMBIE = "/recurS/sonidos/quejaZombie.wav";
     public static String SONIDO_MUERTE_ZOMBIE = "/recurS/sonidos/muerteZombie.wav";
     
     
     public static String SONIDO_QUEJA_PERSONAJE="/recurS/sonidos/quejaPersonaje.wav";
     
     
     
     //MAPA TEXTO Y BASE
    public static String RUTA_PALETA = "/recurS/texto/01.txt";
  //      public static String RUTA_PALETA2 = "/recurS/texto/02.txt";
    
         public static String RUTA_MAPA = "/recurS/imagenes/HojaTexturas/";
    
    //LOGOTIPOS
    public static String RUTA_LOGOTIPO = "/recurS/imagenes/iconos/logotipo.png";
  
    
    //PARTIDA GUARDADA
    public static String RUTA_ARCHIVO_GUARDADO="src/recurS/save/";

    //PERSONAJES
    public static String RUTA_PERSONAJE = "/recurS/imagenes/HojaPersonajes/2.png";
     
    
    //PERSONAJES CON ARMAS
    public static String RUTA_PERSONAJE_ESPADA="/recurS/imagenes/HojaPersonajes/character3Espada.png";
      public static String RUTA_PERSONAJE_PISTOLA="/recurS/imagenes/HojaPersonajes/character3Pistola.png";
    
      //DIBUJO DE SOBREVIVIR
      public static String RUTA_EFECTO_REVIVIR_PERSONAJE1="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje.png";
    public static String RUTA_EFECTO_REVIVIR_PERSONAJE2="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje2.png";
    public static String RUTA_EFECTO_REVIVIR_PERSONAJE3="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje3.png";
    
     public static String RUTA_ENEMIGOS = "/recurS/imagenes/HojaEnemigos/";
   
          public static String RUTA_JEFES = "/recurS/imagenes/HojaEnemigos/jefes/";

   
      
      
      
      //RUTA MAPA
     //      public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/mapaSamu.json";
//    public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/NUEVOO1.json";
        public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/BOSQUE.json";
        
         public static String RUTA_MAPA_JSON2="/recurS/imagenes/HojaTexturas/CUEVA.json";
   //  public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/apoca.json";

    
    public static String RUTA_MAPA_BASE_PARA_JSON="/recurS/imagenes/HojaImagen/";
     
         //RUTA ICONO
         public static String RUTA_ICONO = "/recurS/imagenes/iconos/icono.png";
  
      
      //RUTA CURNOSR
      public static String RUTA_CURSOR = "/recurS/imagenes/iconos/cursor2.png";

    

    
    //RUTA ITEMS Y ARMAS
    public static String RUTA_CONSUMIBLES="/recurS/imagenes/HojaItems/1.png";
     
    public static String RUTA_ARMA_ESPADA="/recurS/imagenes/armas/espada.png";
       public static String RUTA_ARMA_PISTOLA="/recurS/imagenes/armas/pistola1.png";
     
     public static String RUTA_ITEMS_SUELO="/recurS/imagenes/HojaItemSuelo/saco.png";
    
     
     
     //RUTA FUENTES
    public static Font FUENTE3 = CargadorRecursos.cargarFuentes("/recurS/fuentes/joystick.ttf");
    
        public static Font FUENTE = CargadorRecursos.cargarFuentes("/recurS/fuentes/OpenSans-Regular.ttf");
    
    public static Font FUENTE2 = CargadorRecursos.cargarFuentes("/recurS/fuentes/OpenSans-Regular.ttf");
    
    
    //RUTA COLORES
            public static final Color COLOR_NARANJA= new Color(0xff6700);

    
          public static final Color COLOR_TRANSPARENTE= new Color(0x1C00ff00);
    
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.Font;
import HERRAMIENTAS.CargadorRecursos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Constantes {

    public static final int LADO_SPRITE = 32;
    public static  int LADO_CURSOR=0;


    
    public static int ANCHO_JUEGO = 640;
    public static int ALTO_JUEGO = 360;
    

    public static int ANCHO_FULL_SCREEN = 1280;
    public static int ALTO_FULL_SCREEN = 720;

public static final int MARGEN_X = ANCHO_JUEGO / 2 - LADO_SPRITE / 2;  //nos da aproximadamente el centro
public static final int MARGEN_Y = ALTO_JUEGO / 2 - LADO_SPRITE / 2;
    
        public static double FACTOR_ESCAL_X = ANCHO_FULL_SCREEN / ANCHO_JUEGO;

    public static double FACTOR_ESCAL_Y = ALTO_FULL_SCREEN / ALTO_JUEGO;
    
    
   
    public static int CENTRO_PANTALLA_X = ANCHO_JUEGO / 2;
    public static int CENTRO_PANTALLA_Y = ALTO_JUEGO / 2;



//SONIDOS ARMAS
    
    public static String DISPARO_PISTOLA_SONIDO = "/recurS/sonidos/disparoPistola.wav";
       public static String GOLPE_PUNO_SONIDO = "/recurS/sonidos/punch2.wav";
         public static String ESPADAZO_SONIDO = "/recurS/sonidos/sword2.wav";
      
         
         //SONIDO RESUREC
         public static String RESUREC_SONIDO="/recurS/sonidos/resurecSonido.wav";
    
         //MUSICA
            public static String MUSICA_VENOM = "/recurS/musica/venom.wav";
    
            public static String MUSICA_INTRO = "/recurS/musica/introMetal2.wav";
    
            //SONIDOS QUEJAS
            
    public static String SONIDO_ATAQUE_ZOMBIE="/recurS/sonidos/sonidoAtaqueZombie.wav";
    public static String SONIDO_QUEJA_ZOMBIE = "/recurS/sonidos/quejaZombie.wav";
     public static String SONIDO_MUERTE_ZOMBIE = "/recurS/sonidos/muerteZombie.wav";
     
     
     public static String SONIDO_QUEJA_PERSONAJE="/recurS/sonidos/quejaPersonaje.wav";
     
     
     
     //MAPA TEXTO Y BASE
    public static String RUTA_PALETA = "/recurS/texto/01.txt";
  //      public static String RUTA_PALETA2 = "/recurS/texto/02.txt";
    
         public static String RUTA_MAPA = "/recurS/imagenes/HojaTexturas/";
    
    //LOGOTIPOS
    public static String RUTA_LOGOTIPO = "/recurS/imagenes/iconos/logotipo.png";
  
    
    //PARTIDA GUARDADA
    public static String RUTA_ARCHIVO_GUARDADO="src/recurS/save/";

    //PERSONAJES
    public static String RUTA_PERSONAJE = "/recurS/imagenes/HojaPersonajes/2.png";
     
    
    //PERSONAJES CON ARMAS
    public static String RUTA_PERSONAJE_ESPADA="/recurS/imagenes/HojaPersonajes/character3Espada.png";
      public static String RUTA_PERSONAJE_PISTOLA="/recurS/imagenes/HojaPersonajes/character3Pistola.png";
    
      //DIBUJO DE SOBREVIVIR
      public static String RUTA_EFECTO_REVIVIR_PERSONAJE1="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje.png";
    public static String RUTA_EFECTO_REVIVIR_PERSONAJE2="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje2.png";
    public static String RUTA_EFECTO_REVIVIR_PERSONAJE3="/recurS/imagenes/HojaPersonajes/efectoRevivirPersonaje3.png";
    
     public static String RUTA_ENEMIGOS = "/recurS/imagenes/HojaEnemigos/";
   
     

   
      
      
      
      //RUTA MAPA
     //      public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/mapaSamu.json";
//    public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/NUEVOO1.json";
        public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/BOSQUE.json";
   //  public static String RUTA_MAPA_JSON="/recurS/imagenes/HojaTexturas/apoca.json";

    
    public static String RUTA_MAPA_BASE_PARA_JSON="/recurS/imagenes/HojaImagen/";
     
         //RUTA ICONO
         public static String RUTA_ICONO = "/recurS/imagenes/iconos/icono.png";
  
      
      //RUTA CURNOSR
      public static String RUTA_CURSOR = "/recurS/imagenes/iconos/cursor2.png";

    

    
    //RUTA ITEMS Y ARMAS
    public static String RUTA_CONSUMIBLES="/recurS/imagenes/HojaItems/1.png";
     
    public static String RUTA_ARMA_ESPADA="/recurS/imagenes/armas/espada.png";
       public static String RUTA_ARMA_PISTOLA="/recurS/imagenes/armas/pistola1.png";
     
     public static String RUTA_ITEMS_SUELO="/recurS/imagenes/HojaItemSuelo/saco.png";
    
     
     
     //RUTA FUENTES
    public static Font FUENTE3 = CargadorRecursos.cargarFuentes("/recurS/fuentes/joystick.ttf");
    
        public static Font FUENTE = CargadorRecursos.cargarFuentes("/recurS/fuentes/OpenSans-Regular.ttf");
    
    public static Font FUENTE2 = CargadorRecursos.cargarFuentes("/recurS/fuentes/OpenSans-Regular.ttf");
    
    
    //RUTA COLORES
            public static final Color COLOR_NARANJA= new Color(0xff6700);

    
          public static final Color COLOR_TRANSPARENTE= new Color(0x1C00ff00);
    
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
