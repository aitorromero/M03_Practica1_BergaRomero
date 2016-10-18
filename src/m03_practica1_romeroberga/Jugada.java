package m03_practica1_romeroberga;

import java.util.ArrayList;

public class Jugada {
        String nom;
        ArrayList<Ficha> fichasJugador;

    public Jugador(String nom) {
        this.nom = nom;
        fichasJugador = new ArrayList<Ficha>();
    }

    public ArrayList<Ficha> getFitxesJugador() {
        return fichasJugador;
    }

    public void mostraFitxes() {
        System.out.println("Jugador " + nom + ", té " + fichasJugador.size() + " fitxes.");
        for (int j = 0; j < fichasJugador.size(); j++) {
            System.out.println("Fitxa numero " + j + "-> " + fichasJugador.get(j) + " | ");
        }
    }
}
