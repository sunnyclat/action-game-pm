/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import Enemigos.Enemigos;
import GESTOR_MAPA.GestorMapa;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import principal.Constantes;
import principal.ObjetosEstaticos;

import ITEMSYARMAS.ItemsYArmasDelJuego;
import PERIFERICOS.Teclado;
import ITEMSYARMAS.Armas;

import GRAFICOS.LectorCanvas;
import SPRITES.HojaSprites;
import SPRITES.Sprite;
import HERRAMIENTAS.InformacionDebug;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import ITEMSYARMAS.Consumibles;
import ITEMSYARMAS.Espada;
import ITEMSYARMAS.Items;
import ITEMSYARMAS.ItemsDelInventario;
import ITEMSYARMAS.ItemsDelPiso;
import ITEMSYARMAS.Manzanas;

import ITEMSYARMAS.Pistola;
import ITEMSYARMAS.SinArmas;


import MAQUINA_DE_ESTADO.GestorDeEstados;
import SONID.Audio;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import principal.GestorPrincipal;

/**
 *
 * @author samuel ludueña 2021
 */
public class Personaje {

    private double posX;
    private double posY;
   
    private final Teclado teclado;
    
    public static boolean esMuerto=false;


 //   private int estadoAnimacion;  // no se usa mas
    
         
public Audio sonidoQuejaJugador;
    public Audio sonidoResurrecion;
    

      private int animacionn;

    private int estadoss;

    private boolean enMov;

                public static int centroX; 
                public static int centroY;
              
   // private float vidaActual;
    
        public final static int VIDA_MAX=100;
   
    public int vidaMax=20;
    public int cantidad=0;
    public int direccion;

    private double veloc = 1;  //avanzamos rapido en los pixeles dando el efecto de correr

    private  HojaSprites hs;
    
 //   boolean curado=true;
    
   // boolean herido=false;
    
    boolean objeto;
    private int suma=0;
    private int sumarVida=0;
    private int vidaActual=0;
private int aConsum=0;
    
    private HojaSprites revivir1;
     private HojaSprites revivir2;
      private HojaSprites revivir3;

    private BufferedImage imagenActual;

       
      boolean esArma=false;
       
    private BufferedImage revivirActual1;
    private BufferedImage revivirActual2;
        private BufferedImage revivirActual3;
    
    private final int ANCHO_JUGADOR = 16;
    private final int ALTO_JUGADOR = 16;

    private final Rectangle LIMITE_ARRIBA = new Rectangle(Constantes.CENTRO_PANTALLA_X - ANCHO_JUGADOR / 2, Constantes.CENTRO_PANTALLA_Y, ANCHO_JUGADOR, 1);

    private final Rectangle LIMITE_ABAJO = new Rectangle(Constantes.CENTRO_PANTALLA_X - ANCHO_JUGADOR / 2, Constantes.CENTRO_PANTALLA_Y + ALTO_JUGADOR, ALTO_JUGADOR / 2, 1);

    private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constantes.CENTRO_PANTALLA_X - ANCHO_JUGADOR / 2, Constantes.CENTRO_PANTALLA_Y, 1, ALTO_JUGADOR);

    private final Rectangle LIMITE_DERECHA = new Rectangle(Constantes.CENTRO_PANTALLA_X + ANCHO_JUGADOR / 2, Constantes.CENTRO_PANTALLA_Y, 1, ALTO_JUGADOR);

  

    public static int STAMINA_TOTAL=600;
   private  int stamina = 600;
    public int descansado = 0;  //numero de actualizaciones hasta que se recupere nuestro personaje
    private final int RECUPERACION_MAXIMA = 400; //numero de actualizaciones constante
    
    private boolean isDescansado = true;

