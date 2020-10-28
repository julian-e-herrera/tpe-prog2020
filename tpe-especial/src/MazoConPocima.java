import java.util.ArrayList;
import java.util.Collections;

public class MazoConPocima extends Mazo {
    private ArrayList<Pocima> pocimas;
    private ArrayList<Carta> mazoCartas;

    public MazoConPocima(String mazoPath, ArrayList<Pocima> pocimas) {
        super(mazoPath);
        this.pocimas = pocimas;
        mazoCartas = super.getMazo();
    }

    @Override
    public void repartirCartas(Jugador j1, Jugador j2) {

        repartirPociones();
        
        Collections.shuffle(mazoCartas);

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

            CartaConPocima aux2 = new CartaConPocima(aux, pocima);

            mazoCartas.remove(posicionElegida);
            mazoCartas.add(posicionElegida, aux2);

        }

    }
}
