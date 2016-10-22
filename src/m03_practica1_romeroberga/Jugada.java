package m03_practica1_romeroberga;

import java.util.ArrayList;
import java.util.Arrays;
import static m03_practica1_romeroberga.Joc.actual;
import java.util.Scanner;

public class Jugada {
        String nom;
        ArrayList<Ficha> fichasJugador;
        private Scanner lector = new Scanner (System.in);
        

    private Joc joc; 
    
        

    public Jugada() {
        this.joc = joc;
    }

    
    
    public void cambioOrientacion(Ficha ficha){
        int aux=ficha.getNum1();
        ficha.setNum1(ficha.getNum2());
        ficha.setNum2(aux);
    }
    
    
    
     void menuJugada(){
         
//        ArrayList<Ficha> orientar = joc.listaJugadores[actual].mano;
                while(true){
            
            System.out.println("¿Que quieres hacer ?\n"
                    + "1. Cambiar orientacion de una ficha\n"
                    + "2. Colocar ficha\n"
                    + "3. Pasar turno\n");
                int decision = lector.nextInt();
                
                switch(decision){
                    
                    case 1:

                        System.out.println(" ¿ Que ficha desear voltear (pon numero de la posicion que se encuentra) ?");
                        int posicion = lector.nextInt();
                        cambioOrientacion(joc.listaJugadores[actual].mano.get(posicion-1));
                              
                }
        }
    }


}
