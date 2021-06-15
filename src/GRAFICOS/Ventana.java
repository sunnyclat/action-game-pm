/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFICOS;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import principal.Constantes;
import HERRAMIENTAS.CargadorRecursos;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class Ventana extends JFrame {
    
    private static final long serialVersionUID=1L;
    
private String titulo;
   private final ImageIcon icono;


public Ventana(final String titulo, final LectorCanvas sd){
    

 
    
    
    this.titulo=titulo;
    
    
    
  
  
  BufferedImage imagen= CargadorRecursos.cargarImageCompatibleTranslucida(Constantes.RUTA_ICONO);
    
            this.icono= new ImageIcon(imagen);
    
    configurarVentana(sd);
    
    
    
    
    
    
    
    
}

    private void configurarVentana(final LectorCanvas sd) {
        
        setTitle(titulo); //pone el titulo en la cabecera 
       
       
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que no se cierre 
        
        setResizable(false); //lo ponemos en false para que el usuario no pueda modificar la ventana del juego.
        
        setIconImage(icono.getImage()); //buscamos el icono de la ventana donde esta su imagen
        
       
        setLayout(new BorderLayout());
    
        add(sd, BorderLayout.CENTER);

     //  setUndecorated(true);   //con esto le sacamos el borde a la ventana
        pack(); //dar tamaño y formato adecuado a la ventana
        setLocationRelativeTo(null); //para que la ventana aparezca en el medio 
        setVisible(true);
        
        
        
    }
    
    
 




}
