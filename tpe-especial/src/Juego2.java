import java.util.ArrayList;

public class Juego2 {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondas;
    private Mazo mazoDeCartas;
    private ArrayList<Jugador> jugadores;

    public Juego2(Jugador j1, Jugador j2, int rondas, String mazoPath) {

        // String mazoPath = "./superheroes.json";

        jugador1 = j1;
        jugador2 = j2;

        jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

        this.rondas = rondas;
        mazoDeCartas = new Mazo(mazoPath);
    }

    public void jugar() {

        repartirMazo();

        int i = 0;

        while (i < 4) {
            comprobar();
            i++;
        }

    }

    public void comprobar() {

        Carta cartaPrincipal = jugador1.getPrimerCarta();
        Carta cartaSecundaria = jugador2.getPrimerCarta();

        Atributo atributoPrincipal = jugador1.elegirAtributo(cartaPrincipal);
        Atributo atributoSecundario = cartaSecundaria.getAtributo(atributoPrincipal);

        int resultado = jugador1.getPrimerCarta().compare(atributoPrincipal, atributoSecundario);

        if (resultado > 0) {

            jugador1.moverCartaAlFondo(cartaPrincipal);
            jugador1.addCarta(cartaSecundaria);

            jugador2.removerCarta(cartaSecundaria);

        } else if (resultado < 0) {

            jugador2.moverCartaAlFondo(cartaSecundaria);
            jugador2.addCarta(cartaPrincipal);

            jugador1.removerCarta(cartaPrincipal);

            Jugador aux = jugador1;
            jugador1 = jugador2;
            jugador2 = aux;

            System.out.println(aux);

        } else {
            jugador1.moverCartaAlFondo(cartaPrincipal);
            jugador2.moverCartaAlFondo(cartaSecundaria);

        }

        System.out.println(jugador1);
        System.out.println(jugador2);
    }

    public void repartirMazo() {
        mazoDeCartas.repartirCartas(jugador1, jugador2);

    }
}
