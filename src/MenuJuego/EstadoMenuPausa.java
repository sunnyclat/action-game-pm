/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuJuego;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import HERRAMIENTAS.CargadorRecursos;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import HERRAMIENTAS.EscaladorDeImagen;
import MAQUINA_DE_ESTADO.GestorDeEstados;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.JFrame;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;
import principal.Constantes;
import principal.GestorPrincipal;
import principal.ObjetosEstaticos;
import static principal.guardaYCargaPartida.actualFile;

/**
 *
 * @author samuel ludueña 2021
 */
public class EstadoMenuPausa implements InterfazGestionadorEstados 
{





    
    

    @Override
    public void actualizar() {
             actualiza();
    }

    @Override
    public void dibujar(Graphics g) {

        

    
   
         dibujos(g);
 
    
    

    }
   

    
    
  
          
                
               public static  void dibujos(Graphics g)  {
      


                 g.setFont(Constantes.FUENTE3.deriveFont(40f));
                   
                           
    DibujadorRectangulosImagenes.dibujString(g, "PARTNER", 50, 50, Color.red);
    DibujadorRectangulosImagenes.dibujString(g, "MANNER", 250, 80, Color.blue);
    
    
        DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 280, 250, 80, 40, Color.white);
    
    g.setFont(Constantes.FUENTE2.deriveFont(20f));
     DibujadorRectangulosImagenes.dibujString(g, "Volver", 288, 275, Color.white);


     
         
                   
                   
               }
               
               
               public  void actualiza(){
                   
                        final Rectangle cuadroVolver= new Rectangle(280, 250,80,40);
                    
                        Rectangle posicionMouse= GestorPrincipal.sd.getRaton().obtieneRectanguloPosicion();
 
                    if(GestorPrincipal.sd.getRaton().getClick() &&
                       posicionMouse.intersects(EscaladorDeImagen.escalaRectanguloArriba (cuadroVolver) )){
                   
       
                   
              
              ObjetosEstaticos.teclado.teclaMenuPausa=false;
              
               }else
                    {
                        
                         ObjetosEstaticos.teclado.teclaMenuPausa=true; 
                        
                        
                    }
                    
                    
                    
               }

                
                
                
                
                
    
}
