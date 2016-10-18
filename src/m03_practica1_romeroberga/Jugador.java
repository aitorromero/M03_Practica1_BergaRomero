package m03_practica1_romeroberga;

import java.util.ArrayList;

public class Jugador {
    private String nom;
    private ArrayList<Ficha> fichas;
    
    public Jugador (String nom){
        this.nom = nom;
        fichas=new ArrayList();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    public void mostrarFichas() {
        System.out.println("Jugador " + nom + ", té " + fichas.size() + " fitxes.");
        for (int j = 0; j < fichas.size(); j++) {
            System.out.println("Fitxa numero " + j + "-> " + fichas.get(j) + " | ");
        }
    }
}
