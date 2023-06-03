<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR_MAPA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import principal.Constantes;
import principal.ObjetosEstaticos;

import Enemigos.EnemigosDelJuego;
import Enemigos.Enemigos;
import ITEMSYARMAS.ItemsDelPiso;
import PERIFERICOS.Teclado;
import SPRITES.HojaSprites;
import SPRITES.Sprite;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;


/**
 *
 * @author samuel ludueña 2021
 */
public class GestorMapa {

    private String[] partes; //se guardaran las partes de texto leidas del archivo, dividiendo colisiones, de paleta, de dibujado de sprites,etc

    private final int ancho;
    private final int alto;

    public final Point posicInic;

    public final Point posicSalida;

   public Rectangle zonaSalida;

    public String sigMap;

    private final Sprite[] paleta; //es un array de sprites llamado paleta, el cual contendra los sprites junto a su hoja y posicion del array.(los primero que escribimos en la hoja que contendra piedra,asfalto,arena,etc)
    //esto sera rellenado en memoria (ya que no pesara mucho) para luego dibujarse en otro array, que seria la segunda parte que escribimos en la hoja, luego de las colisiones.

    private final boolean[] colisiones; //las propias colisiones 

    public final ArrayList<Rectangle> zonasColis = new ArrayList<Rectangle>();
    
    public  ArrayList<ItemsDelPiso> itemsMapa;
    

    public ArrayList<Enemigos> enemigos;
    
    
    
    
    
    private final int MARGEN_X = Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
    private final int MARGEN_Y = Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;

    private final int[] sprites; //numeros que referencian nuestro sprite que debe ser dibujado a cada momento. Esta es la segunda parte que escribimos en la hoja luego de las colisiones.

   
    private final Teclado teclado;

    
    public GestorMapa(final String ruta) {

teclado= new Teclado();
        
        String contenido = CargadorRecursos.leerTexto(ruta);

        partes = contenido.split("\\*");

        ancho = Integer.parseInt(partes[0]); //lee al archivo la parte de las medida del ancho de la hoja
        alto = Integer.parseInt(partes[1]); //lee al archivo la parte de la medida del alto de la hoja

        //LECTURA HOJAS USADAS
        String hojasUs = partes[2]; //lee al archivo la parte de la hoja que esta siendo usada

        String[] hojasUsSep = hojasUs.split(",");  //hojas que podriamos tener

        //LECTURA PARTES PALETA DE SPRITES
        String paletaEntera = partes[3];   //en esta parte lee al archivo la parte de la paleta
        String[] partesPaleta = paletaEntera.split("#");

        //ASIGNACION SPRITES (PARTESPALETA Y HOJAS SEPARADAS)
        paleta = asignarSprites(partesPaleta, hojasUsSep);

        //LECTURA PARTE DE COLISIONES
        String colisionesEnteras = partes[4]; //lee al archivo la parte de las colisiones

        colisiones = extractColis(colisionesEnteras);  //pasamos el array de colisiones

//LECTURA CADENA DE SPRITES (DIBUJADO EN LA HOJA)
        String spritesEnteros = partes[5];  //lee al archivo la parte en el cual dibujara el mapa tomando los sprites desde la paleta

        String[] cadenasSprites = spritesEnteros.split(" ");

        //2
        sprites = extractSprites(cadenasSprites);  //pasamos el array de la cadenaSprites dentro del array de sprites.

        String posicion = partes[6];
        String[] posiciones = posicion.split("-");

        posicInic = new Point();

        posicInic.x = Integer.parseInt(posiciones[0]) * Constantes.LADO_SPRITE;
        posicInic.y = Integer.parseInt(posiciones[1]) * Constantes.LADO_SPRITE;

        String salida = partes[7];

        String[] posicSal = salida.split("-");
        
  
      
        
        

        posicSalida = new Point();

        posicSalida.x = Integer.parseInt(posicSal[0]);
        posicSalida.y = Integer.parseInt(posicSal[1]);

        
        

        
        
        
        sigMap = posicSal[2];

        zonaSalida = new Rectangle();
        
        
        
  //  if(partes.length > 7){
                 String infoItems= partes[8];
        
        itemsMapa= asignacionItems(infoItems);
  //  }

        
        
        
        
        
       String infoEnemigos = partes[9]; 
       
       

       
       
       
       
       
       
       
        enemigos = asignarEnemigos(infoEnemigos);
        
        
        
      
        
        
        
        
        

    }

    
    
