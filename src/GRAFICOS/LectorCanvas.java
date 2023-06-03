/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRAFICOS;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import principal.GestorPrincipal;
import principal.Constantes;

import PERIFERICOS.Raton;
import PERIFERICOS.Teclado;
import MAQUINA_DE_ESTADO.GestorDeEstados;
import HERRAMIENTAS.InformacionDebug;
import HERRAMIENTAS.DibujadorRectangulosImagenes;
import MAQUINA_DE_ESTADO.InterfazGestionadorEstados;
import MenuJuego.EstadoMenuPausa;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;
import principal.ObjetosEstaticos;

/**
 *
 * @author samuel ludueña 2021
 */
public class LectorCanvas extends Canvas {

    private static final long serialVersionUID = 1L;

    private int ancho;
    private int alto;

    private Raton raton;

//public static final Teclado teclado= new Teclado();
    public LectorCanvas(final int ancho, final int alto) {

        this.ancho = ancho;
        this.alto = alto;

        this.raton = new Raton(this);

        setIgnoreRepaint(true);

        setCursor(raton.getCursor());

        setPreferredSize(new Dimension(ancho, alto));

        //    teclado=new Teclado();
        addKeyListener(ObjetosEstaticos.teclado);
        addMouseListener(raton); //por mouseAdapter

        setFocusable(true);
        requestFocus();

    }

    public void dibujar(final GestorDeEstados ge) {

        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D) buffer.getDrawGraphics(); //debemos castearlo tipo graphics2d para que funcione

        DibujadorRectangulosImagenes.RestartContDibuj();

        if (ObjetosEstaticos.teclado.teclaMenuPausa == false) {
            DibujadorRectangulosImagenes.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO_FULL_SCREEN, Constantes.ALTO_FULL_SCREEN, Color.blue);

        }

        if (Constantes.FACTOR_ESCAL_X != 1.0 || Constantes.FACTOR_ESCAL_Y != 1.0) {

            g.scale(Constantes.FACTOR_ESCAL_X, Constantes.FACTOR_ESCAL_Y);   //escribimos la operacion de escalado
        }

        ge.dibujar(g);

        g.setColor(Color.GREEN);

        g.setFont(Constantes.FUENTE);

        DibujadorRectangulosImagenes.dibujString(g, "FPS: " + GestorPrincipal.getfps(), 10, 10);   //conviene poner estas medidas

        //DibujadorRectangulosImagenes.dibujString(g,"APS: "+GestorPrincipal.getAps(),10,20); //10 pixeles mas abajo que los anteriores
        InformacionDebug.enviaDatos("ESCALA X: " + Constantes.FACTOR_ESCAL_X); //muestra la proporcion de escalado del juego a la pantalla completa
        InformacionDebug.enviaDatos("ESCALA Y: " + Constantes.FACTOR_ESCAL_Y);

        InformacionDebug.enviaDatos("OPF: " + DibujadorRectangulosImagenes.getContDibuj());

        raton.dibujar(g);

       
        if (ObjetosEstaticos.teclado.debug) {
            InformacionDebug.dibujaDatos(g);
        } else {
            InformacionDebug.vaciarDatos();
        }

        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show(); //muestra lo que se esta dibujando

    }

    public Raton getRaton() {

        return raton;
    }

    public void actualizar() {
        raton.actualizar(this);
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}
