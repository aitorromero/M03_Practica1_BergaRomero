
package m03_practica1_romeroberga;

import static m03_practica1_romeroberga.Joc.actual;
import static m03_practica1_romeroberga.Joc.empate;



public class Main {
    
    /**
     * Aqui basicamente se crea el juego por orden se van pasando los turnos
     * y se declaran ganador o empate en conjunto.
     * 
     * Simplemente junta lo que hay en otras clases para hacer que el juego funcione
     * 
     * @param args
     * @throws InterruptedException 
     */

    public static void main(String[] args) throws InterruptedException {
       
        Joc joc = new Joc();
        Jugada jugada = new Jugada();


        
        joc.crearJugadores();
        joc.crearFichas();
        joc.repartirFichas();
        
        for (int i = 0; i < 4; i++) {
            joc.listaJugadores[i].mostrarMano();
        }
        

        System.out.println(" Saque inicial ");
        Thread.sleep(1800);
        
        joc.primeraFicha();

        for (int i = 0; i < 4; i++) {
            joc.listaJugadores[i].mostrarMano();
            
        }
        
        joc.manoJugadorActual();
        
        while(true){
            jugada.menuJugada();
            if(actual <3){
                actual++;
            }else{
                actual =0;
            }
            
            joc.comprobacionQuienGana();
            
            if(empate == 4){
                System.out.println("Ha habido un empate y no hay ganador");
                System.exit(0);
            }
            
            
        }

    }
 
    
}