    private ArrayList<Enemigos> asignarEnemigos(final String infoEnemigo){
        
        
        
        ArrayList<Enemigos> enemigos= new ArrayList<>();
        
        
        String [] infoEnemigosPartido= infoEnemigo.split("#");
        
        
        for( int i = 0 ; i< infoEnemigosPartido.length; i++){
            
            String [] infoEnemigoActual= infoEnemigosPartido[i].split(":");
            String [] coordenadas = infoEnemigoActual[0].split(",");
            String idEnemigo = infoEnemigoActual[1];
            
            
            Enemigos enemigo = EnemigosDelJuego.obtenEnemigos(Integer.parseInt(idEnemigo)); //le pasamos el numero id de enemigo y lo convertimos ya que lo veniamos usando como string
            
            
            enemigo.setPosicion(Double.parseDouble(coordenadas[0]),Double.parseDouble(coordenadas[1]) );
            
            enemigos.add(enemigo);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        return enemigos;
    }
    
    
    
    
    
    
    
    
    public Point getPosicInic() {
        return posicInic;
    }

    public Point getPosicSalida() {
        return posicSalida;
    }

    public String getSigMap() {
        return sigMap;
    }

    
    public Rectangle getZonaSalida(){
        return zonaSalida;
    }
    
    
    public void actualizar() {
   
        actualizaZonasColis();
     
        actualizaZonaSalida();
    //    actualizarAgarrarItems();
    }
    
    /*
    private void actualizarAgarrarItems(){
        
        if(!itemsMapa.isEmpty()){
         
            final Rectangle areaPersona= new Rectangle(InstanciasImportantes.persona.obtenIntPosicX(),
            InstanciasImportantes.persona.obtenIntPosicY(),Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
        for(int i=0; i < itemsMapa.size();i++){
            final ItemsDelPiso vaul= itemsMapa.get(i);
       
        final Rectangle posicVaul= new Rectangle(vaul.getPosic().x * Constantes.LADO_SPRITE,
        vaul.getPosic().y * Constantes.LADO_SPRITE,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
        
        
        if(areaPersona.intersects(posicVaul) && InstaTeclado.teclado.agarrando){
            InstanciasImportantes.inventario.agarrarItemsMapa(vaul);
            itemsMapa.remove(i);
            
            
            
            
        }
        
        
        
        
        }
        
        
        }     
        
    }
    
    
    
   */ 
    
    
    
    

    private ArrayList<ItemsDelPiso> asignacionItems(final String informacionItems){
    
        final ArrayList<ItemsDelPiso> items= new ArrayList<ItemsDelPiso>();
        
        
        String [] contItems= informacionItems.split("#");
        
        
        for(String itemsIndiv : contItems){
            
            final ArrayList<Integer> idItems = new ArrayList<Integer>();
            final ArrayList<Integer> cantItems = new ArrayList<Integer>();
            
            
            final String[] divisionInfoItems = itemsIndiv.split(":");
            final String [] coordenadas = divisionInfoItems[0].split(",");
            
            final Point posicCont = new Point(Integer.parseInt(coordenadas[0] ),
                    Integer.parseInt( coordenadas[1]) );
            
            
            final String [] itemsCants = divisionInfoItems[1].split("/");
            
            
            
            for(String itemActual : itemsCants ){
                final String[] infoItemActual = itemActual.split("-");
                
                idItems.add(Integer.parseInt(infoItemActual[0]));
                cantItems.add(Integer.parseInt(infoItemActual[1]));
                
                
            }
            
            
            
            
            
            final int [] idItemsArray= new int [idItems.size()];
            
            final int[] cantItemsArray= new int [cantItems.size()];
            
            
            
            
            for(int i=0; i < idItemsArray.length;i++){
                
                idItemsArray[i] = idItems.get(i);
                
                cantItemsArray[i] = cantItems.get(i);
                
                
            }
            
            final ItemsDelPiso vaul= new ItemsDelPiso(posicCont,idItemsArray, cantItemsArray );
            
            
            items.add(vaul);
        }
        
        
        
        
        
        return items;
    }
    
    
    
    
    
    
    
    public void actualizaZonasColis() {

        if (!zonasColis.isEmpty()) {  //si el array zonasColis no esta vacio, lo vaciamos
            zonasColis.clear();
        }

        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {

                int puntoX = x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

                int puntoY = y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

                if (colisiones[x + y * this.ancho]) {

                    final Rectangle area = new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

                    zonasColis.add(area);
                }

            }
        }

    }

