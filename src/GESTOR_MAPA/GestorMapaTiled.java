package GESTOR_MAPA;

import IA.Dijstra;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

import principal.Constantes;
import principal.ObjetosEstaticos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;



import Enemigos.EnemigosDelJuego;
import Enemigos.Enemigos;
import ITEMSYARMAS.ItemsYArmasDelJuego;
import ITEMSYARMAS.Items;
import ITEMSYARMAS.ItemsDelPiso;
import PERIFERICOS.Teclado;

import SPRITES.HojaSprites;
import SPRITES.Sprite;
import HERRAMIENTAS.CalculadoraDistancia;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import ITEMSYARMAS.SinArmas;
import Personajes.Personaje;
import javax.swing.JOptionPane;

public class GestorMapaTiled {

    private double anchoTiles;
    private double altoTiles;

         Rectangle recc;
         boolean istrue;
         boolean istrue2;
    
    public Point puntoInicial;

    private ArrayList<CapasSprites> capSprites;
    private ArrayList<CapasColisiones> capColision;

    public ArrayList<Rectangle> areasColisiones;  //guarda las colisiones originales
   public ArrayList <Rectangle> areasColisionActualizar= new ArrayList<>(); //guarda las colisiones actualizadas
    
   private Dijstra dij;
   
   JSONObject globalJSON;
   
   JSONObject puntoInic;
   
   
    
    private Sprite[] paletaSprites;
    
    private static Teclado teclado;
 
    private ArrayList <ItemsMapaTiled> itemsMapa= new ArrayList<>();
     private ArrayList <Enemigos> enemigosMapa= new ArrayList<>();
      

