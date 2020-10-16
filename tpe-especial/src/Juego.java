public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondas;
    private Mazo mazoDeCartas;

    public Juego(Jugador j1, Jugador j2, int rondas, String mazoPath) {

        // String mazoPath = "./superheroes.json";

        jugador1 = j1;
        jugador2 = j2;
        this.rondas = rondas;
        mazoDeCartas = new Mazo(mazoPath);
    }

    // public void jugar() {
    // comprobarMano();
    // // repartir cartas
    // // si el mazo es impar el jugador1 recibe una carta más. "mano"
    // repartirMazo();
    // // selecciona de su carta un atributo random
    // // comparas atributo con el otro jugador
    // // el que gana recibe las 2 cartas y las pongo al fondo de la pila
    // // intercambiar variables para alternar de jugadores| esMano = true o false
    // comprobarMano();
    // // GoTo 13
    // }

    public void jugar() {
        boolean comprobar = true;
        repartirMazo();
        for (int i = 0; i < rondas; i++) {
            comprobarMano(comprobar);
            System.out.println(jugador1.getMano());
        }
    }

    public boolean comparar(Carta carta, String atributo, Carta carta2) {
        Atributo atributo1 = carta.getAtributoPorNombre(atributo);
        Atributo atributo2 = carta2.getAtributoPorNombre(atributo);
        if (atributo1.getValor() > atributo2.getValor()) {
            return true;
        } else
            return false;
    }

    public void repartirMazo() {
        mazoDeCartas.repartirCartas(jugador1, jugador2);
    }

    public void comprobarMano(boolean comprobar) {
        if (comprobar) {
            if ((jugador1.getMano() == false) && (jugador2.getMano() == false)) {

                jugador1.setMano(true);
            } else {
                if ((jugador1.getMano() == true)) {

                    jugador1.setMano(false);
                    jugador2.setMano(true);
                } else {
                    jugador1.setMano(true);
                    jugador2.setMano(false);
                }
            }
        }
    }
}
