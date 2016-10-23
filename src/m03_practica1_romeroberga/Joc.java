package m03_practica1_romeroberga;

import java.util.ArrayDeque;
import java.util.Deque;

public class Joc {

    Jugador[] listaJugadores;
    private Deque<Ficha> fichasTablero = new ArrayDeque<Ficha>(28);
    private Ficha[] repartirFicha = new Ficha[28];
    static int empate = 0;
    static int actual = 0;
    private boolean finalizar = false;
    private boolean turnouno = true;
    
    

    public Jugador[] getListaJugadores() {
        return listaJugadores;
    }
 
    /**
     * Este método lo que hace es crear los jugadores que jugarán la partida
     * Se declara  un Array de cuatro jugadores y se les asigna el nombre
     */
    public void crearJugadores() {
        listaJugadores = new Jugador[4];
        listaJugadores[0] = new Jugador("Jungla");
        listaJugadores[1] = new Jugador("Top");
        listaJugadores[2] = new Jugador("Mid");
        listaJugadores[3] = new Jugador("Adc");

    }

    /**
     * Este método lo que hace es rellenar un Array de objetos Ficha que actuaran
     * como fichas, desde la 0 · 0 hasta la 6 · 6
     */
    public void crearFichas() {
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                repartirFicha[pos] = new Ficha(i, j);
                pos++;
            }
        }
    }

    /**
     * Teniendoen cuenta las fichas creadas anteriormente en el método de 
     * crearFichas, declara un array de mismo tamaño pero de false
     * que el de crearFichas yal coger un valor aleatorio entre 0 y el tamaño 
     * actua como referencia al repartirlas entre los jugaodres, por lo que 
     * si no la tenia nadie esta ficha pasa a tenerla un jugador y se marca como true;
     * y si ya la tenia alguien sigue como true y eso hace que esa ficha no se pueda
     * repartir mas.
     * 
     * No esta muy optmizado porque al fin y al cabo son valores al azar y hasta que no toquen
     * todos losvalores al menos una vez no acaba el metodo.
     * 
     */
    public void repartirFichas() {

        boolean[] escogidas = new boolean[28];
        int repartidas = 0;

        while (repartidas <= 27) {
            int numFicha = (int) (Math.random() * 28);
//            System.out.println(numFicha);

            if (escogidas[numFicha] == false) {
//                System.out.println(repartirFicha[numFicha].getNum1() + " | " + repartirFicha[numFicha].getNum2());
                escogidas[numFicha] = true;
                repartidas++;

                if (repartidas <= 7) {
                    listaJugadores[0].mano.add(repartirFicha[numFicha]);
                } else if (repartidas > 7 && repartidas <= 14) {
                    listaJugadores[1].mano.add(repartirFicha[numFicha]);
                } else if (repartidas > 14 && repartidas <= 21) {
                    listaJugadores[2].mano.add(repartirFicha[numFicha]);
                } else {
                    listaJugadores[3].mano.add(repartirFicha[numFicha]);
                }

            }

        }
    }
    
    /**
     * Este método busca entre las cuatro manos de los jugadores quien tiene el
     * doble 6 y se la decarta de la mano para ponersela en el tablero
     * 
     * Se juega con la variable static empieza porque nos servirá para usarla en
     * otros métodos
     */
    public void primeraFicha() {
       
        int  quitar = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (listaJugadores[i].getFichas().get(j).getNum1() == 6
                        && listaJugadores[i].getFichas().get(j).getNum2() == 6) {
                    actual = i;
                    quitar = j;
                    System.out.println("primero : "+ listaJugadores[i].getNom());
             
                    break;
                }
            }
        }
        fichasTablero.addFirst(listaJugadores[actual].getFichas().get(quitar));
        listaJugadores[actual].getFichas().remove(quitar);
    }
    
    /**
     * Aqui se decide quien debe iniciar la partida teniendo en cuenta la variable
     * empieza y se muestra su mano para que pueda escojer que ficha saca
     */
    public void manoJugadorActual(){

            for (int i = actual; i < 4; i++) {
                if(i == 3){
                    i = 0;
                     
                }else{
                    i ++;
                }
                if(turnouno){
                    System.out.println("\n Turno de:" + listaJugadores[i].getNom());
                    for (int j = 0; j < listaJugadores[i].mano.size(); j++) {
                        System.out.println(listaJugadores[i].mano.get(j));
                        turnouno=false;
                    }
                }else{
                    for (int j = 0; j < listaJugadores[i].mano.size(); j++) {
                    System.out.println(listaJugadores[i].mano.get(j));
                   
                }
                }

                actual = i;
                break;
            
        }
    }
    
    public boolean colocarFicha(int fichaAColocar, int derechaOIzquierda){
        boolean boolColocarFicha=false;
        Ficha comparar = fichasTablero.getFirst();
        if(derechaOIzquierda==1 || comparar.getNum2() == listaJugadores[actual].mano.get(fichaAColocar-1).getNum1()){
            
            if(comparar.getNum2() == listaJugadores[actual].mano.get(fichaAColocar-1).getNum1()){
                
                fichasTablero.addFirst(listaJugadores[actual].mano.get(fichaAColocar-1));
                boolColocarFicha = true;
                
            }else{
                
                System.out.println("No se ha podido introducir la ficha, pueba a cambiar su orientacion o pasar turno.");
                
            }
        }else if(derechaOIzquierda==2 || comparar.getNum1() == listaJugadores[actual].mano.get(fichaAColocar-1).getNum2()){
            
            if(comparar.getNum1() == listaJugadores[actual].mano.get(fichaAColocar-1).getNum2()){
                
                fichasTablero.addLast(listaJugadores[actual].mano.get(fichaAColocar-1));
                boolColocarFicha = true;
                
            }else{
                
                System.out.println("No se ha podido introducir la ficha, pueba a cambiar su orientacion o pasar turno.");
                
            }
        }
        
        return boolColocarFicha;
    }
    
    
    /**
     * Este método lo que hace es comprobar que jugador gana en caso que se
     * cumpla el requisito de tener la mano vacía como se vea en if.
     * 
     * En caso negativo sigue la partida
     */
    public void comprobacionQuienGana(){
        if(listaJugadores[actual].mano.isEmpty()){
            System.out.println("El jugador " + listaJugadores[actual].getNom() + " ha ganado la partida.");
            System.exit(0);
        }
    }
    
}

