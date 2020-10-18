import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();

        String mazoPath = "./superheroes.json";

        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pablo");

        Juego2 prueba = new Juego2(jugador1, jugador2, 4, mazoPath);
        prueba.jugar();
    }
}