    private void actualizaZonaSalida() {

        int puntoX = ((int) posicSalida.getX()) * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

        int puntoY = ((int) posicSalida.getY()) * Constantes.LADO_SPRITE -ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

        
        zonaSalida=new Rectangle(puntoX,puntoY,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
    }

 

    // 1
    private Sprite[] asignarSprites(final String[] partesPaleta, final String[] hojasUsSep) {

        //al invocarse el metodo constructro dentro de este metodo que tambien tiene parametros, 
        //primero pasamos los parametros del metodo y luego los del constructor, en donde dichos datos del constructor los separamos con una , y los del metodo con un +
        Sprite[] paleta = new Sprite[partesPaleta.length];  //instanciamos el objeto paleta tipo array de sprites

        HojaSprites hojaa = new HojaSprites(Constantes.RUTA_MAPA + hojasUsSep[0] + ".png", 32, false);

        for (int i = 0; i < partesPaleta.length; i++) {

            String spriteTemp = partesPaleta[i];

            String[] partesSprite = spriteTemp.split("-");    //de esta manera le sacamos el -

            int indicArraysPaleta = Integer.parseInt(partesSprite[0]);  //transforma en decimales a los array de la paleta

            int indicSpritesHoja = Integer.parseInt(partesSprite[2]);

            paleta[indicArraysPaleta] = hojaa.getSprite(indicSpritesHoja); //almacenamos el array de paleta tipo sprites con todos los sprites de la paleta
            //ponemos paleta[indicarraysPaleta] ya que se almacenara cada sprite con su array de sprites en la paleta

        }

        return paleta;
    }

    private boolean[] extractColis(final String cadenasColisiones) {
        //el tamaño del array booleano colisiones va a tener la misma cantidad que caracteres tenga cadenaColisiones.

        boolean[] colisiones = new boolean[cadenasColisiones.length()];

        for (int i = 0; i < cadenasColisiones.length(); i++) {

            if (cadenasColisiones.charAt(i) == '0') {
                colisiones[i] = false;
            } else {
                colisiones[i] = true;
            }
        }

        return colisiones;

    }

    //2
    private int[] extractSprites(final String[] cadenasSprites) {

        ArrayList<Integer> sprites = new ArrayList<Integer>();

        for (int i = 0; i < cadenasSprites.length; i++) {

            if (cadenasSprites[i].length() == 2) { //cuando una cadena no tenga 2 de longitud, es que tendra 4 y ahi pasamos con el calculo de abajo

                sprites.add(Integer.parseInt(cadenasSprites[i]));

            } else {

                String uno = "";  //primeros 2 caracteres de error
                String dos = "";  //segundos 2 caracteres de error

                String error = cadenasSprites[i]; //los caracteres de error se añaden al array

                uno += error.charAt(0);           //rompe la cadena de caracteres en una parte
                uno += error.charAt(1);

                dos += error.charAt(2); //rompe la cadena de caracteres en una segunda parte

                dos += error.charAt(3);

                //de esta manera partimos la cadena que es de longitud 4 en 2, para que sea longitud 2.
                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));

            }

        }

        //para medir el vector de arraylist usamos size a diferencia del array comun que usa length
        int[] vectorSprites = new int[sprites.size()]; //creamos este array para transformar en tipo int al arraylist que contiene los sprites
        //y luego pasarselos al array tipo int de sprites.

        for (int i = 0; i < sprites.size(); i++) {         //copiamos el contenido del arraylist al vectorsprites tipo int
            vectorSprites[i] = sprites.get(i); //en vez de usar los corchetes para pasar el argumento del recorrido con i como en un array comun, el arraylist usa un metodo get con su i dentro de parentesis

            //el uso de un metodo get del arraylist se debe a que es un objeto complejo a diferencia del array comun que es un objeto simple.
        }

