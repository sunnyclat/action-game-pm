<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import IA.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import principal.Constantes;
import principal.ObjetosEstaticos;
import HERRAMIENTAS.CalculadoraDistancia;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

import Personajes.Personaje;
import SONID.Audio;
import SPRITES.HojaSprites;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author samuel ludueña 2021
 */
public class Enemigos {
    
    private Audio quejaEnemigo;
     private Audio quejaMuerteEnemigo;
     
public Audio sonidoAtaque;
    
    private long duracQueja;
    private long quejaSig=0;
    
    private int idEnemigo;
    
    
    private double posicX;
    private double posicY;
    
    
    private String nombre;
    private int vidaMax;
    private float vidaAct;
    
    
    private Nodo sigNodo;
    
    Zombie zombie;
    
        protected int actualizSigAtaqueEnemigo; 
     protected double ataquesPorSegundo;
     
       protected int minAtaque;
    protected int maxAtaque;
    
    

     private Point posicion;


    private boolean enMov;
      
    public static int direccion;
             
    protected int animacion;

    public static int estados;
        
         private ArrayList<Rectangle> alcanceAtaqueEnemigo;
         
          private ArrayList<Rectangle> alcanceEnemigo;
        
                protected static HojaSprites hojaZombie;
                  protected static HojaSprites hojaJefe1;

    protected BufferedImage imagenActual;
     protected BufferedImage imagenActual2;
    
Personaje persona;

    Rectangle ab;
     Rectangle i;
     Rectangle ar;
      Rectangle der;
      
      
    public Enemigos(final int idEnemigo, final String nombre, final int vidaMax, final String quejaRuta, final String muerteRuta,int ataqueMin,int ataqueMax,double ataquexSegundo,final String rutaSonidoAtaque){
  

        
        this.actualizSigAtaqueEnemigo=0; 
  this.ataquesPorSegundo=ataquexSegundo;
     
       this.minAtaque=ataqueMin;
    this.maxAtaque=ataqueMax;
        
         
        
        
        this.idEnemigo=idEnemigo;
        
        this.posicX=0;
                
        this.posicY=0;
        
        
        this.nombre= nombre;
        
        this.vidaMax= vidaMax;
        this.vidaAct= vidaMax;
        
        
         enMov = false;
        
         direccion=0;
    
    
      animacion=0;
    
    
    estados=0;
        
       
                   this.quejaEnemigo = new Audio (quejaRuta);
                 
                     this.sonidoAtaque= new Audio (rutaSonidoAtaque);
               
                   
        this.duracQueja= quejaEnemigo.obtieneDuracion();
          
        
        this.quejaMuerteEnemigo= new Audio (muerteRuta);

alcanceAtaqueEnemigo=  new ArrayList();
  alcanceEnemigo=  new ArrayList();
        
    //    hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );
        
     //   imagenActual= hojaZombie.getSprite(0).getImagen();
        



    }
    
    
    
     public void ataqueAlPersonaje(final Personaje persona ){
       
           
           float ataqueActual = minAtaque;
           
                      
      
            
      
            
                   
                     sonidoAtaque.reproduceSonido();
          
                   
                 persona.perdidaVidaPersonajee(ataqueActual);
            
               }
           
 
               
               
           
           
           
            
            
        
     
     
         

 
    
    public void perdidaVidaDelEnemigoo(float ataqueRecibido){
        //gestiono sonido de queja del enemigo
        
      
        
        
        
        //ataques recibidos y perdida de vida
        if(vidaAct - ataqueRecibido < 0){
            
        
                
                   vidaAct = 0;  //el enemigo ha muerto
                     
            
      
         
        }else{
            
            
            vidaAct -= ataqueRecibido; //le restamos la vida con el ataque recibido
            
        
            
            if(vidaAct ==0){
              
                quejaMuerteEnemigo.reproduceSonido();
                
            }
            
            
 
        /*    
            if(vidaAct >0)
             if(quejaSig <=0  ){
            
            quejaEnemigo.reproduceSonido();
            quejaSig = duracQueja;
            
            
            
        }
    */        
            
            
             if(quejaSig <=0  ){
            
            quejaEnemigo.reproduceSonido();
            quejaSig = duracQueja;
            
            
            
        } 
            
            
            
            
            
            
            
            
            
        }
        
        
         
        
        
        
        
    }
    
    
    
    
    
