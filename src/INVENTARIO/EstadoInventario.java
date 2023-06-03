<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import INVENTARIO.EstructSeccionInventarioPrinc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import GRAFICOS.LectorCanvas;
import ITEMSYARMAS.Items;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoInventario implements InterfazGestionadorEstados {

    
    private final LectorCanvas sd;
    
    private final DiseñoInventarioPrinc em;
    
    
    private final SeccionesInventario [] secciones;
    
    private  SeccionesInventario seccionActual;
    
    
    
    
    public EstadoInventario(final LectorCanvas sd){
    
        
        this.sd=sd;
        
      em=new DiseñoInventarioPrinc();
        
        secciones= new SeccionesInventario[2];
        

        
        final Rectangle etiquetInv= new Rectangle (em.BANNER_LAT.x  + em.MARGEN_HORIZ_ETIQUET, 
                em.BANNER_LAT.y + em.MARGEN_VERT_ETIQUET,em.ANCHO_ETIQUET,em.ALTO_ETIQUET);
         
        
        
        secciones[0]= new EstructSeccionInventarioPrinc("Inventario",etiquetInv,em);
        
        final Rectangle etiquetEquipo= new Rectangle(em.BANNER_LAT.x + em.MARGEN_HORIZ_ETIQUET,etiquetInv.y + etiquetInv.height 
                + em.MARGEN_VERT_ETIQUET,em.ANCHO_ETIQUET,em.ALTO_ETIQUET);
        
        
        
        secciones[1]= new EstructSeccionInventarioEquipo("Equipo", etiquetEquipo,em);
        
        
        seccionActual= secciones[0];
        
    }
    
   
    
    
    
    
    
    
    @Override
    public void actualizar() {
        
     for(int i=0; i<secciones.length;i++){
         
         if(sd.getRaton().getClick() 
                 && sd.getRaton().obtieneRectanguloPosicion().intersects(secciones[i].obtieneEtiqueMenuEscal() )  ){
            
             /*
             if(secciones[i] instanceof EstructSeccionInventarioEquipo){
              
                 EstructSeccionInventarioEquipo secc = (EstructSeccionInventarioEquipo) secciones[i];
                 
                 if(secc.ItemSeleccionado != null){
                     
                     secc.eliminarItemSeleccion();
                     
                     
                 }
                 
                 
                 
             }
             
             
             
             */
             
             
             
             /*
             
                 if(secciones[i] instanceof EstructSeccionInventarioPrinc){
              
                 EstructSeccionInventarioPrinc secc = (EstructSeccionInventarioPrinc) secciones[i];
                 
                 if(secc.ItemSeleccionado != null){
                     
                     secc.eliminarItemSeleccion();
                     
                     
                 }
                 
                 
                 
             }
             
             
             */
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             seccionActual= secciones[i];
             
         }
         
     }
     
       seccionActual.actualizar();
     

     
     
   
     
    }
    
 
    
    

    
    @Override
    public void dibujar(Graphics g) {
        
        em.dibujar(g);

for(int i=0; i<secciones.length;i++){
  
    
    
    
    
    
    if(seccionActual== secciones[i]){
        
        if( sd.getRaton().obtieneRectanguloPosicion().intersects(secciones[i].obtieneEtiqueMenuEscal() )) {
        
        secciones[i].dibujEtiqueActResalt(g);

        }  else{
              secciones[i].dibujEtiqueAct(g); 
 
        } 
        
   
    }else{
        
         if( sd.getRaton().obtieneRectanguloPosicion().intersects( secciones[i].obtieneEtiqueMenuEscal()    ) ){
        
                    secciones[i].dibujEtiqueInacResalt(g);
          
         }  else{
                    secciones[i].dibujEtiqueInact(g);
    
         }

        
    }
}



seccionActual.dibujar(g,sd);






    }


    
    
    
    
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INVENTARIO;

import INVENTARIO.EstructSeccionInventarioPrinc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import GRAFICOS.LectorCanvas;
import ITEMSYARMAS.Items;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoInventario implements InterfazGestionadorEstados {

    
    private final LectorCanvas sd;
    
    private final DiseñoInventarioPrinc em;
    
    
    private final SeccionesInventario [] secciones;
    
    private  SeccionesInventario seccionActual;
    
    
    
    
    public EstadoInventario(final LectorCanvas sd){
    
        
        this.sd=sd;
        
      em=new DiseñoInventarioPrinc();
        
        secciones= new SeccionesInventario[2];
        

        
        final Rectangle etiquetInv= new Rectangle (em.BANNER_LAT.x  + em.MARGEN_HORIZ_ETIQUET, 
                em.BANNER_LAT.y + em.MARGEN_VERT_ETIQUET,em.ANCHO_ETIQUET,em.ALTO_ETIQUET);
         
        
        
        secciones[0]= new EstructSeccionInventarioPrinc("Inventario",etiquetInv,em);
        
        final Rectangle etiquetEquipo= new Rectangle(em.BANNER_LAT.x + em.MARGEN_HORIZ_ETIQUET,etiquetInv.y + etiquetInv.height 
                + em.MARGEN_VERT_ETIQUET,em.ANCHO_ETIQUET,em.ALTO_ETIQUET);
        
        
        
        secciones[1]= new EstructSeccionInventarioEquipo("Equipo", etiquetEquipo,em);
        
        
        seccionActual= secciones[0];
        
    }
    
   
    
    
    
    
    
    
    @Override
    public void actualizar() {
        
     for(int i=0; i<secciones.length;i++){
         
         if(sd.getRaton().getClick() 
                 && sd.getRaton().obtieneRectanguloPosicion().intersects(secciones[i].obtieneEtiqueMenuEscal() )  ){
            
             /*
             if(secciones[i] instanceof EstructSeccionInventarioEquipo){
              
                 EstructSeccionInventarioEquipo secc = (EstructSeccionInventarioEquipo) secciones[i];
                 
                 if(secc.ItemSeleccionado != null){
                     
                     secc.eliminarItemSeleccion();
                     
                     
                 }
                 
                 
                 
             }
             
             
             
             */
             
             
             
             /*
             
                 if(secciones[i] instanceof EstructSeccionInventarioPrinc){
              
                 EstructSeccionInventarioPrinc secc = (EstructSeccionInventarioPrinc) secciones[i];
                 
                 if(secc.ItemSeleccionado != null){
                     
                     secc.eliminarItemSeleccion();
                     
                     
                 }
                 
                 
                 
             }
             
             
             */
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             seccionActual= secciones[i];
             
         }
         
     }
     
       seccionActual.actualizar();
     

     
     
   
     
    }
    
 
    
    

    
    @Override
    public void dibujar(Graphics g) {
        
        em.dibujar(g);

for(int i=0; i<secciones.length;i++){
  
    
    
    
    
    
    if(seccionActual== secciones[i]){
        
        if( sd.getRaton().obtieneRectanguloPosicion().intersects(secciones[i].obtieneEtiqueMenuEscal() )) {
        
        secciones[i].dibujEtiqueActResalt(g);

        }  else{
              secciones[i].dibujEtiqueAct(g); 
 
        } 
        
   
    }else{
        
         if( sd.getRaton().obtieneRectanguloPosicion().intersects( secciones[i].obtieneEtiqueMenuEscal()    ) ){
        
                    secciones[i].dibujEtiqueInacResalt(g);
          
         }  else{
                    secciones[i].dibujEtiqueInact(g);
    
         }

        
    }
}



seccionActual.dibujar(g,sd);






    }


    
    
    
    
    
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
