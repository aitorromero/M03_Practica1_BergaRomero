package m03_practica1_romeroberga;

import java.util.ArrayList;
import java.util.Arrays;
import static m03_practica1_romeroberga.Joc.actual;
import java.util.Scanner;
import static m03_practica1_romeroberga.Joc.empate;

public class Jugada {
        String nom;
        ArrayList<Ficha> fichasJugador;
        private Scanner lector = new Scanner (System.in);
        private Joc joc;
    
    public Jugada() {
        this.joc = joc;
    }

    
    /**
     * Este método lo que hace es recibir un objeto de tipo ficha por parámetro
     * e intercambiar los valores de la ficha para poder colocarla en el tablero
     * 
     * @param ficha 
     */
    public void cambioOrientacion(Ficha ficha){
        int aux=ficha.getNum1();
        ficha.setNum1(ficha.getNum2());
        ficha.setNum2(aux);
    }
    
    
    /**
     * 
     * Este método será lo que vea cada jugador en su propia jugada, se trata
     * de un menú que recibe un numero y este numero indica que es lo que quiere
     * hacer el jugador.
     * 
     * Si el jugador quiere cambiar la orientacion de la ficha puede hacerlo de
     * tantas fichas com quiera y despues puede escoger entre colocar ficha o pasar
     * turno. 
     * 
     * El método de cambiar orientacion pide el numero de la ficha en el orden
     * en el que esta en su mano para saber que ficha tiene que cambiar. 
     * 
     * 
     * EL SWITCH 2 LO EXPLICA AITORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR lo pongo largo para que lo vea y no se le olvide
     * 
     * 
     * El tercer caso lo que hace es sumar uno a una variable estática que esta 
     * en juego, esto lo que hace es esperar a que llegue a cautro en el main
     * para declarar un empate a cuatro bandas.
     */
     void menuJugada(){
         
//        ArrayList<Ficha> orientar = joc.listaJugadores[actual].mano;

            boolean girada = true;
            
            while(girada){
            
            System.out.println("¿Que quieres hacer ?\n"
                    + "1. Cambiar orientacion de una ficha\n"
                    + "2. Colocar ficha\n"
                    + "3. Pasar turno\n");
                int decision = lector.nextInt();
                
                switch(decision){
                    
                    case 1:

                        System.out.println(" ¿ Que ficha desea voltear (pon numero de la posicion en la que se encuentra) ?");
                        int posicion = lector.nextInt();
                        cambioOrientacion(joc.listaJugadores[actual].mano.get(posicion-1));
                        break;
                        
                        
                    case 2:
                        /* Hacer comentario arriba*/
                        System.out.println(" ¿ Que ficha desea colocar (pon numero de la posicion en la que se encuentra) ?");
                        int fichaAColocar = lector.nextInt();
                        System.out.println(" Donde quieres colocar la ficha:\n"
                                            + "1. Izquierda\n"
                                            + "2. Derecha");
                        int derechaOIzquierda =lector.nextInt();
                        
                        if(joc.colocarFicha(fichaAColocar, derechaOIzquierda)){
                            joc.listaJugadores[actual].mano.remove(fichaAColocar-1);
                        }
                        
                        
                        empate = 0;
                        girada = false;
                        break;
                        
                    case 3:
                        empate ++;
                        girada = false;
                        break;
                        
                }
                
                /*Mostrar tablero*/
        }
    }


}
