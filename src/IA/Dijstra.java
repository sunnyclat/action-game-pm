/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IA;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import principal.Constantes;
import Enemigos.Enemigos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Dijstra {
    
    
    private int anchoMapaTiles;
    private int altoMapaTiles;
    
    
    
    private  ArrayList <Nodo> nodosMapa;
    
    
    private  ArrayList <Nodo> enEspera;
    
        private  ArrayList <Nodo> visitados;
       
        private boolean flag = true; //es un flag el cual almacenara que en el codigo algo ha pasado
        
        
        public Dijstra(final Point centroCalc, final int anchoMapaTiles,
                final int altoMapaTiles, final ArrayList <Rectangle> zonasSolidas){
        
            
            this.anchoMapaTiles= anchoMapaTiles;
            this.altoMapaTiles=altoMapaTiles;
            
            
            nodosMapa= new ArrayList<>();
            
            
            
            for( int y = 0; y< altoMapaTiles;y++){
                
                for(int x= 0; x < anchoMapaTiles; x++){
                    
                    final int lado= Constantes.LADO_SPRITE;
                    
                    final Rectangle localizacionNodo= new Rectangle (x * lado, y * lado,lado,lado);
                    
                    
                    boolean transitable = true;
                    
                    for(Rectangle i : zonasSolidas){
                        
                        
                        if(localizacionNodo.intersects(i)){
                            transitable = false;
                            break;
                            
                            
                            
                        }
                        
                        
                        
                        
                    }
                     
                    if(!transitable){     //si es un tile solido (no transitable) no entra en el algoritmo
                        continue;  
                    }
                    
                    
                    
                    Nodo nodo = new Nodo(new Point (x,y), Double.MAX_VALUE); //el valor maximo de la clase double (equivalente a infinito)
                    
                    nodosMapa.add(nodo); //añadimos al nodo transitable.
                    
                }
                
                
            }
            
            enEspera = new ArrayList<>(nodosMapa); //pasamos otro arraylist siendo nodosMapa sin tener puntuacion
            
            
            reiniciaEvalua(centroCalc);
            
            
            flag = false;
            
            
            
            
            
            
        }
        
        public Point obtieneCoordenadaNodoCrucePersona(final Point puntoPersonaje){
            
            Rectangle rectaPuntoJusto= new Rectangle (puntoPersonaje.x / Constantes.LADO_SPRITE,
          
                    puntoPersonaje.y / Constantes.LADO_SPRITE, 1, 1);  //un rectangulo de un pixel ya que es imposible que el jugador este en mas de un nodo a la vez
            
            Point puntoJusto=null;
            
            
            for(Nodo nodo : nodosMapa){
                
                if( nodo.getArea().intersects(rectaPuntoJusto)){  //si el personaje va a cruzar algun nodo
                     
              
                    
                    puntoJusto= new Point(rectaPuntoJusto.x, rectaPuntoJusto.y);
                    
                   //   System.out.println(puntoJusto);  
                    
                    return puntoJusto;
                    
                    
                }
                
                
                    
                  
                
                
                
            }
            
            
            return puntoJusto;
            
        }
        
        
        private ArrayList <Nodo> clonaNodoMapaHaciaNodosEnEspera(){
            
            ArrayList <Nodo> nodosClonados= new ArrayList<>();
            
            for(Nodo nodo: nodosMapa){
                
                Point posicion = nodo.getPosicion();
                
                double distancia = nodo.getDistancia();
                
                Nodo nodoClonado= new Nodo(posicion, distancia);
                
                nodosClonados.add(nodoClonado);
                
                
                
                
                
                
                
                
                
            }
            
            return nodosClonados;
            
        }
        
        public void reiniciaEvalua(final Point centroCalc){
        
            if(!flag){
                if(visitados.size() == 0){ // si ningun nodo ha sido visitado
                   clonaNodoMapaHaciaNodosEnEspera();
                    
                    
                }else {
                    
                    
                    enEspera= new ArrayList<>(visitados);//el arraylist enEspera va a tomar como referencia todos los elementos que esten en visitados
                    
                    for(Nodo nodo : enEspera){
                        
                        nodo.setDistancia(Double.MAX_VALUE);
                        
                        
                    }
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
            }
            
            definirCentroCalculoEnEspera(centroCalc); //definimos el calculo de la lista de espera
            
            visitados= new ArrayList<>();//dejamos vacia la lista de visitados
            
            evaluaHeuristicaGlobal();//puntuamos todos los nodos
            
              
        
        
        }
            
            
           
            
            
            
            
            
            
            
            
     
        
        private ArrayList <Nodo> obtieneNodosVecinos(Nodo nodo)  {           //los nodos vecinos disponibles para dijstra
            
            int iniciaY= nodo.getPosicion().y;
             int iniciaX= nodo.getPosicion().x;
             
             
             ArrayList <Nodo> nodosVecinos = new ArrayList<>();
             
              for(int y= iniciaY - 1 ; y < iniciaY + 2; y++){
                
                for(int x = iniciaX - 1; x < iniciaX + 2 ; x++){
                    
                    if(x <= -1 || y <= -1 || x >= anchoMapaTiles ||   //si no esta fuera del mapa
                            y >= altoMapaTiles){
                    
                       continue;
                    
                    
                    }
                    
                 
                    if(iniciaX == x && iniciaY == y){  //si no es el nodo central dond esta el enemigo
                        
                        continue;
                        
                        
                    }
                    
                    
                    
                    int indiceNodo = obtieneIndiceNodoEnVisitadosPosicion(new Point(x,y));    
                    
                    
                    if(indiceNodo == - 1){ //si el nodo no existe, pasa de largo.
                        
                        continue;
                    }
                    
                    
                   nodosVecinos.add(visitados.get(indiceNodo));
                    
                    
                }
                    
                 
                
                
                
                
                
                
                
                    
                    
                    
                }
                
                
                return nodosVecinos;
                
                
             
        } 
        
        public Nodo encuentraSigNodoParaEnemigo(Enemigos enemigo){
         
            ArrayList <Nodo> nodosAfectados = new ArrayList<>();
            
            Nodo sigNodo= null;
            
            for(Nodo nodo : visitados){
                
                if(enemigo.obtieneAreaPosicion().intersects(nodo.obtieneAreaPixeles())){
                    
                    nodosAfectados.add(nodo);
                    
                    
                    
                }
                
                
                
                
                
            }
            
            if(nodosAfectados.size() == 1){ //si de suerte el enemigo se encuentra en un solo nodo, lo cual es dificil.
                Nodo nodoBase= nodosAfectados.get(0); //tomamos el nodo 1.
                
                
                nodosAfectados = obtieneNodosVecinos(nodoBase);
                
                
                
            }
            
            //si el enemigo esta en mas de un nodo, lo dirigimos a que este en solo uno
            
            
            for(int i=0; i < nodosAfectados.size();i++){
                
                if(i==0){
                    
                    sigNodo= nodosAfectados.get(0);
                }else {
                    //si la distancia del nodo es mayor por la de los siguientes nodos que estamos iterando
                    if(sigNodo.getDistancia() > nodosAfectados.get(i).getDistancia()){
                        
                        sigNodo= nodosAfectados.get(i);
                        
                        
                        
                    }
                    
                    
                }
                
                
                
                
            }
            
            
            
            return sigNodo;
            
            
            
            
        }
        

        private void definirCentroCalculoEnEspera(final Point centroCalc){
            
            for(Nodo nodo : enEspera){
            
                if(nodo.getPosicion().equals(centroCalc)){
                    nodo.setDistancia(0.0);
                }
                
                
                
                
        }
            
            
            
            
            
        }
        
        
        private void evaluaHeuristicaGlobal(){
            
            while(!enEspera.isEmpty()){
                
                
                int cambios=0;
                
                
                for(Iterator <Nodo> iterador = enEspera.iterator(); iterador.hasNext();){
                    
                    
                    Nodo nodo= iterador.next();   //nos da el nodo que necesitamos
                    
                    
                    if(nodo.getDistancia() == Double.MAX_VALUE){  //si el nodo tiene valor infinito en distancia, es que todavia no fue puntuado por lo que tampoco sus vecinos
                        continue;                                //por esto pasamos de este nodo
                    }else{   //si el nodo no es infinito
                        //evaluamos la heuristica de sus vecinos
                        
                        evaluaHeuristicaVecinos(nodo);
                        
                        visitados.add(nodo);        // agregamos a los visitados los nodos puntuados en vecinos
                        iterador.remove();          // vamos a usar el iterador remove para remover los nodos puntuados mientras se sigue recorriendo
                        cambios++;           //guardamos que hemos hecho un cambio.
                        
                        
                        
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                }
                
                
                if(cambios ==0){  //si ningun nodo ha sido puntuado, saldremos del algoritmo. ya que de alguna manera todos fueron puntuados.
                    break;
                }
                
                
                
                
                
                
                
            }
            
            
            
            
        }
        
        
        private void evaluaHeuristicaVecinos(final Nodo nodo){
            
            int iniciaY= nodo.getPosicion().y;
            
            int iniciaX= nodo.getPosicion().x;
            
            
            
            final double DIST_DIAGONAL = 1.42412;   
            
            
            for(int y= iniciaY - 1 ; y< iniciaY + 2; y++){
                
                for(int x = iniciaX - 1; x < iniciaX + 2 ; x++){
                    
                    //dentro del rango del mapa
                    
                    
                    if(x <= -1 || y <= -1 || x>= anchoMapaTiles - 1 || y >= altoMapaTiles){
                        
                        continue;
                    }
                    
                    //omitimos a nuestro propio nodo
                    if(iniciaX == x && iniciaY == y){
                        
                        continue;
                        
                        
                        
                        
                    }
                    
                    
                    //si el nodo existe en la posicion
                    
                    
                    int indiceNodo = obtieneIndiceNodoEnEsperaPosicion(new Point(x,y)    );
                    
                    if(indiceNodo == -1){     //menos uno es si no existe
                        continue;
                    }
                 
                    
                    //solo cambiamos la distancia si es transitable y sino ha sido cambiada.
                    
                    if(enEspera.get(indiceNodo).getDistancia()== Double.MAX_VALUE - 1){
                        
                        //evaluamos si la distancia recta o diagonal
                        
                       
                        double distancia;
                      
                        if(iniciaX != x && iniciaY != y){            //si ambos valores son diferentes, evaluamos los 4 tiles en las 4 esquinas de nuestro nodo por lo que seria diagonal
                            
                            distancia = DIST_DIAGONAL;
                            
                            
                            
                        }else {
                        
                        distancia = 1;
                        
                        
                        
                        }
                        
                        enEspera.get(indiceNodo).setDistancia(nodo.getDistancia() + distancia);
                        
                        
                    }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                }
            }
            
            
            
            
            
            
            
            
            
        }
        
        
        
        private int obtieneIndiceNodoEnEsperaPosicion(final Point posicion){
            
            for( Nodo nodo: enEspera){
               
                if(nodo.getPosicion().equals(posicion)){
                    
                    return enEspera.indexOf(nodo);
                    
                    
                }
                
                
                
                
                
            }
            
            
            
            
            
            return - 1;
            
            
            
            
            
            
            
        }
        
        
        
          private int obtieneIndiceNodoEnVisitadosPosicion(final Point posicion){
            
            for( Nodo nodo: visitados){
               
                if(nodo.getPosicion().equals(posicion)){
                    
                    return visitados.indexOf(nodo);
                    
                    
                }
                
                
                
                
                
            }
            
            
            
            
            
            return - 1;
            
            
            
            
            
            
            
        }
        
        
        
        
        
        
        public ArrayList <Nodo> getVisitados(){
            return visitados;
        }
        
        
        
              public ArrayList <Nodo> getEnEspera(){
            return enEspera;
        }
        
        
}
