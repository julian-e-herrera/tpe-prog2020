package General;

import Pocima.Pocima;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private ArrayList<Carta> mazoCartas;
    private ArrayList<Pocima> pocimas;

    public Mazo(ArrayList<Carta> cartas) {
        mazoCartas = new ArrayList<Carta>(cartas);
        pocimas = new ArrayList<Pocima>();
    }

    public Mazo(ArrayList<Carta> cartas, ArrayList<Pocima> pocimas) {
        mazoCartas = new ArrayList<Carta>(cartas);
        this.pocimas = new ArrayList<Pocima>(pocimas);
    }

    public void repartirCartas(Jugador j1, Jugador j2) {

        Collections.shuffle(mazoCartas);

        if (pocimas.size() > 0) {
            repartirPociones();
        }

        // si el mazo es par...
        if (mazoCartas.size() % 2 == 0) {

            for (int i = 0; i < mazoCartas.size() / 2; i++) {
                j1.addCarta(mazoCartas.get(i));
            }
            for (int i = mazoCartas.size() / 2; i < mazoCartas.size(); i++) {
                j2.addCarta(mazoCartas.get(i));
            }
        } else {
            // aca el j1 recibe una carta más porque la cantidad de cartas es impar
            int mitadYPoquito = Math.round(mazoCartas.size() / 2);

            for (int i = 0; i < mitadYPoquito; i++) {
                j1.addCarta(mazoCartas.get(i));
            }
            for (int i = mitadYPoquito; i < mazoCartas.size(); i++) {
                j2.addCarta(mazoCartas.get(i));
            }
        }

    }

    private void repartirPociones() {
        int posicionElegida;

        for (Pocima pocima : pocimas) {
            posicionElegida = (int) (Math.random() * mazoCartas.size());

            Carta aux;
            aux = mazoCartas.get(posicionElegida);

            aux.setPocima(pocima);
        }
    }

}
