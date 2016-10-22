
package m03_practica1_romeroberga;



public class Main {

    public static void main(String[] args) throws InterruptedException {
       
        Joc joc = new Joc();
        Jugada jugada = new Jugada();


        
        joc.crearJugadores();
        joc.crearFichas();
        joc.repartirFichas();
        
        for (int i = 0; i < 4; i++) {
            joc.listaJugadores[i].mostrarMano();
        }
        
        Thread.sleep(800);
        System.out.println(" Saque inicial ");
//        Thread.sleep(1800);
        
        
        joc.primeraFicha();

        for (int i = 0; i < 4; i++) {
            joc.listaJugadores[i].mostrarMano();
            
        }
        
        joc.manoJugadorActual();
        
        while(true){
            jugada.menuJugada();
        }

    }
 
    
}
