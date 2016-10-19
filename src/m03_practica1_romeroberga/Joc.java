package m03_practica1_romeroberga;

import java.util.ArrayDeque;
import java.util.Deque;

public class Joc {

    Jugador[] listaJugadores;
    private Deque<Ficha> fichasTablero = new ArrayDeque<Ficha>(28);
    private Ficha[] repartirFicha = new Ficha[28];

    static int passadas = 0;
    private int turno;

    private boolean finalizar = false;

    public Jugador[] getListaJugadores() {
        return listaJugadores;
    }

    public void crearJugadores() {
        listaJugadores = new Jugador[4];
        listaJugadores[0] = new Jugador("Jungla");
        listaJugadores[1] = new Jugador("Top");
        listaJugadores[2] = new Jugador("Mid");
        listaJugadores[3] = new Jugador("Adc");

    }

    public void crearFichas() {
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                repartirFicha[pos] = new Ficha(i, j);
                pos++;
            }
        }
    }

    public void repartirFichas() {

        boolean[] escogidas = new boolean[28];
        int repartidas = 0;

        while (repartidas <= 27) {
            int numFicha = (int) (Math.random() * 28);
            System.out.println(numFicha);

            if (escogidas[numFicha] == false) {
                System.out.println(repartirFicha[numFicha].getNum1() + " | " + repartirFicha[numFicha].getNum2());
                escogidas[numFicha] = true;
                repartidas++;

                if (repartidas <= 7) {
                    listaJugadores[0].fichas.add(repartirFicha[numFicha]);
                } else if (repartidas > 7 && repartidas <= 14) {
                    listaJugadores[1].fichas.add(repartirFicha[numFicha]);
                } else if (repartidas > 14 && repartidas <= 21) {
                    listaJugadores[2].fichas.add(repartirFicha[numFicha]);
                } else {
                    listaJugadores[3].fichas.add(repartirFicha[numFicha]);
                }

            }

        }
    }
    
    public int primeraFitxa() {
        int primer = 0, fitxa = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (listaJugadores[i].getFichas().get(j).getNum1() == 6
                        && listaJugadores[i].getFichas().get(j).getNum2() == 6) {
                    primer = i;
                    fitxa = j;
                    System.out.println("primer = "+primer+" fitxa = "+ fitxa);
                    break;
                }
            }
        }
        fichasTablero.addFirst(listaJugadores[primer].getFichas().get(fitxa));
        listaJugadores[primer].getFichas().remove(fitxa);
        return (primer+1);
    }
    
//    public int estatJoc(){
//        
//    }
            
    

}

