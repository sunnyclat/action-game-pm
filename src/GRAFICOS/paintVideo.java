/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFICOS;

import HERRAMIENTAS.DibujadorRectangulosImagenes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import principal.Constantes;

/**
 *
 * @author samuel ludueña 2021
 */
public class paintVideo extends JPanel {
    
    
     public Point p= new Point();
    
//    Image img = Toolkit.getDefaultToolkit().getImage("bullets.gif");
    
     public Image img= new ImageIcon("bullets.gif").getImage();
     
     
          public void PaintComponent(Graphics g){
           
            
    super.paintComponent(g);
    

    // setSize(200,200);
     
     
     
  
     
  //    setLayout(new BorderLayout());
        
        g.drawRect(50, 50,200, 200);
        
    //       setFocusable(true);
     //   requestFocus();
        
        
        
        
        
        
        
      //  DibujadorRectangulosImagenes.dibujImagen2(g, img, p);
        
        
        
    g.setFont(Constantes.FUENTE3.deriveFont(40f));

          DibujadorRectangulosImagenes.dibujString(g, "PARTNER", 50, 50, Color.red);
    DibujadorRectangulosImagenes.dibujString(g, "MANNER", 250, 80, Color.blue);
    
        
          
    g.setFont(Constantes.FUENTE2.deriveFont(20f));
    
    
     DibujadorRectangulosImagenes.dibujarRectanguloVacio(g, 240, 175, 155, 30, Color.black);
     
     
    DibujadorRectangulosImagenes.dibujString(g, "Empezar Partida", 240, 200, Color.black);

   DibujadorRectangulosImagenes.dibujString(g, "Opciones", 270, 230, Color.black);
   
   DibujadorRectangulosImagenes.dibujString(g, "Cargar Partida", 255, 260, Color.black);
   
        DibujadorRectangulosImagenes.dibujString(g, "Salir", 295, 290, Color.black);
        
        
          //  setPreferredSize(new Dimension(200, 200));
    

}

    
}