    public void movimientos(){
        
        if (animacion < 50) {   
            animacion++; 
      
        } else {
            animacion = 0; 
        }

        
        
        if (animacion < 40) {  
         
            estados = 1;  
        } else {
            estados = 2;
        }
        
        
        
        
        
    }
    
    
       public void movimientos2(){
        
        if (animacion < 200) {   
            animacion++; 
      
        } else {
            animacion = 0; 
        }

        
        
        if (animacion < 80) {  
         
            estados = 1;  
        } else {
            estados = 2;
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
 
    
    
    
  
    
    
    
    
    
    
    
    
    public void actualizarr(ArrayList <Enemigos> enemigos){
        
        if(quejaSig > 0){
            
            
            quejaSig -= 1000000 / 60; //asi no dura mucho tiempo el lamento
            
            
        }
        
        
        
        moverSigNodo(enemigos);
        

        
        
        
    }
    
    
    private void moverSigNodo(ArrayList <Enemigos> enemigos){
   

        
        
        
        
        if(sigNodo == null){
            
            
            return;
        }
        
      
        

        
        
        
        //Gestionar atascos
        for(Enemigos enemigo : enemigos){             //vamos a comparar la posicion del enemigo con la posicion de otro enemigo
            
            if(enemigo.getAreaEnemigo().equals(this.getAreaEnemigo())){  //vemos si es el mismo enemigo
             
            continue;             //el enemigo es el mismo asi que salimos fuera
            
        }
            
            
            if(enemigo.getAreaEnemigo().intersects(sigNodo.obtieneAreaPixeles())){// si uno o varios enemigos estan en el siguiente nodo,entonces el zombie actual no seguira por el mismo lugar
                
                
                continue;
            }
        
        }
        
        
        
        
        
        
        double velocidad = 0.5;  // 0.5 anda, con 1 se te va al humo // con 2 se aleja
        
        
        int xSigNodo = sigNodo.getPosicion().x * Constantes.LADO_SPRITE; //tenemos que averiguar su posicion en pixeles en este caso
        int ySigNodo  = sigNodo.getPosicion().y * Constantes.LADO_SPRITE;
        
        
        
  


        
        if( (posicX < xSigNodo)){ // se mueve a la derecha
            
           posicX += velocidad;
     


        

  

    
      direccion=2;

            
            
        }
        
       
        
        
        if((posicX > xSigNodo)){//izquierda
            
            posicX -= velocidad;
        

  direccion= 3;

            
        }
        
          

        
        
        
        if(posicY < ySigNodo){//abajo
            
            posicY += velocidad;
               
            

      
      
      
       
       
       
            
      direccion= 0;
       
       
            
        }

        
          
        if(posicY > ySigNodo){//arriba
            
            posicY -= velocidad;
        
            


      
      
      
  
       
             direccion= 1;
       
        }
     
        
        



  
    
    

        
        
        
        
        
    }
    
    
    public void setSigNodo(Nodo nodo){
        
        //
        sigNodo= nodo;
        
        
        
        
    }
    

    
    
    public Nodo getSigNodo(){
        
     return sigNodo;
        
        
        
        
    }
    
    
    
    public void dibujarr(final Graphics g, final int puntoX, final int puntoY){
        
        if(vidaAct <= 0){
            
            return;
        }
        
        
           g.setColor(Color.green); 
      
           
           dibujarBarraVida(g,puntoX,puntoY);                                    //barra vida del enemigo
        
       g.setColor(Color.orange); 
     //     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());  //dibuja el recuadro del enemigo. en este metodo restamos al personaje
                                                                                         //con ancho y alto de lado sprite, dibuja todo el contorno del personaje
       // dibujaDistancia(g,puntoX,puntoY);                                   //dibuja la distancia del enemigo
        
        
  
//   DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());
 
 // hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );//1
  
   
  

  

//movimientos();


    


         
               
    //    imagenActual = hojaZombie.getSprite(direccion,estados).getImagen();
         
   //      DibujadorRectangulosImagenes.dibujImagen(g, imagenActual, puntoX, puntoY);
    
    

    
   
       if(!(alcanceAtaqueEnemigo.isEmpty()) ){  //dibujamos linea roja de apuntado
   
     g.setColor(Color.blue);
     DibujaAlcanceEnemigo(g);
  
  
  
 }

    
    
    
        
    }
    
    
       private void DibujaAlcanceEnemigo( final Graphics g){  //creamos el rectangulo de alcance
        

        DibujadorRectangulosImagenes.dibujarRectanguloVacio(g,getAlcanceEnemigoo().get(0)); //ponemos 0 ya que no hay otro rectangulo en el arraylist
        
         
    }
    
    
    
    
    
    
    
    
    
    
    //aca le pega el tiro, le restamos posicion persona         //este metodo lo usamos para herir al enemigo
    public Rectangle getAreaEnemigo2(){  //nunca multiplicar por el ancho en pixeles usando tiled
     
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      
      
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
      
      
    }
    
    public Rectangle getAreaEnemigo(){ //no resta posicion persona. asi puede impactar tiro
        
        final int puntoX = (int) posicX //- ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      
      
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
        
    }
    
    
        public Rectangle getAreaEnemigo3(){ //no resta la posicion persona. puede impactar tiro //metodo enemigo ataca al personaje
        
        final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      Rectangle r= new Rectangle();
     
        return new Rectangle(puntoX , puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
    }
        
       public Rectangle getAreaEnemigo3b(){ //no resta la posicion persona. puede impactar tiro  // con esto el enemigo detecta a nuestro personaje en su rango
        
        final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia abajo
     i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia arriba
     der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la derecha
  
      
           //enemigo con esto daña a mucha distancia
     
           /*
           r.x=puntoX;
      r.y=puntoY;
      r.width=200;
      r.height=200;
      */
      
      
     // return r;
      //  return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
        
     //   return new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);
     
     
      if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
     
     
     
     
    } 
        
     
       
       
       
        public Rectangle getAreaEnemigo3c(){
            
             final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia abajo
     i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia arriba
     der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la derecha
  
      
           //enemigo con esto daña a mucha distancia
     
           /*
           r.x=puntoX;
      r.y=puntoY;
      r.width=200;
      r.height=200;
      */
      
      
     // return r;
      //  return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
        
     //   return new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);
     
     
      if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
          
         
         
         
         
        }
        
        
        
        
        public void setAb(Rectangle ab){
          
            
            this.ab=ab;
            
        }
        
           
        public void setAr(Rectangle ar){
            
                 this.ar=ar;
            
            
        }
        
        
           
        public void setI(Rectangle i){
            
            
                 this.i=i;
            
        }
        
        
           
        public void setDer(Rectangle der){
            
            
            
                 this.der=der;
        }
        
    
        
       //mientras se reste al personaje, el enemigo no podra dañarme. pero siempre yo puedo dañar al enemigo
        // tampoco reacciona el enemigo mientras se reste al personaje.
        
        
        
         public Rectangle getAreaEnemigo4(){ //si resta //puede impactar tiro pero enemigo no daña personaje    //con esto visualizamos el area del enemigo
        
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      Rectangle ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia abajo
      Rectangle i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la izquierda
         Rectangle ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia arriba
      Rectangle der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la derecha
      /*
      r.x=puntoX;
      r.y=puntoY;
      r.width=20;
      r.height=20;
      */
     //       return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
      
     
  
     if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
        
        
    }
        
         public Rectangle getAreaEnemigo4b(){ //si resta //puede impactar tiro pero enemigo no daña personaje    //con esto visualizamos el area del enemigo
        
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
        
      ab= new Rectangle(puntoX - 100   , puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia abajo
     i=new Rectangle(puntoX - 100   ,  puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 100   ,  puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia arriba
     der=new Rectangle(puntoX - 100   ,puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la derecha

     
  
     if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
        
        
    } 
    
        
     public ArrayList<Rectangle> getAtaqueEnemigo(){
         
         
          Rectangle r= getAreaEnemigo();
     
  
           
            alcanceAtaqueEnemigo=  new ArrayList();
            
        /*    
       final Rectangle alcance_1= new Rectangle();
        
        final int SpritesAlcanc= 5;
       */
       
            alcanceAtaqueEnemigo.add(r);
            
          
            
            
            
            
            
            return alcanceAtaqueEnemigo;
         
         
         
         
         
     }
     
     
     
     
     
      public ArrayList<Rectangle> getAlcanceEnemigoo(){
              
       
          Rectangle rr= getAreaEnemigo4();
          
          
      
         

        

            

     
       
            alcanceEnemigo.add(rr);
            
          
            
            
            
            
            
            return alcanceEnemigo;
         
         
         
         
         
     }
     
    
    
    public void dibujarBarraVida(final Graphics g, final int puntoX, final int puntoY){
        
        g.setColor(Color.green);
        
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntoX, puntoY - 5, Constantes.LADO_SPRITE * (int) vidaAct / vidaMax, 2);
        
     //   dibujaDistancia(g,puntoX,puntoY);
        
        
    }
    
    
    
    
    private void dibujaDistancia(final Graphics g, final int puntoX, final int puntoY){
        
        Point puntoPersonaje = new Point(
        ObjetosEstaticos.persona.obtenIntPosicX() / Constantes.LADO_SPRITE, 
        ObjetosEstaticos.persona.obtenIntPosicY() / Constantes.LADO_SPRITE);
        
    
     //   System.out.println(ElementosPrincipales.persona.getPosicion().toString());
        
        
        
        
        
        
        
        
        
        
        
        
            Point puntoEnemigo= new Point ( (int) posicY, (int)posicY );
        
    
            Double distancia= CalculadoraDistancia.getDistanciaPuntos(puntoPersonaje, puntoEnemigo);
        
        
        DibujadorRectangulosImagenes.dibujString(g, String.format("%.2f", distancia), puntoX, puntoY - 8);  //dibujamos el numero de la distancia con respecto al jugador
        
    }
    
     //   private void DibujaRectanguloAlcanceEnemigo( final Graphics g){  //creamos el rectangulo de alcance
        

      //  DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, getAlcanceEnemies().get(0)); //ponemos 0 ya que no hay otro rectangulo en el arraylist
        
        
  //  }
     
    
    
        
    
    
    
    
    public void setPosicion(final double posicX, final double posicY){
        
        
        this.posicX = posicX;
        this.posicY = posicY;
        
        
        
        
        
        
        
    }
    
    public Rectangle obtieneAreaPosicion(){
        
        return new Rectangle((int) posicX,(int) posicY,32,32);
        

        
        
        
       // return new Rectangle(,1,32,32);
    }
    
    
    /*
        public ArrayList <Rectangle> getAlcanceActualEnemigo(){
      
            
            
           Rectangle r= obtieneAreaPosicion();
     
 // Rectangle r= getAreaEnemigoAtaque();
           
            alcanceActualEnemigo=  new ArrayList();
            
            
       
       
       
            alcanceActualEnemigo.add(r);
            
            
        //    System.out.println(alcanceActualEnemigo);
            
            
            
            return alcanceActualEnemigo;
    }

  */  
    
    public double getPosicX(){
        return posicX;
    }
    
    
      public double getPosicY(){
        return posicY;
    }
    
    
    
    public int getIdEnemigo(){
        return idEnemigo;
    }
    
    public float getVidaActual(){
        
        return vidaAct;
    }
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import IA.Nodo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import principal.Constantes;
import principal.ObjetosEstaticos;
import HERRAMIENTAS.CalculadoraDistancia;
import HERRAMIENTAS.DibujadorRectangulosImagenes;

import Personajes.Personaje;
import SONID.Audio;
import SPRITES.HojaSprites;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author samuel ludueña 2021
 */
public class Enemigos {
    
    private Audio quejaEnemigo;
     private Audio quejaMuerteEnemigo;
     
public Audio sonidoAtaque;
    
    private long duracQueja;
    private long quejaSig=0;
    
    private int idEnemigo;
    
    
    private double posicX;
    private double posicY;
    
    
    private String nombre;
    private int vidaMax;
    private float vidaAct;
    
    
    private Nodo sigNodo;
    
    Zombie zombie;
    
        protected int actualizSigAtaqueEnemigo; 
     protected double ataquesPorSegundo;
     
       protected int minAtaque;
    protected int maxAtaque;
    
    

     private Point posicion;


    private boolean enMov;
      
    public static int direccion;
             
    protected int animacion;

    public static int estados;
        
         private ArrayList<Rectangle> alcanceAtaqueEnemigo;
         
          private ArrayList<Rectangle> alcanceEnemigo;
        
                protected static HojaSprites hojaZombie;

    protected BufferedImage imagenActual;
    
Personaje persona;

    Rectangle ab;
     Rectangle i;
     Rectangle ar;
      Rectangle der;
      
      
    public Enemigos(final int idEnemigo, final String nombre, final int vidaMax, final String quejaRuta, final String muerteRuta,int ataqueMin,int ataqueMax,double ataquexSegundo,final String rutaSonidoAtaque){
  

        
        this.actualizSigAtaqueEnemigo=0; 
  this.ataquesPorSegundo=ataquexSegundo;
     
       this.minAtaque=ataqueMin;
    this.maxAtaque=ataqueMax;
        
         
        
        
        this.idEnemigo=idEnemigo;
        
        this.posicX=0;
                
        this.posicY=0;
        
        
        this.nombre= nombre;
        
        this.vidaMax= vidaMax;
        this.vidaAct= vidaMax;
        
        
         enMov = false;
        
         direccion=0;
    
    
      animacion=0;
    
    
    estados=0;
        
       
                   this.quejaEnemigo = new Audio (quejaRuta);
                 
                     this.sonidoAtaque= new Audio (rutaSonidoAtaque);
               
                   
        this.duracQueja= quejaEnemigo.obtieneDuracion();
          
        
        this.quejaMuerteEnemigo= new Audio (muerteRuta);

alcanceAtaqueEnemigo=  new ArrayList();
  alcanceEnemigo=  new ArrayList();
        
    //    hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );
        
     //   imagenActual= hojaZombie.getSprite(0).getImagen();
        



    }
    
    
    
     public void ataqueAlPersonaje(final Personaje persona ){
       
           
           float ataqueActual = minAtaque;
           
                      
      
            
      
            
                   
                     sonidoAtaque.reproduceSonido();
          
                   
                 persona.perdidaVidaPersonajee(ataqueActual);
            
               }
           
 
               
               
           
           
           
            
            
        
     
     
         

 
    
    public void perdidaVidaDelEnemigoo(float ataqueRecibido){
        //gestiono sonido de queja del enemigo
        
      
        
        
        
        //ataques recibidos y perdida de vida
        if(vidaAct - ataqueRecibido < 0){
            
        
                
                   vidaAct = 0;  //el enemigo ha muerto
                     
            
      
         
        }else{
            
            
            vidaAct -= ataqueRecibido; //le restamos la vida con el ataque recibido
            
        
            
            if(vidaAct ==0){
              
                quejaMuerteEnemigo.reproduceSonido();
                
            }
            
            
 
        /*    
            if(vidaAct >0)
             if(quejaSig <=0  ){
            
            quejaEnemigo.reproduceSonido();
            quejaSig = duracQueja;
            
            
            
        }
    */        
            
            
             if(quejaSig <=0  ){
            
            quejaEnemigo.reproduceSonido();
            quejaSig = duracQueja;
            
            
            
        } 
            
            
            
            
            
            
            
            
            
        }
        
        
         
        
        
        
        
    }
    
    
    
    
    
    public void movimientos(){
        
        if (animacion < 50) {   
            animacion++; 
      
        } else {
            animacion = 0; 
        }

        
        
        if (animacion < 40) {  
         
            estados = 1;  
        } else {
            estados = 2;
        }
        
        
        
        
        
    }
    
    
       public void movimientos2(){
        
        if (animacion < 200) {   
            animacion++; 
      
        } else {
            animacion = 0; 
        }

        
        
        if (animacion < 80) {  
         
            estados = 1;  
        } else {
            estados = 2;
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
 
    
    
    
  
    
    
    
    
    
    
    
    
    public void actualizarr(ArrayList <Enemigos> enemigos){
        
        if(quejaSig > 0){
            
            
            quejaSig -= 1000000 / 60; //asi no dura mucho tiempo el lamento
            
            
        }
        
        
        
        moverSigNodo(enemigos);
        

        
        
        
    }
    
    
    private void moverSigNodo(ArrayList <Enemigos> enemigos){
   

        
        
        
        
        if(sigNodo == null){
            
            
            return;
        }
        
      
        

        
        
        
        //Gestionar atascos
        for(Enemigos enemigo : enemigos){             //vamos a comparar la posicion del enemigo con la posicion de otro enemigo
            
            if(enemigo.getAreaEnemigo().equals(this.getAreaEnemigo())){  //vemos si es el mismo enemigo
             
            continue;             //el enemigo es el mismo asi que salimos fuera
            
        }
            
            
            if(enemigo.getAreaEnemigo().intersects(sigNodo.obtieneAreaPixeles())){// si uno o varios enemigos estan en el siguiente nodo,entonces el zombie actual no seguira por el mismo lugar
                
                
                continue;
            }
        
        }
        
        
        
        
        
        
        double velocidad = 0.5;  // 0.5 anda, con 1 se te va al humo // con 2 se aleja
        
        
        int xSigNodo = sigNodo.getPosicion().x * Constantes.LADO_SPRITE; //tenemos que averiguar su posicion en pixeles en este caso
        int ySigNodo  = sigNodo.getPosicion().y * Constantes.LADO_SPRITE;
        
        
        
  


        
        if( (posicX < xSigNodo)){ // se mueve a la derecha
            
           posicX += velocidad;
     


        

  

    
      direccion=2;

            
            
        }
        
       
        
        
        if((posicX > xSigNodo)){//izquierda
            
            posicX -= velocidad;
        

  direccion= 3;

            
        }
        
          

        
        
        
        if(posicY < ySigNodo){//abajo
            
            posicY += velocidad;
               
            

      
      
      
       
       
       
            
      direccion= 0;
       
       
            
        }

        
          
        if(posicY > ySigNodo){//arriba
            
            posicY -= velocidad;
        
            


      
      
      
  
       
             direccion= 1;
       
        }
     
        
        



  
    
    

        
        
        
        
        
    }
    
    
    public void setSigNodo(Nodo nodo){
        
        //
        sigNodo= nodo;
        
        
        
        
    }
    

    
    
    public Nodo getSigNodo(){
        
     return sigNodo;
        
        
        
        
    }
    
    
    
    public void dibujarr(final Graphics g, final int puntoX, final int puntoY){
        
        if(vidaAct <= 0){
            
            return;
        }
        
        
           g.setColor(Color.green); 
      
           
           dibujarBarraVida(g,puntoX,puntoY);                                    //barra vida del enemigo
        
       g.setColor(Color.orange); 
     //     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());  //dibuja el recuadro del enemigo. en este metodo restamos al personaje
                                                                                         //con ancho y alto de lado sprite, dibuja todo el contorno del personaje
       // dibujaDistancia(g,puntoX,puntoY);                                   //dibuja la distancia del enemigo
        
        
  
//   DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, getAreaEnemigo4());
 
 // hojaZombie = new HojaSprites (Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false );//1
  
   
  

  

//movimientos();


    


         
               
    //    imagenActual = hojaZombie.getSprite(direccion,estados).getImagen();
         
   //      DibujadorRectangulosImagenes.dibujImagen(g, imagenActual, puntoX, puntoY);
    
    

    
   
       if(!(alcanceAtaqueEnemigo.isEmpty()) ){  //dibujamos linea roja de apuntado
   
     g.setColor(Color.blue);
     DibujaAlcanceEnemigo(g);
  
  
  
 }

    
    
    
        
    }
    
    
       private void DibujaAlcanceEnemigo( final Graphics g){  //creamos el rectangulo de alcance
        

        DibujadorRectangulosImagenes.dibujarRectanguloVacio(g,getAlcanceEnemigoo().get(0)); //ponemos 0 ya que no hay otro rectangulo en el arraylist
        
         
    }
    
    
    
    
    
    
    
    
    
    
    //aca le pega el tiro, le restamos posicion persona         //este metodo lo usamos para herir al enemigo
    public Rectangle getAreaEnemigo2(){  //nunca multiplicar por el ancho en pixeles usando tiled
     
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      
      
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
      
      
    }
    
    public Rectangle getAreaEnemigo(){ //no resta posicion persona. asi puede impactar tiro
        
        final int puntoX = (int) posicX //- ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      
      
      
      
      return new Rectangle(puntoX, puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
        
    }
    
    
        public Rectangle getAreaEnemigo3(){ //no resta la posicion persona. puede impactar tiro //metodo enemigo ataca al personaje
        
        final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      Rectangle r= new Rectangle();
     
        return new Rectangle(puntoX , puntoY,Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
    }
        
       public Rectangle getAreaEnemigo3b(){ //no resta la posicion persona. puede impactar tiro  // con esto el enemigo detecta a nuestro personaje en su rango
        
        final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia abajo
     i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia arriba
     der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la derecha
  
      
           //enemigo con esto daña a mucha distancia
     
           /*
           r.x=puntoX;
      r.y=puntoY;
      r.width=200;
      r.height=200;
      */
      
      
     // return r;
      //  return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
        
     //   return new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);
     
     
      if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
     
     
     
     
    } 
        
     
       
       
       
        public Rectangle getAreaEnemigo3c(){
            
             final int puntoX = (int) posicX //- InstanciasImportantes.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY //-  InstanciasImportantes.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia abajo
     i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia arriba
     der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la derecha
  
      
           //enemigo con esto daña a mucha distancia
     
           /*
           r.x=puntoX;
      r.y=puntoY;
      r.width=200;
      r.height=200;
      */
      
      
     // return r;
      //  return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
        
     //   return new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);
     
     
      if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
          
         
         
         
         
        }
        
        
        
        
        public void setAb(Rectangle ab){
          
            
            this.ab=ab;
            
        }
        
           
        public void setAr(Rectangle ar){
            
                 this.ar=ar;
            
            
        }
        
        
           
        public void setI(Rectangle i){
            
            
                 this.i=i;
            
        }
        
        
           
        public void setDer(Rectangle der){
            
            
            
                 this.der=der;
        }
        
    
        
       //mientras se reste al personaje, el enemigo no podra dañarme. pero siempre yo puedo dañar al enemigo
        // tampoco reacciona el enemigo mientras se reste al personaje.
        
        
        
         public Rectangle getAreaEnemigo4(){ //si resta //puede impactar tiro pero enemigo no daña personaje    //con esto visualizamos el area del enemigo
        
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
      
      Rectangle ab= new Rectangle(puntoX - 16   , puntoY - 16 + 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia abajo
      Rectangle i=new Rectangle(puntoX - 40   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la izquierda
         Rectangle ar= new Rectangle(puntoX - 20   , puntoY - 16 - 30 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2);  //mira hacia arriba
      Rectangle der=new Rectangle(puntoX + 20   , puntoY - 16 + 30 - 20 ,Constantes.LADO_SPRITE  * 2, Constantes.LADO_SPRITE * 2); //mira hacia la derecha
      /*
      r.x=puntoX;
      r.y=puntoY;
      r.width=20;
      r.height=20;
      */
     //       return new Rectangle(puntoX - Constantes.LADO_SPRITE + 20, puntoY - Constantes.LADO_SPRITE + 20,Constantes.LADO_SPRITE + 30, Constantes.LADO_SPRITE + 30);  //el enemigo esta en el medio del cuadrado
      
     
  
     if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
        
        
    }
        
         public Rectangle getAreaEnemigo4b(){ //si resta //puede impactar tiro pero enemigo no daña personaje    //con esto visualizamos el area del enemigo
        
        final int puntoX = (int) posicX - ObjetosEstaticos.persona.obtenIntPosicX() 
                + Constantes.MARGEN_X;
        
     //   System.out.println("posicion enemigo" + puntoX);
        
        
      final int puntoY = (int) posicY -  ObjetosEstaticos.persona.obtenIntPosicY()
              + Constantes.MARGEN_Y;
        
             
      
        
      ab= new Rectangle(puntoX - 100   , puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia abajo
     i=new Rectangle(puntoX - 100   ,  puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la izquierda
         ar= new Rectangle(puntoX - 100   ,  puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8);  //mira hacia arriba
     der=new Rectangle(puntoX - 100   ,puntoY - 100 + 10 ,Constantes.LADO_SPRITE  * 8, Constantes.LADO_SPRITE * 8); //mira hacia la derecha

     
  
     if(direccion == 0){  
     return ab; 
   
     }else    if (direccion ==3){
        return i; 
     
         
         }else if(direccion == 1) {
     return ar; 
   
         } if (direccion ==2){
        return der; 
        
         }else{
             return null;
         }
        
        
    } 
    
        
     public ArrayList<Rectangle> getAtaqueEnemigo(){
         
         
          Rectangle r= getAreaEnemigo();
     
  
           
            alcanceAtaqueEnemigo=  new ArrayList();
            
        /*    
       final Rectangle alcance_1= new Rectangle();
        
        final int SpritesAlcanc= 5;
       */
       
            alcanceAtaqueEnemigo.add(r);
            
          
            
            
            
            
            
            return alcanceAtaqueEnemigo;
         
         
         
         
         
     }
     
     
     
     
     
      public ArrayList<Rectangle> getAlcanceEnemigoo(){
              
       
          Rectangle rr= getAreaEnemigo4();
          
          
      
         

        

            

     
       
            alcanceEnemigo.add(rr);
            
          
            
            
            
            
            
            return alcanceEnemigo;
         
         
         
         
         
     }
     
    
    
    public void dibujarBarraVida(final Graphics g, final int puntoX, final int puntoY){
        
        g.setColor(Color.green);
        
        
        DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, puntoX, puntoY - 5, Constantes.LADO_SPRITE * (int) vidaAct / vidaMax, 2);
        
     //   dibujaDistancia(g,puntoX,puntoY);
        
        
    }
    
    
    
    
    private void dibujaDistancia(final Graphics g, final int puntoX, final int puntoY){
        
        Point puntoPersonaje = new Point(
        ObjetosEstaticos.persona.obtenIntPosicX() / Constantes.LADO_SPRITE, 
        ObjetosEstaticos.persona.obtenIntPosicY() / Constantes.LADO_SPRITE);
        
    
     //   System.out.println(ElementosPrincipales.persona.getPosicion().toString());
        
        
        
        
        
        
        
        
        
        
        
        
            Point puntoEnemigo= new Point ( (int) posicY, (int)posicY );
        
    
            Double distancia= CalculadoraDistancia.getDistanciaPuntos(puntoPersonaje, puntoEnemigo);
        
        
        DibujadorRectangulosImagenes.dibujString(g, String.format("%.2f", distancia), puntoX, puntoY - 8);  //dibujamos el numero de la distancia con respecto al jugador
        
    }
    
     //   private void DibujaRectanguloAlcanceEnemigo( final Graphics g){  //creamos el rectangulo de alcance
        

      //  DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, getAlcanceEnemies().get(0)); //ponemos 0 ya que no hay otro rectangulo en el arraylist
        
        
  //  }
     
    
    
        
    
    
    
    
    public void setPosicion(final double posicX, final double posicY){
        
        
        this.posicX = posicX;
        this.posicY = posicY;
        
        
        
        
        
        
        
    }
    
    public Rectangle obtieneAreaPosicion(){
        
        return new Rectangle((int) posicX,(int) posicY,32,32);
        

        
        
        
       // return new Rectangle(,1,32,32);
    }
    
    
    /*
        public ArrayList <Rectangle> getAlcanceActualEnemigo(){
      
            
            
           Rectangle r= obtieneAreaPosicion();
     
 // Rectangle r= getAreaEnemigoAtaque();
           
            alcanceActualEnemigo=  new ArrayList();
            
            
       
       
       
            alcanceActualEnemigo.add(r);
            
            
        //    System.out.println(alcanceActualEnemigo);
            
            
            
            return alcanceActualEnemigo;
    }

  */  
    
    public double getPosicX(){
        return posicX;
    }
    
    
      public double getPosicY(){
        return posicY;
    }
    
    
    
    public int getIdEnemigo(){
        return idEnemigo;
    }
    
    public float getVidaActual(){
        
        return vidaAct;
    }
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
