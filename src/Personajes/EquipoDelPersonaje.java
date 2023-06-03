<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import ITEMSYARMAS.Armas;
import ITEMSYARMAS.SinArmas;


/**
 *
 * @author samuel ludueña 2021
 */
public class EquipoDelPersonaje {
    
    
    private Armas pistola;
        private Armas espada;
    private String armadura;
    private Armas SinArmas;
   

  
    int municion;
    String cinturon;
    
    
    public EquipoDelPersonaje( final Armas SinArmas, final Armas Espada,final Armas Pistola){
        
        
        this.SinArmas=SinArmas;
    
    this.pistola=Pistola;
         this.espada=Espada; 
        

  
  
    }
    
    
    public EquipoDelPersonaje(){
        
        
    }
    
   
       
    public Armas getSinArmas(){
        return  SinArmas;
    }
    
    
    public Armas getPistola(){
        return  pistola;
    }
    
      public Armas getEspada(){
        return  espada;
    }
    
    
    public void setPistola(final Armas pistola){
        this.pistola=pistola;
    }
    
      public void setEspada(final Armas espada){
        this.espada=espada;
    }
    
        public void setSinArmas(final Armas SinArmas){
        this.SinArmas=SinArmas;
    }
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personajes;

import ITEMSYARMAS.Armas;
import ITEMSYARMAS.SinArmas;
import ITEMSYARMAS.SinArmas2;

/**
 *
 * @author samuel ludueña 2021
 */
public class EquipoDelPersonaje {
    
    
    private Armas pistola;
        private Armas espada;
    private String armadura;
    private Armas SinArmas;
   
  
    int municion;
    String cinturon;
    
    
    public EquipoDelPersonaje( final Armas SinArmas, final Armas Espada,final Armas Pistola){
        
        
        this.SinArmas=SinArmas;
    
    this.pistola=Pistola;
         this.espada=Espada; 
        

  
  
    }
    
   
       
    public Armas getSinArmas(){
        return  SinArmas;
    }
    
    
    public Armas getPistola(){
        return  pistola;
    }
    
      public Armas getEspada(){
        return  espada;
    }
    
    
    public void setPistola(final Armas pistola){
        this.pistola=pistola;
    }
    
      public void setEspada(final Armas espada){
        this.espada=espada;
    }
    
        public void setSinArmas(final Armas SinArmas){
        this.SinArmas=SinArmas;
    }
    
    
}
>>>>>>> e8c878ba040690293b6b5e93546b483205c809c9