public int limitPeso= 80;
public int pesoActual= 30;

  private  EquipoDelPersonaje EquipoPersonaje;
  
  private InventarioPersonaje invPersona;
  
  public   ArrayList <Items> consumItm;
  
    
  public   ArrayList <Consumibles> consum;
  
  
  private ArrayList<Rectangle> alcanceAtaquePersonaje;
    public  ArrayList<Items> items;
  
  private  ArrayList<Rectangle>    alcanceActualPersonaje;

int cont=0;
    
boolean objeto2=false;  



    public Personaje( ) {
           
      teclado= new Teclado();
      
        
  


      
        this.posX = ObjetosEstaticos.mt.getPuntoInicial().getX(); //con esto el personaje se ubicara en una posicion x e y en el mapa tiled
        this.posY = ObjetosEstaticos.mt.getPuntoInicial().getY();
      
    

this.sonidoQuejaJugador= new Audio (Constantes.SONIDO_QUEJA_PERSONAJE);
     this.sonidoResurrecion= new Audio(Constantes.RESUREC_SONIDO);

        enMov = false;   //EN QUE MOVIMIENTO ESTA EL PERSONAJE

        direccion = 0;  //EN QUE DIRECCION ESTA MIRANDO EL PERSONAJE  //en metodo "direcciones para el dibujado del personaje"

   
        hs = new HojaSprites(Constantes.RUTA_PERSONAJE, Constantes.LADO_SPRITE, false);
        

        
        
        revivir1=new HojaSprites(Constantes.RUTA_EFECTO_REVIVIR_PERSONAJE1, Constantes.LADO_SPRITE, false);
        revivir2=new HojaSprites(Constantes.RUTA_EFECTO_REVIVIR_PERSONAJE2, Constantes.LADO_SPRITE, false);
        revivir3=new HojaSprites(Constantes.RUTA_EFECTO_REVIVIR_PERSONAJE3, Constantes.LADO_SPRITE, false);
        

        imagenActual = hs.getSprite(0).getImagen(); //GUARDA EL SPRITE DEL PERSONAJE

        
        
        
        
        revivirActual1= revivir1.getSprite(0).getImagen();
      revivirActual2=revivir2.getSprite(0).getImagen();
              revivirActual3=revivir3.getSprite(0).getImagen();
        
        animacionn = 0;    // para el calculo de animaciones
      
      //   estadoAnimacion = 0;  //no se usa mas
      
        estadoss = 0;  //en metodo "dibujado de animaciones personaje"

        
        EquipoPersonaje= new EquipoDelPersonaje((Armas)ItemsYArmasDelJuego.obtenItem(   7 ),(Armas)ItemsYArmasDelJuego.obtenItem(   5 ),(Armas)ItemsYArmasDelJuego.obtenItem(   6 ));

        
        invPersona= new  InventarioPersonaje ((Consumibles)  ( ItemsYArmasDelJuego.obtenItem(0)), (Consumibles) (( ItemsYArmasDelJuego.obtenItem(2)))   );
     
     
     
     
    //       items = new ArrayList<Items>();
//consumItm=new ArrayList<Items>();

consum=new ArrayList<Consumibles>();


         alcanceAtaquePersonaje= new ArrayList();
        
        
        
    }
    

    
    
    
    
    
    private void ActualizaArmaQuePortaPersonaje(){ //tipo de arma que portara el personaje
        
        
          
        calculoAlcanceDelAtaque(); //llamamos al tipo de arma con su alcance
        

  
        
        
         EquipoPersonaje.getSinArmas().actualizar();
             EquipoPersonaje.getPistola().actualizar();
        EquipoPersonaje.getEspada().actualizar();
        
        /*
        if(  (EquipoPersonaje.getPistola() instanceof SinArmas)   ){

   
    }
        
  
        
        
        
        
        
       
           if( (EquipoPersonaje.getEspada() instanceof SinArmas)  ){
   
                 
    }
   
        
        
               if( (EquipoPersonaje.getSinArmas() instanceof SinArmas ) ){
   // EquipoPersonaje.getSinArmas().actualizar();
    
    

    }
   */
        
      
    

    
          
        
      
      //actualizamos al arma

                 //    
    }
    
    
    
     
    private void calculoAlcanceDelAtaque(){  //calculamos el alcance del arma
        
        
        
        
                 
      if( !(EquipoPersonaje.getSinArmas() instanceof SinArmas)  ){
     
          
            alcanceAtaquePersonaje= EquipoPersonaje.getEspada().getAlcance(this);
 
    }
      
        
        
        
        
                 if( !(EquipoPersonaje.getPistola() instanceof Pistola)  ){
         alcanceAtaquePersonaje= EquipoPersonaje.getPistola().getAlcance(this);  // tomamos el alcance del arma
    }
        
        
           
      if( !(EquipoPersonaje.getEspada() instanceof Espada)  ){
       
                alcanceAtaquePersonaje= EquipoPersonaje.getEspada().getAlcance(this);
    }
      
      
   
      
  

    
                
            
                  
       

        

        
        
        
        
    }
    
    
    private void DibujaRectanguloAlcanceArma( final Graphics g){  //creamos el rectangulo de alcance
        

        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, alcanceAtaquePersonaje.get(0)); //ponemos 0 ya que no hay otro rectangulo en el arraylist
        
        
    }
    
    
    
    
    
    
    
    public void setIntPosicX(int posX){
        
        this.posX=posX;
        
        
    }
    
    
     
    public void setIntPosicY(int posY){
        
        this.posY=posY;
        
        
    }
    
    
                                                    //paso 6             
    public void dibujadoDelPersonaje(Graphics g) { //dibujo al personaje con su tamaño   //se dibuja en "gestiona juego desde interface" en el paquete de maquina de estado

 
        
         g.setColor(Color.green); 
          DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaPersonaje2()); 
        
        
        final int centroX = Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
        final int centroY = Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;



     DibujadorRectangulosImagenes.dibujImagen(g, imagenActual, centroX, centroY);  //dibujamos al pesronaje con el sprite de su animacion y su posicion en el mapa
        
  

 
 
 //DibujadorRectangulosImagenes.dibujString(g, "Resistencia: " + stamina, 20, 40); //dibuja la barra de stamina
 
 DibujadorRectangulosImagenes.dibujString(g, "Vida: " + vidaMax, 20, 160);
 
         
        
 
 if(!(alcanceAtaquePersonaje.isEmpty()) ){  //dibujamos linea roja de apuntado
   
     g.setColor(Color.red);
    DibujaRectanguloAlcanceArma(g);
  
  
  
 }


    }
    
    
    public EquipoDelPersonaje getEquipoPersonaje(){
        return EquipoPersonaje;
    }
    
    
    
     
    public InventarioPersonaje getInventarioPersonaje(){
        return invPersona;
    }
    

    private boolean FueraDelMapa(final int MovX, final int MovY) {

        int posFutX = (int) posX + MovX * (int) veloc; //calculamos la posicion que tendra el jugador a futuro, para que no salga del mapa
        int posFutY = (int) posY + MovY * (int) veloc;

        //     final Rectangle bordesMapa= mapa.obtenerBorde((int)posX,(int) posY, ANCHO_JUGADOR, ALTO_JUGADOR);
        final Rectangle bordesMapa = ObjetosEstaticos.mt.obtenerBorde(posFutX, posFutY);

        final boolean fuera;

        //si el jugador esta dentro del mapa y toca su limite sprite con el de mapa
        if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa) || LIMITE_IZQUIERDA.intersects(bordesMapa) || LIMITE_DERECHA.intersects(bordesMapa)) {

            fuera = false;

        } else {

            fuera = true;

        }

        return fuera;

    }

    public void actualizar() {

   //  cargaVidaPersonaje();

CalculoStaminaCansadoRecuparado();   //calcula la stamina
     
VelocidadAnimacionesPersonaje();    //son las animaciones del personaje que se dibujan luego usando los estados
    
enMov = false;
    
MovimientosSegunTeclas();              //movimiento del personaje segun la tecla
    
DibujadoDeAnimacionesPersonaje();   //se dibujan las direcciones y animaciones del personaje




DibujadoPersonajeTipoDeArma(); //dibuja el tipo de arma del personaje

    ActualizaArmaQuePortaPersonaje(); //actualiza el sprite del arma que esta portando el personaje

 
    
    }
    
    
    
    public Point posicionJugador(){
       
        Point posicion= new Point((int)posX,(int)posY);
        
    //    posX=620;
//posY=680;

posX=832;
posY=911;


        
    return posicion;    
        
    }

    private void VelocidadAnimacionesPersonaje() { //se dibujan las animaciones en los estados  // 1 PASO
/*
        if (animacionn < 30) {   //la mitad del numero de actualizaciones que es 60 (si le ponemos mas, ira mas lento para dar los pasos, de lo contrario ira mas rapido)
            animacionn++; //guarda la informacion de velocidad de actualizacion
      
        } else {
            animacionn = 0; //esta sin animacion
        }

    */


if(animacionn < 30){
    
    animacionn++;
    
        
        if (animacionn < 15) {  //la mitad del numero de actualizacion de animacion que definimos en el primer bucle if
        
            estadoss = 1;  //lo guardamos como estado 1
        
        } else {
            estadoss = 2;//sino, seria otro estado.
        }

    }else{
    
    animacionn=0;
}
    
    
    } 
    
    
    private void DibujadoPersonajeTipoDeArma(){ 
  
  
        

        
        
        
        if( (EquipoPersonaje.getSinArmas() instanceof  SinArmas) && !(EquipoPersonaje.getSinArmas() instanceof  Armas)){
        



        }else{
            
            
            
             if( (EquipoPersonaje.getEspada() instanceof  Armas) &&  !(EquipoPersonaje.getEspada()   instanceof Espada)){
       
  hs= new HojaSprites(Constantes.RUTA_PERSONAJE_PISTOLA, Constantes.LADO_SPRITE, false);
   }
        
    
  
   if(  (EquipoPersonaje.getPistola() instanceof  Armas) && !(EquipoPersonaje.getPistola() instanceof  Pistola)  ){
       
 hs= new HojaSprites(Constantes.RUTA_PERSONAJE_ESPADA, Constantes.LADO_SPRITE, false);
               
      
       

  
  
  
     }
 
   
   
   
   
   
       
        }  
   
 }
    
    

    private void CalculoStaminaCansadoRecuparado() {  

        if (ObjetosEstaticos.teclado.correr && stamina > 0) {      //si pulsamos la tecla de correr y hay stamina 
           
            veloc = 2; //nos movemos tantos pixeles (2) por actualizacion
            isDescansado = false;
            descansado = 0;
       
        } else {
            veloc = 1;
      
            if (!isDescansado && descansado < RECUPERACION_MAXIMA) {
                descansado++;
            }

            if (descansado == RECUPERACION_MAXIMA && stamina < 600) {
                stamina++;
            }

        }

    }
    
 
           
           
     public int cargadorManzana(){
         
         
            aConsum= invPersona.getManzana().getGenVida();
            
            
            return aConsum;
          
     }      
           
    
        
         
          

       
          
          
          
    
    
    public int cargadorPocion(){
    
 
        

        

       
        aConsum= invPersona.getPocion().getGenVida();
       
       
       return aConsum;
        
    }
    
    
        public  void cargaVidaPersonaje(int vida){
        
  
             
  

            
                  

                   
                 
                     
            
             vidaMax=vidaMax+vida; 
    
     
     

        }

             
             
             
             
      
             

   
             
            
    
                      
         
     
         
         
         

                 
                 
                 
                 
                 
         
                 
                
        

   

        
     
         

     
    
     
 

              
          
              

          
          
          
    
          
  



              
        
        
   
        
        
     
         

     
    
     
 

         
           
          
          
          
    
   

          
          
          
          
          
          
          
          
          
          
          
                 
         
    /*
                     
      if(!objeto2){
          
          System.out.println("aqui2");
      aConsum= invPersona.getConsumible().getGenVida(); 
      
      
      
      
            
                  sumarVida=   vidaMax + aConsum;
                  
                  
            
                  

                   
                 
                     
            
             vidaMax=sumarVida; 
    cont++;
    
    
  
      }
   
     */

 
                       
   
    
    
    
    
    

    
    
    
          
 
                 
     
                  
   
                
              
          
    
       
   
       
       
       
       
       
       
       
       
       

                 
                  /*  

             if(curado==false
                     ){
                    
                    
                    vidaActual=vidaMax;   
                    
                    
                    
                    objeto= ObjetosEstaticos.inventario.obtieneConsumible().isEmpty();
                            

          if(    !(objeto)  && vidaMax<100  && vidaMax>0 ){
            
              
        
              
      
              
              
              
           
              
                    System.out.println("ida2");   
                    
                    
                
                    
                    
                     aConsum= invPersona.getConsumible().getGenVida(); //10
              
                     System.out.println(vidaMax);
                System.out.println(aConsum);
                
                
                
              
           sumarVida=   vidaMax + aConsum;
                 
           
           
         
      //  suma=   (sumarVida-vidaActual) + vidaMax  ;  //no borrar
        
        
   
           
        

       

    
        
        vidaMax=sumarVida;
        
        
              System.out.println(vidaMax);
      
              
       
      
           
           
           
                     
         curado=true;
       

          }
        
                   
                   
              */ 
  
                  
                  
                  
                  
                  
                  
                     
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  

          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
        


    
       
    
    
      
 
                    

        
   
        
        
        
    
    
    
    public  void perdidaVidaPersonajee(float ataqueEnemigoRecibido){
       
        

            
       esMuerto=false;
        
        if(vidaMax - ataqueEnemigoRecibido < 0){
          
   
            
            
             
                      
                         vidaMax = 0;
 
                    if(vidaMax==0){
                        
                     JOptionPane.showMessageDialog(null, "TE MATARON !!!!");  
                   
              
                 
                    
 
                        
            
                   
              char rta=0;
            

                       String input;   
                            
                            
                             input= JOptionPane.showInputDialog(null, "DESEA JUGAR NUEVAMENTE ??: 1/s   2/n" + rta);
                                 
              
                          
                            String rtta=input;
                               
                
              
                         
                          
                        
                               
                               if(rtta.equals("s")){
                                       
    esMuerto=true;
    vidaMax=100;
    sonidoResurrecion.reproduceSonido();
posicionJugador();

    
                    
      
                                    
                                     
                               }
                               
                                       if(rtta.equals("n")){
                                           
                                           
                                    
                                   System.exit(vidaMax);
                               }
                                
                                
                                
     
            
            
    
              
             
                    
                
                
            }
            
                     
            



         
        }else{
            
 
          
            
            
      
            vidaMax -= ataqueEnemigoRecibido; //le restamos la vida con el ataque recibido
         
             sonidoQuejaJugador.reproduceSonido();
            
            System.out.println("me esta dañando"); 
            
            
 
            
            
        } 
            
            
            
            
            
            
            
            
            
        }
        
        
         
        
        
        
        
    
    
    
    
    

    private void MovimientosSegunTeclas() {  //4 PASO (a y b)
    
        final int MovimientoX = MovimientoPersonajeEjeX();
        final int MovimientoY = MovimientoPersonajeEjeY();

        if (MovimientoX == 0 && MovimientoY == 0) {  //si ninguna de las velocidad es diferente de 0, es un return para salir ya que no hay movimiento y no tiene sentido
            return;
        }

        if ((MovimientoX != 0 && MovimientoY == 0) || (MovimientoX == 0 && MovimientoY != 0)) { //si existe velocidad vertical pero no horizontal 
           movimientosColisionesTeclaCorrer(MovimientoX, MovimientoY);
     
        } else {

            if (MovimientoX == -1 && MovimientoY == -1) {  //si hemos pulsado izquierda y arriba a la vez.
         
                if (teclado.izquierda.getLastPulsed() >teclado.arriba.getLastPulsed()) {
                  
                    movimientosColisionesTeclaCorrer(MovimientoX, 0);
             
                } else {
                     movimientosColisionesTeclaCorrer(0, MovimientoY);
                }

            }

            // izquierda y abajo
            if (MovimientoX == -1 && MovimientoY == 1) {  //si hemos pulsado izquierda y abajo a la vez.
                if (teclado.izquierda.getLastPulsed() > teclado.abajo.getLastPulsed()) {

                    movimientosColisionesTeclaCorrer(MovimientoX, 0);
                } else {
                   movimientosColisionesTeclaCorrer(0, MovimientoY);
                }
            }

            //derecha arriba
            if (MovimientoX == 1 && MovimientoY == -1) {  //si hemos pulsado derecha y arriba a la vez.
                if (teclado.derecha.getLastPulsed() > teclado.arriba.getLastPulsed()) {

                     movimientosColisionesTeclaCorrer(MovimientoX, 0);
                } else {
                     movimientosColisionesTeclaCorrer(0, MovimientoY);
                }

            }

            //derecha abajo
            if (MovimientoX == 1 && MovimientoY == 1) {  //si hemos pulsado derecha y abajo a la vez.
                if (teclado.derecha.getLastPulsed() > teclado.abajo.getLastPulsed()) {

                    movimientosColisionesTeclaCorrer(MovimientoX, 0);
                } else {
                   movimientosColisionesTeclaCorrer(0, MovimientoY);
                }

            }

        }

    }

    private void movimientosColisionesTeclaCorrer(final int MovX, final int MovY) { //se llama dentro de metodo movimientos segun teclas  //3 PASO
       
        enMov = true; //esta por defecto en movimiento, sino no se movera haciendo las animaciones

        DireccionesParaElDibujadoPersonaje(MovX, MovY); //se cambia y se dirige de acuerdo a lo que le corresponda

  
        if (!FueraDelMapa(MovX, MovY)) {

            if (MovX == -1 && !colisIzq(MovX)) { //si me muevo a la izquierda y no hay colision

                posX += MovX * veloc;           //sumamos la posiicon con el movimiento

                if (ObjetosEstaticos.teclado.correr && stamina>0 ) {
                
                    stamina--;
         
                }
             

            }

            if (MovX == 1 && !colisDer(MovX)) {

                posX += MovX * veloc;

                if (ObjetosEstaticos.teclado.correr && stamina>0  ) {
                    stamina--;
                 
              
                }

            }

            if (MovY == -1 && !colisArriba(MovY)) {

                posY += MovY * veloc;

                if (ObjetosEstaticos.teclado.correr && stamina>0 ) {
                    stamina--;
             
                }
     
            }

            if (MovY == 1 && !colisAbajo(MovY)) {

                posY += MovY * veloc;

                if (ObjetosEstaticos.teclado.correr && stamina>0 ) {
                    stamina--;
                  
                }
      
            }

        }

    }

  
    
    
    private boolean colisArriba(int velocY) {



for (int i = 0; i < ObjetosEstaticos.mt.areasColisionActualizar.size(); i++) {

            final Rectangle zonas = ObjetosEstaticos.mt.areasColisionActualizar.get(i);

            int origenX = zonas.x;
            int origenY = zonas.y + velocY * (int) veloc + 3 * (int) veloc;

            final Rectangle zonaFut = new Rectangle(origenX, origenY, zonas.width, zonas.height);

            if (LIMITE_ARRIBA.intersects(zonaFut)) {  //lo bueno de intersects es que devuelve true al momento que se produce, sin tener que terminar de recorrer todo el array
                return true;
            }

        }











 return false;

    }

    private boolean colisAbajo(int velocY) {



     for (int i = 0; i < ObjetosEstaticos.mt.areasColisionActualizar.size(); i++) {

            final Rectangle zonas = ObjetosEstaticos.mt.areasColisionActualizar.get(i);

            int origenX = zonas.x;
            int origenY = zonas.y + velocY * (int) veloc - 3 * (int) veloc;

            final Rectangle zonaFut = new Rectangle(origenX, origenY, zonas.width, zonas.height);

            if (LIMITE_ABAJO.intersects(zonaFut)) {  //lo bueno de intersects es que devuelve true al momento que se produce, sin tener que terminar de recorrer todo el array
                return true;
            }

        }








 return false;
 


    }

    private boolean colisIzq(int velocX) {


for (int i = 0; i < ObjetosEstaticos.mt.areasColisionActualizar.size(); i++) {

            final Rectangle zonas = ObjetosEstaticos.mt.areasColisionActualizar.get(i);

            int origenX = zonas.x + velocX * (int) veloc + 3 * (int) veloc;;
            int origenY = zonas.y;

            final Rectangle zonaFut = new Rectangle(origenX, origenY, zonas.width, zonas.height);

            if (LIMITE_IZQUIERDA.intersects(zonaFut)) {  //lo bueno de intersects es que devuelve true al momento que se produce, sin tener que terminar de recorrer todo el array
                return true;
            }

        }

     







        return false;
    }

    
    private boolean colisDer(int velocX) {


for (int i = 0; i < ObjetosEstaticos.mt.areasColisionActualizar.size(); i++) {

            final Rectangle zonas = ObjetosEstaticos.mt.areasColisionActualizar.get(i);

            int origenX = zonas.x + velocX * (int) veloc - 3 * (int) veloc;
            int origenY = zonas.y;

            final Rectangle zonaFut = new Rectangle(origenX, origenY, zonas.width, zonas.height);

            if (LIMITE_DERECHA.intersects(zonaFut)) {  //lo bueno de intersects es que devuelve true al momento que se produce, sin tener que terminar de recorrer todo el array
                return true;
            }

        }
     







        return false;
    }

    
    
    private void DireccionesParaElDibujadoPersonaje(final int MovX, final int MovY) {  //se llama dentro del metodo movimientos colisiones tecla correr.  //2 PASO 
                                                                                            // uso de la variable direccion

        if (MovX == 1) {    //si caminamos hacia la derecha
            direccion = 2;  //direccion mirando hacia la derecha de nuestro personaje en la hoja del personaje
        } else if (MovX == -1) { //caminando hacia la izquierda
            direccion = 3;    //direccion mirando izquierda

        }

        
        
        if (MovY == -1) {  //si nos movemos hacia arriba
            direccion = 1;     //direccion hacia arriba de nuestro personaje en la hoja del personjae
        } else if (MovY == 1) { //si nos movemos hacia abajo
            direccion = 0;   //direccion hacia abajo de nuestro personaje en la hoja del personaje
        }
        
        
        
        
    }

    private int MovimientoPersonajeEjeX() {//a  //para moverse izquierda o derecha
      
        int MovimientoX = 0;  //-1 izq //1 movem derecha //0 no nos movemos

        if (ObjetosEstaticos.teclado.izquierda.getIsPulsed() && !ObjetosEstaticos.teclado.derecha.getIsPulsed()) {
            MovimientoX = -1;
        } else if (ObjetosEstaticos.teclado.derecha.getIsPulsed() && !ObjetosEstaticos.teclado.izquierda.getIsPulsed()) {
            MovimientoX = 1;

        }

        return MovimientoX;
    }

    private int MovimientoPersonajeEjeY() {//b

        int MovimientoY = 0;

        if (ObjetosEstaticos.teclado.arriba.getIsPulsed() && !ObjetosEstaticos.teclado.abajo.getIsPulsed()) {
            MovimientoY = -1;
        } else if (ObjetosEstaticos.teclado.abajo.getIsPulsed() && !ObjetosEstaticos.teclado.arriba.getIsPulsed()) {
            MovimientoY = 1;
        }

        return MovimientoY;

    }

    private void DibujadoDeAnimacionesPersonaje() {   //uso de la variable estados   //5 paso
      
        if (!enMov) {    //tiene que estar quieto por defecto, no tiene que estar en movimiento
          
            estadoss = 0;       //esta en estado sin movimiento, hasta que yo lo mueva //si lo sacamos, se estara moviendo
           // animacion = 0;

        }
                                      //x         y
        imagenActual = hs.getSprite(direccion,estadoss).getImagen();   //usamos el metodo de posiciones, no el indice de hoja de sprites. con x medimos las direcciones donde mira y con y las animaciones


        
        
        
    }

    
     public Rectangle getAreaPersonaje(){
     
        final int puntoX = (int) posX // * Constantes.LADO_SPRITE
               + Constantes.MARGEN_X;
        
       //  System.out.println("estoy aqui");
        
        
      final int puntoY = (int) posY //* Constantes.LADO_SPRITE
              + Constantes.MARGEN_Y;
        
      
      
      
       //  System.out.println("personaje"+puntoX);
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
      
      
    }
     
      public Rectangle getAreaPersonaje2(){
     
        final int puntoX = (int) posX - obtenIntPosicX()// * Constantes.LADO_SPRITE
               + Constantes.MARGEN_X;
        
       //  System.out.println("estoy aqui");
        
        
      final int puntoY = (int) posY - obtenIntPosicY()//* Constantes.LADO_SPRITE
              + Constantes.MARGEN_Y;
        
      
      
      
       //  System.out.println("personaje"+puntoX);
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
      
      
    }
     
     
     public ArrayList<Rectangle> getAlcancePersona(){
         
         
          Rectangle r= getAreaPersonaje();
     
  
           
            alcanceActualPersonaje=  new ArrayList();
            
            
       
       
       
            alcanceActualPersonaje.add(r);
            
          
            
            
            
            
            
            return alcanceActualPersonaje;
         
         
         
         
         
     }
     
     
     
     
    

    
    public  Rectangle getLIMITE_ARRIBA(){
        return LIMITE_ARRIBA;
    }
    
      public Rectangle getLimite_abajo(){
        return LIMITE_ABAJO;
    }
    
      
        public Rectangle getLimite_izquierda(){
        return LIMITE_IZQUIERDA;
    }
    
        
          public Rectangle getLimite_derecha(){
        return LIMITE_DERECHA;
    }
    
    
    
    
    public int getStamina(){
        return stamina;
    }
    
    public ArrayList <Rectangle> getAlcanceAtaquePersonaje(){
        return alcanceAtaquePersonaje;
    }

    public int getVidaMax(){
        return vidaMax;
    }
    
public  void setVidaMax(int vida){
    
    this.vidaMax=vida;
}
    

    public Point getPosicion(){
        return new Point (  obtenIntPosicX(), obtenIntPosicY());
    }
        
    public int  obtenIntPosicX(){
        return (int) posX;
    }
    
      
    public int  obtenIntPosicY(){
        return (int) posY;
    }
    
    
    public void setIntPosicX(double posX){
        
       this.posX=(int)posX;
    }
    
       public void setIntPosicY(double posY){
        
       this.posY=(int)posY;
    }
    
    public int getAncho(){
        return ANCHO_JUGADOR;
    }
    
    
       public int getAlto(){
        return ALTO_JUGADOR;
    }
    


    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

}