        return vectorSprites;  //devuelve el valor int del arraylist para incorporarlo al array tipo int de sprites.

    }

    public void dibujar(Graphics g) {

        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {

                BufferedImage imagen = paleta[sprites[x + y * this.ancho]].getImagen();

                int puntoX = x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

                int puntoY = y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

                
                
                
           
                DibujadorRectangulosImagenes.dibujImagen(g, imagen, puntoX, puntoY);
                        
             
            }

        }

        
        if(!itemsMapa.isEmpty()){
            
            
            for( ItemsDelPiso vaul : itemsMapa){
                
                final int puntoX = vaul.getPosic().x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;
                 final int puntoY = vaul.getPosic().y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY()+ MARGEN_Y;
                
                 
                 
                 vaul.dibujar(g, puntoX, puntoY);
                 
                 
            }
            
            
            
            
            
            
        }
        
        
       
        if(!enemigos.isEmpty()){
            
            for(Enemigos i : enemigos){
                
                
                final int puntoX = (int)i.getPosicX() * Constantes.LADO_SPRITE       //multiplicamos por 32 para que de tile pase a pixel
                -  ObjetosEstaticos.persona.obtenIntPosicX()+ MARGEN_X;
                final int puntoY = (int) i.getPosicY() * Constantes.LADO_SPRITE
                        - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;
                
                i.dibujarr(g, puntoX, puntoY);
                
                
                
                
                
                
            }
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
    }

    public Rectangle obtenerBorde(final int posX, final int posY) {

        int x = MARGEN_X - posX + ObjetosEstaticos.persona.getAncho(); //la mitad del ancho de pantalla menos la posicion horizontal del jugador y el ancho
        int y = MARGEN_Y - posY + ObjetosEstaticos.persona.getAlto(); //la mitad del ancho de la pantalla menos la posicion vertical del jugador 

        int anchoBord = this.ancho * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAncho() * 2;  //el ancho del mapa pasado a pixeles restandole el ancho de la persona
        int altoBord = this.alto * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAlto() * 2;

        return new Rectangle(x, y, anchoBord, altoBord);

    }

    public int getAncho() {
        return this.ancho;

    }

    public int getAlto() {

        return this.alto;
    }

    public Sprite getSpritePaleta(final int indice) {
        return paleta[indice];
    }

    public Sprite getSpritePaleta(final int x, final int y) {
        return paleta[x + y * this.ancho];
    }

    public Sprite[] getPaleta() {

        return this.paleta;
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR_MAPA;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import principal.Constantes;
import principal.ObjetosEstaticos;

import Enemigos.EnemigosDelJuego;
import Enemigos.Enemigos;
import ITEMSYARMAS.ItemsDelPiso;
import PERIFERICOS.Teclado;
import SPRITES.HojaSprites;
import SPRITES.Sprite;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;


/**
 *
 * @author samuel ludueña 2021
 */
public class GestorMapa {

    private String[] partes; //se guardaran las partes de texto leidas del archivo, dividiendo colisiones, de paleta, de dibujado de sprites,etc

    private final int ancho;
    private final int alto;

    public final Point posicInic;

    public final Point posicSalida;

   public Rectangle zonaSalida;

    public String sigMap;

    private final Sprite[] paleta; //es un array de sprites llamado paleta, el cual contendra los sprites junto a su hoja y posicion del array.(los primero que escribimos en la hoja que contendra piedra,asfalto,arena,etc)
    //esto sera rellenado en memoria (ya que no pesara mucho) para luego dibujarse en otro array, que seria la segunda parte que escribimos en la hoja, luego de las colisiones.

    private final boolean[] colisiones; //las propias colisiones 

    public final ArrayList<Rectangle> zonasColis = new ArrayList<Rectangle>();
    
    public  ArrayList<ItemsDelPiso> itemsMapa;
    

    public ArrayList<Enemigos> enemigos;
    
    
    
    
    
    private final int MARGEN_X = Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
    private final int MARGEN_Y = Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;

    private final int[] sprites; //numeros que referencian nuestro sprite que debe ser dibujado a cada momento. Esta es la segunda parte que escribimos en la hoja luego de las colisiones.

   
    private final Teclado teclado;

    
    public GestorMapa(final String ruta) {

teclado= new Teclado();
        
        String contenido = CargadorRecursos.leerTexto(ruta);

        partes = contenido.split("\\*");

        ancho = Integer.parseInt(partes[0]); //lee al archivo la parte de las medida del ancho de la hoja
        alto = Integer.parseInt(partes[1]); //lee al archivo la parte de la medida del alto de la hoja

        //LECTURA HOJAS USADAS
        String hojasUs = partes[2]; //lee al archivo la parte de la hoja que esta siendo usada

        String[] hojasUsSep = hojasUs.split(",");  //hojas que podriamos tener

        //LECTURA PARTES PALETA DE SPRITES
        String paletaEntera = partes[3];   //en esta parte lee al archivo la parte de la paleta
        String[] partesPaleta = paletaEntera.split("#");

        //ASIGNACION SPRITES (PARTESPALETA Y HOJAS SEPARADAS)
        paleta = asignarSprites(partesPaleta, hojasUsSep);

        //LECTURA PARTE DE COLISIONES
        String colisionesEnteras = partes[4]; //lee al archivo la parte de las colisiones

        colisiones = extractColis(colisionesEnteras);  //pasamos el array de colisiones

//LECTURA CADENA DE SPRITES (DIBUJADO EN LA HOJA)
        String spritesEnteros = partes[5];  //lee al archivo la parte en el cual dibujara el mapa tomando los sprites desde la paleta

        String[] cadenasSprites = spritesEnteros.split(" ");

        //2
        sprites = extractSprites(cadenasSprites);  //pasamos el array de la cadenaSprites dentro del array de sprites.

        String posicion = partes[6];
        String[] posiciones = posicion.split("-");

        posicInic = new Point();

        posicInic.x = Integer.parseInt(posiciones[0]) * Constantes.LADO_SPRITE;
        posicInic.y = Integer.parseInt(posiciones[1]) * Constantes.LADO_SPRITE;

        String salida = partes[7];

        String[] posicSal = salida.split("-");
        
  
      
        
        

        posicSalida = new Point();

        posicSalida.x = Integer.parseInt(posicSal[0]);
        posicSalida.y = Integer.parseInt(posicSal[1]);

        
        

        
        
        
        sigMap = posicSal[2];

        zonaSalida = new Rectangle();
        
        
        
  //  if(partes.length > 7){
                 String infoItems= partes[8];
        
        itemsMapa= asignacionItems(infoItems);
  //  }

        
        
        
        
        
       String infoEnemigos = partes[9]; 
       
       

       
       
       
       
       
       
       
        enemigos = asignarEnemigos(infoEnemigos);
        
        
        
      
        
        
        
        
        

    }

    
    
    private ArrayList<Enemigos> asignarEnemigos(final String infoEnemigo){
        
        
        
        ArrayList<Enemigos> enemigos= new ArrayList<>();
        
        
        String [] infoEnemigosPartido= infoEnemigo.split("#");
        
        
        for( int i = 0 ; i< infoEnemigosPartido.length; i++){
            
            String [] infoEnemigoActual= infoEnemigosPartido[i].split(":");
            String [] coordenadas = infoEnemigoActual[0].split(",");
            String idEnemigo = infoEnemigoActual[1];
            
            
            Enemigos enemigo = EnemigosDelJuego.obtenEnemigos(Integer.parseInt(idEnemigo)); //le pasamos el numero id de enemigo y lo convertimos ya que lo veniamos usando como string
            
            
            enemigo.setPosicion(Double.parseDouble(coordenadas[0]),Double.parseDouble(coordenadas[1]) );
            
            enemigos.add(enemigo);
            
        }
        
        
        
        
        
        
        
        
        
        
        
        return enemigos;
    }
    
    
    
    
    
    
    
    
    public Point getPosicInic() {
        return posicInic;
    }

    public Point getPosicSalida() {
        return posicSalida;
    }

    public String getSigMap() {
        return sigMap;
    }

    
    public Rectangle getZonaSalida(){
        return zonaSalida;
    }
    
    
    public void actualizar() {
   
        actualizaZonasColis();
     
        actualizaZonaSalida();
    //    actualizarAgarrarItems();
    }
    
    /*
    private void actualizarAgarrarItems(){
        
        if(!itemsMapa.isEmpty()){
         
            final Rectangle areaPersona= new Rectangle(InstanciasImportantes.persona.obtenIntPosicX(),
            InstanciasImportantes.persona.obtenIntPosicY(),Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
        for(int i=0; i < itemsMapa.size();i++){
            final ItemsDelPiso vaul= itemsMapa.get(i);
       
        final Rectangle posicVaul= new Rectangle(vaul.getPosic().x * Constantes.LADO_SPRITE,
        vaul.getPosic().y * Constantes.LADO_SPRITE,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
        
        
        if(areaPersona.intersects(posicVaul) && InstaTeclado.teclado.agarrando){
            InstanciasImportantes.inventario.agarrarItemsMapa(vaul);
            itemsMapa.remove(i);
            
            
            
            
        }
        
        
        
        
        }
        
        
        }     
        
    }
    
    
    
   */ 
    
    
    
    

    private ArrayList<ItemsDelPiso> asignacionItems(final String informacionItems){
    
        final ArrayList<ItemsDelPiso> items= new ArrayList<ItemsDelPiso>();
        
        
        String [] contItems= informacionItems.split("#");
        
        
        for(String itemsIndiv : contItems){
            
            final ArrayList<Integer> idItems = new ArrayList<Integer>();
            final ArrayList<Integer> cantItems = new ArrayList<Integer>();
            
            
            final String[] divisionInfoItems = itemsIndiv.split(":");
            final String [] coordenadas = divisionInfoItems[0].split(",");
            
            final Point posicCont = new Point(Integer.parseInt(coordenadas[0] ),
                    Integer.parseInt( coordenadas[1]) );
            
            
            final String [] itemsCants = divisionInfoItems[1].split("/");
            
            
            
            for(String itemActual : itemsCants ){
                final String[] infoItemActual = itemActual.split("-");
                
                idItems.add(Integer.parseInt(infoItemActual[0]));
                cantItems.add(Integer.parseInt(infoItemActual[1]));
                
                
            }
            
            
            
            
            
            final int [] idItemsArray= new int [idItems.size()];
            
            final int[] cantItemsArray= new int [cantItems.size()];
            
            
            
            
            for(int i=0; i < idItemsArray.length;i++){
                
                idItemsArray[i] = idItems.get(i);
                
                cantItemsArray[i] = cantItems.get(i);
                
                
            }
            
            final ItemsDelPiso vaul= new ItemsDelPiso(posicCont,idItemsArray, cantItemsArray );
            
            
            items.add(vaul);
        }
        
        
        
        
        
        return items;
    }
    
    
    
    
    
    
    
    public void actualizaZonasColis() {

        if (!zonasColis.isEmpty()) {  //si el array zonasColis no esta vacio, lo vaciamos
            zonasColis.clear();
        }

        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {

                int puntoX = x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

                int puntoY = y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

                if (colisiones[x + y * this.ancho]) {

                    final Rectangle area = new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);

                    zonasColis.add(area);
                }

            }
        }

    }

    private void actualizaZonaSalida() {

        int puntoX = ((int) posicSalida.getX()) * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

        int puntoY = ((int) posicSalida.getY()) * Constantes.LADO_SPRITE -ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

        
        zonaSalida=new Rectangle(puntoX,puntoY,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
    }

 

    // 1
    private Sprite[] asignarSprites(final String[] partesPaleta, final String[] hojasUsSep) {

        //al invocarse el metodo constructro dentro de este metodo que tambien tiene parametros, 
        //primero pasamos los parametros del metodo y luego los del constructor, en donde dichos datos del constructor los separamos con una , y los del metodo con un +
        Sprite[] paleta = new Sprite[partesPaleta.length];  //instanciamos el objeto paleta tipo array de sprites

        HojaSprites hojaa = new HojaSprites(Constantes.RUTA_MAPA + hojasUsSep[0] + ".png", 32, false);

        for (int i = 0; i < partesPaleta.length; i++) {

            String spriteTemp = partesPaleta[i];

            String[] partesSprite = spriteTemp.split("-");    //de esta manera le sacamos el -

            int indicArraysPaleta = Integer.parseInt(partesSprite[0]);  //transforma en decimales a los array de la paleta

            int indicSpritesHoja = Integer.parseInt(partesSprite[2]);

            paleta[indicArraysPaleta] = hojaa.getSprite(indicSpritesHoja); //almacenamos el array de paleta tipo sprites con todos los sprites de la paleta
            //ponemos paleta[indicarraysPaleta] ya que se almacenara cada sprite con su array de sprites en la paleta

        }

        return paleta;
    }

    private boolean[] extractColis(final String cadenasColisiones) {
        //el tamaño del array booleano colisiones va a tener la misma cantidad que caracteres tenga cadenaColisiones.

        boolean[] colisiones = new boolean[cadenasColisiones.length()];

        for (int i = 0; i < cadenasColisiones.length(); i++) {

            if (cadenasColisiones.charAt(i) == '0') {
                colisiones[i] = false;
            } else {
                colisiones[i] = true;
            }
        }

        return colisiones;

    }

    //2
    private int[] extractSprites(final String[] cadenasSprites) {

        ArrayList<Integer> sprites = new ArrayList<Integer>();

        for (int i = 0; i < cadenasSprites.length; i++) {

            if (cadenasSprites[i].length() == 2) { //cuando una cadena no tenga 2 de longitud, es que tendra 4 y ahi pasamos con el calculo de abajo

                sprites.add(Integer.parseInt(cadenasSprites[i]));

            } else {

                String uno = "";  //primeros 2 caracteres de error
                String dos = "";  //segundos 2 caracteres de error

                String error = cadenasSprites[i]; //los caracteres de error se añaden al array

                uno += error.charAt(0);           //rompe la cadena de caracteres en una parte
                uno += error.charAt(1);

                dos += error.charAt(2); //rompe la cadena de caracteres en una segunda parte

                dos += error.charAt(3);

                //de esta manera partimos la cadena que es de longitud 4 en 2, para que sea longitud 2.
                sprites.add(Integer.parseInt(uno));
                sprites.add(Integer.parseInt(dos));

            }

        }

        //para medir el vector de arraylist usamos size a diferencia del array comun que usa length
        int[] vectorSprites = new int[sprites.size()]; //creamos este array para transformar en tipo int al arraylist que contiene los sprites
        //y luego pasarselos al array tipo int de sprites.

        for (int i = 0; i < sprites.size(); i++) {         //copiamos el contenido del arraylist al vectorsprites tipo int
            vectorSprites[i] = sprites.get(i); //en vez de usar los corchetes para pasar el argumento del recorrido con i como en un array comun, el arraylist usa un metodo get con su i dentro de parentesis

            //el uso de un metodo get del arraylist se debe a que es un objeto complejo a diferencia del array comun que es un objeto simple.
        }

        return vectorSprites;  //devuelve el valor int del arraylist para incorporarlo al array tipo int de sprites.

    }

    public void dibujar(Graphics g) {

        for (int y = 0; y < this.alto; y++) {
            for (int x = 0; x < this.ancho; x++) {

                BufferedImage imagen = paleta[sprites[x + y * this.ancho]].getImagen();

                int puntoX = x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

                int puntoY = y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

                
                
                
           
                DibujadorRectangulosImagenes.dibujImagen(g, imagen, puntoX, puntoY);
                        
             
            }

        }

        
        if(!itemsMapa.isEmpty()){
            
            
            for( ItemsDelPiso vaul : itemsMapa){
                
                final int puntoX = vaul.getPosic().x * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;
                 final int puntoY = vaul.getPosic().y * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicY()+ MARGEN_Y;
                
                 
                 
                 vaul.dibujar(g, puntoX, puntoY);
                 
                 
            }
            
            
            
            
            
            
        }
        
        
       
        if(!enemigos.isEmpty()){
            
            for(Enemigos i : enemigos){
                
                
                final int puntoX = (int)i.getPosicX() * Constantes.LADO_SPRITE       //multiplicamos por 32 para que de tile pase a pixel
                -  ObjetosEstaticos.persona.obtenIntPosicX()+ MARGEN_X;
                final int puntoY = (int) i.getPosicY() * Constantes.LADO_SPRITE
                        - ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;
                
                i.dibujarr(g, puntoX, puntoY);
                
                
                
                
                
                
            }
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
    }

    public Rectangle obtenerBorde(final int posX, final int posY) {

        int x = MARGEN_X - posX + ObjetosEstaticos.persona.getAncho(); //la mitad del ancho de pantalla menos la posicion horizontal del jugador y el ancho
        int y = MARGEN_Y - posY + ObjetosEstaticos.persona.getAlto(); //la mitad del ancho de la pantalla menos la posicion vertical del jugador 

        int anchoBord = this.ancho * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAncho() * 2;  //el ancho del mapa pasado a pixeles restandole el ancho de la persona
        int altoBord = this.alto * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAlto() * 2;

        return new Rectangle(x, y, anchoBord, altoBord);

    }

    public int getAncho() {
        return this.ancho;

    }

    public int getAlto() {

        return this.alto;
    }

    public Sprite getSpritePaleta(final int indice) {
        return paleta[indice];
    }

    public Sprite getSpritePaleta(final int x, final int y) {
        return paleta[x + y * this.ancho];
    }

    public Sprite[] getPaleta() {

        return this.paleta;
    }

}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
