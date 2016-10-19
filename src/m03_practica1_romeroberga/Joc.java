package m03_practica1_romeroberga;

import java.util.ArrayDeque;
import java.util.Deque;

public class Joc {

    Jugador[] llistaJugadors;
    private Deque<Ficha> fichasTablero = new ArrayDeque<Ficha>(28);
    private Ficha[] repartirFicha = new Ficha[28];

    static int passades = 0;
    private int torn;

    private boolean finalitzar = false;

    public Jugador[] getLlistaJugadors() {
        return llistaJugadors;
    }

    public void crearJugadors() {
        llistaJugadors = new Jugador[4];
        llistaJugadors[0] = new Jugador("Jungla");
        llistaJugadors[1] = new Jugador("Top");
        llistaJugadors[2] = new Jugador("Mid");
        llistaJugadors[3] = new Jugador("Adc");

    }

    public void crearFitxes() {
        int pos = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                repartirFicha[pos] = new Ficha(i, j);
                pos++;
            }
        }
    }

    public void repartirFitxes() {

        boolean[] escollides = new boolean[28];
        int repartides = 0;

        while (repartides <= 27) {
            int numFitxa = (int) (Math.random() * 28);
            System.out.println(numFitxa);

            if (escollides[numFitxa] == false) {
                System.out.println(repartirFicha[numFitxa].getNum1() + " | " + repartirFicha[numFitxa].getNum2());
                escollides[numFitxa] = true;
                repartides++;

                if (repartides <= 7) {
                    llistaJugadors[0].fitxesJugador.add(repartirFicha[numFitxa]);
                } else if (repartides > 7 && repartides <= 14) {
                    llistaJugadors[1].fitxesJugador.add(repartirFicha[numFitxa]);
                } else if (repartides > 14 && repartides <= 21) {
                    llistaJugadors[2].fitxesJugador.add(repartirFicha[numFitxa]);
                } else {
                    llistaJugadors[3].fitxesJugador.add(repartirFicha[numFitxa]);
                }

            }

        }
    }
    
    public int primeraFitxa() {
        int primer = 0, fitxa = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 7; j++) {
                if (llistaJugadors[i].getFitxesJugador().get(j).getNum1() == 6
                        && llistaJugadors[i].getFitxesJugador().get(j).getNum2() == 6) {
                    primer = i;
                    fitxa = j;
                    System.out.println("primer = "+primer+" fitxa = "+ fitxa);
                    break;
                }
            }
        }
        fichasTablero.addFirst(llistaJugadors[primer].getFitxesJugador().get(fitxa));
        llistaJugadors[primer].getFitxesJugador().remove(fitxa);
        return (primer+1);
    }
    
//    public int estatJoc(){
//        
//    }
            
    

}

