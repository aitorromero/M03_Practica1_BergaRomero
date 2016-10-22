package m03_practica1_romeroberga;

import java.util.ArrayList;

public class Jugador {
    private String nom;
    ArrayList<Ficha> mano;
    
    public Jugador (String nom){
        this.nom = nom;
        mano=new ArrayList();
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Ficha> getFichas() {
        return mano;
    }
//
//    public void setFichas(ArrayList<Ficha> fichas) {
//        this.fichas = fichas;
//    }
    
    public void mostrarMano() {
        System.out.println("Fichas de " + nom + ": " + mano.size());
        for (int i = 0; i < mano.size(); i++) {
            System.out.println(mano.get(i));
        }
    }
}