    public GestorMapaTiled(final String ruta) {
        
      //  teclado = new Teclado();
        

        String RutaTiled = CargadorRecursos.leerTexto(ruta);

//    ANCHO,ALTO
        globalJSON = getObjetoJSON(RutaTiled);

        anchoTiles = getDoubleJson(globalJSON, "width");
        altoTiles = getDoubleJson(globalJSON, "height");

        //   System.out.println(anchoTiles);
        //        System.out.println(altoTiles);
//PUNTO INICIAL
       puntoInic = getObjetoJSON(globalJSON.get("start").toString());

        this.puntoInicial = new Point(getIntJson(puntoInic, "x"),
                getIntJson(puntoInic, "y"));

        //      System.out.println(this.puntoInicial.toString());
        //       System.out.println("ancho: " + anchoTiles + ", alto: " + altoTiles);
//CAPAS
        JSONArray capas = getArrayJSON(globalJSON.get("layers").toString());

        this.capSprites = new ArrayList<>();         //en el new no hace falta poner de vuelta el tipo ya que esta declarado arriba
        this.capColision = new ArrayList<>();

        //INICIAR CAPAS
        for (int i = 0; i < capas.size(); i++) {

            JSONObject datosCapa = getObjetoJSON(capas.get(i).toString());

            double anchoCapa = getDoubleJson(datosCapa, "width");
            double altoCapa = getDoubleJson(datosCapa, "height");
            double xCapa = getDoubleJson(datosCapa, "x");
            double yCapa = getDoubleJson(datosCapa, "y");

            String tipo = datosCapa.get("type").toString();

            //System.out.println(anchoCapa);
            //System.out.println(altoCapa);
            //        System.out.println(xCapa);
            //      System.out.println(yCapa);
            //  System.out.println(tipo);
            switch (tipo) {

                case "tilelayer":

                    JSONArray sprites = getArrayJSON(datosCapa.get("data").toString());

                    int[] spritesCapa = new int[sprites.size()];

                    for (int j = 0; j < sprites.size(); j++) {

                        int codigoSprites = Integer.parseInt(sprites.get(j).toString());

                        spritesCapa[j] = codigoSprites - 1; //evitamos el problema del 0 como null en el programa tiled.

                        //   System.out.println(codigoSprites);
                    }

                    this.capSprites.add(new CapasSprites(anchoCapa, altoCapa, xCapa, yCapa, spritesCapa));

                    //     for(int k=0; k <capSprites.size();k++){
                    //       System.out.println(capSprites.get(i).getSprites());
                    //   }
                    //   System.out.println(capSprites);
                    break;

                case "objectgroup":

                    JSONArray rectangulos = getArrayJSON(datosCapa.get("objects").toString());

                    Rectangle[] rectaCapa = new Rectangle[rectangulos.size()];

                    for (int j = 0; j < rectangulos.size(); j++) {

                        JSONObject datosRectangulo = getObjetoJSON(rectangulos.get(j).toString());

                        double x = getDoubleJson(datosRectangulo, "x");
                        double y = getDoubleJson(datosRectangulo, "y");

                        double ancho = getDoubleJson(datosRectangulo, "width");
                        double alto = getDoubleJson(datosRectangulo, "height");

                        //       System.out.println(x);
                        //   System.out.println(y);
                        //              System.out.println(ancho);
                        /*
                        if (x == 0) {
                            x = 1;
                        }
                        if (y == 0) {
                            y = 1;
                        }
                        if (ancho == 0) {
                            ancho = 1;
                        }
                        if (alto == 0) {
                            alto = 1;
                        }
                         */
                        Rectangle rectangulo = new Rectangle((int) x, (int) y, (int) ancho, (int) alto);
                        rectaCapa[j] = rectangulo;

                        //    System.out.println(rectangulo);
                    }

                    this.capColision.add(new CapasColisiones((int) anchoCapa, altoCapa, xCapa, yCapa, rectaCapa));

                    /*     
                    for(int l=0; l<capColision.size();l++){
                        
                        System.out.println(capColision.get(l).getColisiones());
                    }
                    
                     */
                    break;

            }

        }

        // System.out.println(this.capSprites.get(0).getSprites().length);
        //  System.out.println(this.capColision.get(0).getColisiones().length);
        
        
        
        
        //COMBINAR COLISIONES EN UN SOLO ARRAYLIST POR EFICIENCIA
        areasColisiones = new ArrayList<>();

        for (int i = 0; i < capColision.size(); i++) {
            Rectangle[] rectangulos = capColision.get(i).getColisiones();

            for (int j = 0; j < rectangulos.length; j++) {
                areasColisiones.add(rectangulos[j]);
            }

        }
        
        dij= new Dijstra(new Point (10,10),(int) anchoTiles,(int) altoTiles,areasColisiones) ;
        
        
        
        
        

        //AVERIGUAR TOTAL DE SPRITES EXISTENTES EN TODAS LAS CAPAS
        JSONArray coleccionesSprites = getArrayJSON(globalJSON.get("tilesets").toString());

        int totalSprites = 0;

        for (int i = 0; i < coleccionesSprites.size(); i++) {
            JSONObject datosGrupo = getObjetoJSON(coleccionesSprites.get(i).toString());
            totalSprites += getIntJson(datosGrupo, "tilecount");
        }

        paletaSprites = new Sprite[totalSprites];

        
        
        
        
        
        //ASIGNAR SPRITES NECESARIOS A LA PALETA DESDE LAS CAPAS
        for (int i = 0; i < coleccionesSprites.size(); i++) {

            JSONObject datosGrupo = getObjetoJSON(coleccionesSprites.get(i).toString());

            String nombreImagen = datosGrupo.get("image").toString();

            int anchoTiles = getIntJson(datosGrupo, "tilewidth");
            int altoTiles = getIntJson(datosGrupo, "tileheight");
       
            
            HojaSprites hoja = new HojaSprites(Constantes.RUTA_MAPA_BASE_PARA_JSON+ nombreImagen, anchoTiles, altoTiles, false);

            int primSpriteColeccion = getIntJson(datosGrupo, "firstgid") - 1;
            int ultimSpriteColeccion = primSpriteColeccion + getIntJson(datosGrupo, "tilecount") - 1; // getIntJson(datosGrupo,"firstgid" + getIntJson(datosGrupo,"tilecount" 

            for (int j = 0; j < this.capSprites.size(); j++) {
                CapasSprites capaActual = this.capSprites.get(j);

                int[] spritesCapa = capaActual.getSprites();  //asi accedemos los numeros de los sprites que guardamos anteriormente desde data

                for (int k = 0; k < spritesCapa.length; k++) {  //vamos a recorrer y recuperar estos numeros para luego plasmarlos en sprites

                    int idSpriteActual = spritesCapa[k];            //tomamos la posicion actual de data

                    if (idSpriteActual >= primSpriteColeccion && idSpriteActual //verificamos por ejemplo si el primer sprite pertenece a la primera hoja
                            <= ultimSpriteColeccion) {

                        if (paletaSprites[idSpriteActual] == null) { //si todavia no hay ningun sprite en ese indice

                            paletaSprites[idSpriteActual] = hoja.getSprite(idSpriteActual - primSpriteColeccion);

                        }
                    }

                }

            }

        }


//OBTENER OBJETOS

JSONArray coleccionItems= getArrayJSON(globalJSON.get("objetos").toString());

for(int i=0; i< coleccionItems.size(); i++){
    
    JSONObject datosItems = getObjetoJSON(coleccionItems.get(i).toString());
    
    
    
    int idItem= getIntJson(datosItems ,"id");
      int cantItems= getIntJson(datosItems ,"cantidad");
        int xItem= getIntJson(datosItems ,"x");
          int yItem= getIntJson(datosItems ,"y");
          
          
          Point posicItem= new Point(xItem, yItem);
          
          Items item= ItemsYArmasDelJuego.obtenItem(idItem);
          
          ItemsMapaTiled unicoItem= new ItemsMapaTiled (posicItem,item );
          
          itemsMapa.add(unicoItem);
          
          
}




 
 
 
 
 
//OBTENER ENEMIGOS

JSONArray coleccionEnemigos= getArrayJSON(globalJSON.get("enemigos").toString());

for(int i=0; i< coleccionEnemigos.size(); i++){
    
    JSONObject datosEnemigo = getObjetoJSON(coleccionEnemigos.get(i).toString());
    
    
    
    int idEnemigo= getIntJson(datosEnemigo,"id");
      
        int xEnemigo= getIntJson(datosEnemigo ,"x");
          int yEnemigo= getIntJson(datosEnemigo ,"y");
          
          
          Point posicEnemigo= new Point(xEnemigo, yEnemigo);
          
          Enemigos enemigo= EnemigosDelJuego.obtenEnemigos(idEnemigo);
         
          
          
          enemigo.setPosicion(posicEnemigo.x, posicEnemigo.y);
          
          
          enemigosMapa.add(enemigo);
          
          
}
 
  
   
 
    
    
 
    



    }
              public  Point posicSalida;

