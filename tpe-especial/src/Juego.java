import java.util.ArrayList;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private int rondas;
    private Mazo mazoDeCartas;
    private ArrayList<Jugador> jugadores;

    public Juego(Jugador j1, Jugador j2, int rondas, String mazoPath) {

        // String mazoPath = "./superheroes.json";

        jugador1 = j1;
        jugador2 = j2;

        // creo un araylist para recorrer los jugadores, para encontrar el opuesto
        // es feo? si, feo como patada en los huevos pero funca

        jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

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

        Jugador jugadorAuxiliar;
        Jugador jugadorOpuesto;

        jugadorAuxiliar = iniciarJuego();
        jugadorOpuesto = encontrarOpuesto(jugadorAuxiliar);

        jugadorAuxiliar.mezclar();
        jugadorOpuesto.mezclar();

        while ((jugadorAuxiliar.getLargoMazo() > 0) && (jugadorOpuesto.getLargoMazo() > 0)) {


            
            Atributo atributo = jugadorAuxiliar.elegirAtributo(jugadorAuxiliar.getPrimerCarta());
            Atributo atributoOpuesto = jugadorOpuesto.getPrimerCarta().getAtributo(atributo);
            
            System.out.println("El jugador " + jugadorAuxiliar.getNombre() + " Selecciona competir por el atributo " + atributo.getNombre());
            

            System.out.println(jugadorAuxiliar);
            System.out.println(jugadorOpuesto);

            System.out.println("-------------------------------------- " + rondas);

            int resultado = jugadorAuxiliar.getPrimerCarta().compare(atributo, atributoOpuesto);


            declararGanadorDeRonda(jugadorAuxiliar, jugadorOpuesto, resultado);

            rondas--;
        }

    }

    public Jugador iniciarJuego() {
        repartirMazo();
        Jugador jugadorAuxiliar;

        if (jugador1.getLargoMazo() >= jugador2.getLargoMazo()) {
            jugadorAuxiliar = jugador1;
        } else
            jugadorAuxiliar = jugador2;
        return jugadorAuxiliar;
    }

    public void declararGanadorDeRonda(Jugador jugadorAuxiliar, Jugador jugadorOpuesto, int resultado) {

        Carta cartaPrincipal = jugadorAuxiliar.getPrimerCarta();
        Carta cartaSecundaria = jugadorOpuesto.getPrimerCarta();

        if (resultado > 0) {

            jugadorAuxiliar.moverCartaAlFondo(cartaPrincipal);
            jugadorAuxiliar.addCarta(cartaSecundaria);

            jugadorOpuesto.removerCarta(cartaSecundaria);

        } else if (resultado < 0) {

            jugadorOpuesto.moverCartaAlFondo(cartaSecundaria);
            jugadorOpuesto.addCarta(cartaPrincipal);

            jugadorAuxiliar.removerCarta(cartaPrincipal);

            // intercambiar jugadores
            Jugador aux = jugadorAuxiliar;
            Jugador aux2 = jugadorOpuesto;

            jugadorAuxiliar = aux2;
            jugadorOpuesto = aux;

        } else {
            jugadorAuxiliar.moverCartaAlFondo(cartaPrincipal);

            jugadorOpuesto.moverCartaAlFondo(cartaSecundaria);
        }
    }

    public Jugador encontrarOpuesto(Jugador ff) {
        Jugador jj = null;

        for (Jugador jugador : jugadores) {
            if (ff.getNombre() != jugador.getNombre()) {
                return jugador;
            }
        }
        return jj;
    }

    public void repartirMazo() {
        mazoDeCartas.repartirCartas(jugador1, jugador2);

    }

    // public void comprobarMano() {
    // if ((jugador1.getMano() == true)) {

    // jugador1.setMano(false);
    // jugador2.setMano(true);
    // } else {
    // jugador1.setMano(true);
    // jugador2.setMano(false);
    // }
    // }
}
