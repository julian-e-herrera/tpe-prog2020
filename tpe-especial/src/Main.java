

public class Main {
    public static void main(String[] args) {

        String mazoPath = "./superheroes.json";

        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pablo");

        Juego prueba = new Juego(jugador1, jugador2, 40, mazoPath);
        prueba.jugar();
    }
}