   public Rectangle zonaSalida;
    public String sigMap;
       
          public final int MARGEN_X = Constantes.ANCHO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;
    public final int MARGEN_Y = Constantes.ALTO_JUEGO / 2 - Constantes.LADO_SPRITE / 2;

  public void actualizaZonaSalida() {
       

       

       

        int puntoX = ((int) posicSalida.getX()) * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.obtenIntPosicX() + MARGEN_X;

        int puntoY = ((int) posicSalida.getY()) * Constantes.LADO_SPRITE -ObjetosEstaticos.persona.obtenIntPosicY() + MARGEN_Y;

        
        zonaSalida=new Rectangle(puntoX,puntoY,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
    } 




    public Rectangle getZonaSalida(){
        return zonaSalida;
    }
    
    
       public String getSigMap() {
        return sigMap;
    }

public void actualizaZonasColis() {
/*
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
*/
    }



    private void actualizarAgarrarItems(){
        
        if(!itemsMapa.isEmpty()){
         
            final Rectangle areaPersona= new Rectangle(ObjetosEstaticos.persona.obtenIntPosicX(),
            ObjetosEstaticos.persona.obtenIntPosicY(),Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
        
        
        for(int i=0; i < itemsMapa.size();i++){
       
            final ItemsMapaTiled itemTiledActual= itemsMapa.get(i);
       
        final Rectangle posicActual= new Rectangle(itemTiledActual.getPosicion().x  ,
        itemTiledActual.getPosicion().y ,Constantes.LADO_SPRITE,Constantes.LADO_SPRITE);
        
        
        
        if(areaPersona.intersects(posicActual) && ObjetosEstaticos.teclado.agarrando){
        
            ObjetosEstaticos.inventario.agarrarItemDeMapaTiled(itemTiledActual);
            itemsMapa.remove(i);
            
            
            
            
        }
        
        
        
        
        }
        
        
        }     
        
    }
    
    public void actualizar(){
            
        actualizarAreasColision();
          
        actualizarAgarrarItems();
        
               
        
         
       
         actualizarAtaquesDeEnemigos();
        
          
           actualizaPersonajeAtaques();

       
            ataqueEnemigo();
         
   
        
        Point punto = new Point (ObjetosEstaticos.persona.obtenIntPosicX(),
        ObjetosEstaticos.persona.obtenIntPosicY());
        

        
        Point puntoCruce= dij.obtieneCoordenadaNodoCrucePersona(punto);//el enemigo puede estar en mas de 4 nodos a la vez
        
        
           


        
        dij.reiniciaEvalua(puntoCruce);
        
  
            

        
    }
    
    private void ataqueEnemigo(){
            
  
        
        
        for(Enemigos i: enemigosMapa){
            
            

         
           if(ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(i.getAreaEnemigo3())){
         
            
         
         
        
         
         
         
                 i.ataqueAlPersonajee(ObjetosEstaticos.persona);
     }
            
            
            
            
               
     
            
               
            
            
       }
        
        
        
     
        
        
        
    }
    
    
    public boolean actualizarAtaquesDeEnemigos2(){
        boolean istrue2=false;
        
         for(Enemigos j : enemigosMapa){
             
             
             
                       boolean ij=   ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(j.getAreaEnemigo3c());   
             
                       
                       
                       
                       if(ij){
                           
                           j.actualizarr(enemigosMapa);  
                       j.setSigNodo(dij.encuentraSigNodoParaEnemigo(j));
                           istrue2=true;
                           
                           
                       }
                       
                       
                       
                       
                       
                       
                       
            //      return     istrue2;
                       
                       
                       
         }
         
         
           return     istrue2;
        
    }
    

    
    
    
    
   private void actualizarAtaquesDeEnemigos(){
 
      // istrue=false;
       
                recc=new Rectangle();
       
       if(!enemigosMapa.isEmpty()){
            
           for(Enemigos i : enemigosMapa){
            


                      i.actualizarr(enemigosMapa);  
if(ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(i.getAreaEnemigo3b())){
    
   
    
       i.actualizarr(enemigosMapa);  
                       i.setSigNodo(dij.encuentraSigNodoParaEnemigo(i));

    
        System.out.println("aqui1");
        
        istrue=true;
    
}else{ 
    
    
    
    
    
    

    
    
    if( 
            istrue){
 
        
        
        if((ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(i.getAreaEnemigo3b()) )){
        
    i.actualizarr(enemigosMapa);  
                       i.setSigNodo(dij.encuentraSigNodoParaEnemigo(i));
       System.out.println("aqui2");
    
        }else if((ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(i.getAreaEnemigo3c())) ){
            
            
           if((ObjetosEstaticos.persona.getAlcancePersona().get(0).intersects(i.getAreaEnemigo3c())) ){
               
               istrue2=true;
                        i.actualizarr(enemigosMapa);  
                       i.setSigNodo(dij.encuentraSigNodoParaEnemigo(i));
       System.out.println("aqui3");
          
               
               
               
               
           }
          
           
           
    
    
      
       
       
       
       
       
        }
        
      
        
        
        
        
        
        
        
 

    }
    
    
    
    
    
    
    

}
       
           }           
        
 
            
            
                
                
            
           
       }      
    
           
           
        
       else{
           
             JOptionPane.showMessageDialog(null, "GANASTE");

           System.exit(0);
           
       }
       
  
    
              
    
             
             
         
       
       
       
       
       
       
       
       
    }
    
    
    public void actualizarAreasColision(){
        
        if(!areasColisionActualizar.isEmpty()){
            areasColisionActualizar.clear();
        }
        
        for(int i=0; i<areasColisiones.size();i++){
            Rectangle rectaInicial= areasColisiones.get(i);
        
        int puntoX = rectaInicial.x -  ObjetosEstaticos.persona.obtenIntPosicX() + Constantes.MARGEN_X;
        
          
        int puntoY = rectaInicial.y -  ObjetosEstaticos.persona.obtenIntPosicY() + Constantes.MARGEN_Y;
        
        
        final Rectangle rectaFinal= new Rectangle (puntoX, puntoY, rectaInicial.width,rectaInicial.height);
        
        
        areasColisionActualizar.add(rectaFinal);
        
        }
        
        
        
        
        
    }
    
    public void dibujar(Graphics g){
        int dibujados=0;
        
        for(int i=0; i< capSprites.size();i++){
            int [] spritesCapa= capSprites.get(i).getSprites();
        
        
        for(int y=0; y< altoTiles;y++){
         
            for(int x=0; x< anchoTiles;x++){
                
                int idSpritesActual= spritesCapa[x+y * (int)anchoTiles];
                
                if(idSpritesActual != -1){
                    
                    int puntoX= x * Constantes.LADO_SPRITE  - 
                             ObjetosEstaticos.persona.obtenIntPosicX()+ Constantes.MARGEN_X;
                    
                    
                    int puntoY= y * Constantes.LADO_SPRITE  - 
                             ObjetosEstaticos.persona.obtenIntPosicY() + Constantes.MARGEN_Y;
                   
                    
                    
                    if(puntoX < 0 - Constantes.LADO_SPRITE ||   //el bucle for avanzará una unidad sin hacer la operacion
                        puntoX >   Constantes.ANCHO_JUEGO ||    // al agregarle que sea menos que lado sprite, evitaremos que se dibuje la franja negra 
                         puntoY < 0 - Constantes.LADO_SPRITE ||
                            puntoY > Constantes.ALTO_JUEGO  ){        // -70                             
                        continue;                             
                    }
                    
                    
                    
                    
                    
                    
                    
                    
               
               dibujados++;
                    DibujadorRectangulosImagenes.dibujImagen(g, paletaSprites[idSpritesActual].getImagen(), puntoX, puntoY);
                
                
                }
                
                
                
                
                
                
            }
            
            
            
        }
        
 
        
        
        }
        
        
        
        for(int i=0; i< itemsMapa.size();i++){
          
            ItemsMapaTiled itemActual = itemsMapa.get(i);
            
            
            int puntoX= itemActual.getPosicion().x - 
                    ObjetosEstaticos.persona.obtenIntPosicX() + Constantes.MARGEN_X;
            
            int puntoY= itemActual.getPosicion().y - 
                    ObjetosEstaticos.persona.obtenIntPosicY() + Constantes.MARGEN_Y;
            
            
 if(puntoX < 0 - Constantes.LADO_SPRITE ||   
                        puntoX >   Constantes.ANCHO_JUEGO ||   
                         puntoY < 0 - Constantes.LADO_SPRITE ||
                            puntoY > Constantes.ALTO_JUEGO -  90 ){                                     
                        continue;                             
                    }            
            
            
            
       
        DibujadorRectangulosImagenes.dibujImagen(g, itemActual.getItem().getSprite().getImagen(), puntoX,puntoY);
        
        
        
        }
        
        
        
        
        for(int i=0; i < enemigosMapa.size();i++){
            Enemigos enemigo= enemigosMapa.get(i);
            
            
            int puntoX= (int)enemigo.getPosicX() - 
                   ObjetosEstaticos.persona.obtenIntPosicX() + Constantes.MARGEN_X;
            
            int puntoY= (int)enemigo.getPosicY() - 
                    ObjetosEstaticos.persona.obtenIntPosicY() + Constantes.MARGEN_Y;
            
            
            
             if(puntoX < 0 - Constantes.LADO_SPRITE ||   
                        puntoX >   Constantes.ANCHO_JUEGO ||   
                         puntoY < 0 - Constantes.LADO_SPRITE ||
                            puntoY > Constantes.ALTO_JUEGO - 90){                                     
                        continue;                             
                    }            
            
            
            
       
        enemigo.dibujarr(g, puntoX, puntoY);
            
            
        
        
        
        
            
        }
        
        
        
        
        
        
        
        
    }
    
    
    
    
    private void actualizaPersonajeAtaques(){
      /*
        if(enemigosMapa.isEmpty() || ObjetosEstaticos.persona.getAlcanceAtaquePersonaje().isEmpty()   ||
                ObjetosEstaticos.persona.getEquipoPersonaje().getPistola() instanceof SinArmas){
            return;
        }
        
         if(enemigosMapa.isEmpty() || ObjetosEstaticos.persona.getAlcanceAtaquePersonaje().isEmpty()   ||
                ObjetosEstaticos.persona.getEquipoPersonaje().getEspada() instanceof SinArmas){
            return;
        }
        */
        
        
        if (ObjetosEstaticos.teclado.ataque){
            
          ArrayList<Enemigos> enemigosAlcanzados = new ArrayList<>();  
          
         if(ObjetosEstaticos.persona.getEquipoPersonaje().getPistola().esPenetrantee()) { // si el arma es penetrante (alcanza a varios enemigos)
             
             
              
          for(Enemigos enemigo : enemigosMapa){
              
              if(ObjetosEstaticos.persona.getAlcanceAtaquePersonaje().get(0).intersects(enemigo.getAreaEnemigo2())){
                    
                  System.out.println("te pegue un tiro");
                  
                  
                    enemigosAlcanzados.add(enemigo); //agrega al o los enemigos alcanzados por el impacto //ALCANZA A LOS CERCANOS
                    
                }
           
          
          
          } 
             
             
             
             
             
             
         }else{  // si no es penetrante, vamos a calcular la distancia y el impacto
             
           Enemigos enemigoProximo = null;
           Double distancProxima= null;
             
             for(Enemigos enemigo : enemigosMapa){
                
                 if(ObjetosEstaticos.persona.getAlcanceAtaquePersonaje().get(0).intersects(enemigo.getAreaEnemigo2())){
                     
                     
                     Point puntoPersonaje = new Point ( ObjetosEstaticos.persona.obtenIntPosicX() / 32,
                     ObjetosEstaticos.persona.obtenIntPosicY() / 32);
                     
                     
                     Point puntoEnemigo = new Point ( (int) enemigo.getPosicX(),
                     (int) enemigo.getPosicY() );
                     
                     
                     Double distanciaActual = CalculadoraDistancia.getDistanciaPuntos(puntoPersonaje, puntoEnemigo); //calculo de distancia entre enemigo y personaje
                     
                     
                     if(enemigoProximo == null){   //si no hay un enemigo proximo (estamos en la primera iteracion del bucle for)
                         
                         enemigoProximo = enemigo;   //ahora lo hay
                         
                         distancProxima = distanciaActual;  //ahi esta la distancia del enemigo proximo
                         
                         
                         
                         
                     }else if  (distanciaActual < distancProxima){
                         
                         enemigoProximo= enemigo;
                         distancProxima = distanciaActual;
                         
                         
                         
                     }
                     
                     
                     
                     
                     
                     
                     
                     
                 }
                 
                 
                 
                 
                 
                 
             }
             enemigosAlcanzados.add(enemigoProximo);  //no puede haber mas de un enemigo alcanzado al no ser penetrante. //NO ALCANZA A LOS CERCANOS
             
             
             
         }
          
          
        
            
            
            
        ObjetosEstaticos.persona.getEquipoPersonaje().getPistola().atacar(enemigosAlcanzados);
        
   
        
        
        
        }
        
        
        
       Iterator <Enemigos> iterador = enemigosMapa.iterator();
        
        
        while(iterador.hasNext()){
            
            Enemigos enemigo = iterador.next();
            
            
            if(enemigo.getVidaActual() <= 0 ){
                
                
                iterador.remove();
                
                
                
            }
            
        }
        
        
        
        
        
    }
    
    
    
    
    
    public Point getPuntoInicial(){
        return puntoInicial;
    }
    
    
     public Rectangle obtenerBorde(final int posX, final int posY) {

        int x = Constantes.MARGEN_X - posX + ObjetosEstaticos.persona.getAncho(); //la mitad del ancho de pantalla menos la posicion horizontal del jugador y el ancho
        int y = Constantes.MARGEN_Y - posY + ObjetosEstaticos.persona.getAlto(); //la mitad del ancho de la pantalla menos la posicion vertical del jugador 

        int anchoBord = (int)(this.anchoTiles) * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAncho() * 2;  //el ancho del mapa pasado a pixeles restandole el ancho de la persona
        int altoBord = (int)(this.anchoTiles) * Constantes.LADO_SPRITE - ObjetosEstaticos.persona.getAlto() * 2;

        return new Rectangle(x, y, anchoBord, altoBord);

    }
    
    

    public int getIntJson(final JSONObject objetoJSON, final String clave) {

        return Integer.parseInt(objetoJSON.get(clave).toString());
    }

    public double getDoubleJson(final JSONObject objetoJSON, final String clave) {

        return Double.parseDouble(objetoJSON.get(clave).toString());

    }

    private JSONObject getObjetoJSON(final String codigoJSON) {

        JSONParser lector = new JSONParser();
        JSONObject objetoJSON = null;

        try {
            Object recuperado = lector.parse(codigoJSON);
            objetoJSON = (JSONObject) recuperado;

        } catch (ParseException e) {

            System.out.println("Posicion: " + e.getPosition());
            System.out.println(e);

        }

        return objetoJSON;

    }

    private JSONArray getArrayJSON(final String codigoJSON) {

        JSONParser lector = new JSONParser();
        JSONArray ArrayJSON = null;

        try {
            Object recuperado = lector.parse(codigoJSON);
            ArrayJSON = (JSONArray) recuperado;

        } catch (ParseException e) {

            System.out.println("Posicion: " + e.getPosition());
            System.out.println(e);

        }

        return ArrayJSON;

    }

}
