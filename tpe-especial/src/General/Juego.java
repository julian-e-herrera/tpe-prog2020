package General;

import java.util.ArrayList;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorPrincipal;
    private Jugador jugadorOpuesto;
    private int rondas;
    private Mazo mazoDeCartas;

    private ArrayList<Jugador> jugadores;
    private ArrayList<String> gameLog;

    public Juego(Jugador j1, Jugador j2, int rondas, Mazo mazo) {

        jugador1 = j1;
        jugador2 = j2;

        // creo un araylist para recorrer los jugadores, para encontrar el opuesto

        jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

        this.rondas = rondas;
        this.mazoDeCartas = mazo;
        gameLog = new ArrayList<String>();
    }

    public void jugar() {

        jugadorPrincipal = iniciarJuego();
        jugadorOpuesto = encontrarOpuesto(jugadorPrincipal);

        jugadorPrincipal.mezclar();
        jugadorOpuesto.mezclar();
        int i = 1;

        while ((i <= rondas) && (jugadorPrincipal.getLargoMazo() > 0) && (jugadorOpuesto.getLargoMazo() > 0)) {

            gameLog.add("----------------- " + " ronda " + i + " -----------------");

            String nombreAtributo = jugadorPrincipal.elegirAtributo();

            // Mostrar por consola
            gameLog.add(jugadorPrincipal.mostrarAtributoSeleccionado(nombreAtributo));
            gameLog.add(jugadorPrincipal.mostrarCartaConValores(nombreAtributo));
            gameLog.add(jugadorOpuesto.mostrarCartaConValores(nombreAtributo));

            // que me devuelvan los valores calculados
            int valorAtributoPrincipal = jugadorPrincipal.getPrimerCarta().calcularAtributo(nombreAtributo);
            int valorAtributoSecundario = jugadorOpuesto.getPrimerCarta().calcularAtributo(nombreAtributo);

            int resultado = valorAtributoPrincipal - valorAtributoSecundario;

            declararGanadorDeRonda(resultado);

            // muestra por consola quien gano
            gameLog.add("Gana la ronda " + jugadorPrincipal.getNombre());
            gameLog.add(jugadorPrincipal.getNombre() + " posee ahora " + jugadorPrincipal.getLargoMazo() + " cartas y "
                    + jugadorOpuesto.getNombre() + " posee ahora " + jugadorOpuesto.getLargoMazo() + " cartas.");

            i++;
        }

    }
    public ArrayList<String> getGameLog() {
        return new ArrayList<String>(gameLog);
    }

    public Jugador iniciarJuego() {
        repartirMazo();
        Jugador jugadorPrincipal;

        if (jugador1.getLargoMazo() >= jugador2.getLargoMazo()) {
            jugadorPrincipal = jugador1;
        } else
            jugadorPrincipal = jugador2;
        return jugadorPrincipal;
    }

    public void declararGanadorDeRonda(int resultado) {

        Carta cartaPrincipal = jugadorPrincipal.getPrimerCarta();
        Carta cartaSecundaria = jugadorOpuesto.getPrimerCarta();

        if (resultado > 0) {

            jugadorPrincipal.moverCartaAlFondo(cartaPrincipal);
            jugadorPrincipal.addCarta(cartaSecundaria);

            jugadorOpuesto.removerCarta(cartaSecundaria);

        } else if (resultado < 0) {

            jugadorOpuesto.moverCartaAlFondo(cartaSecundaria);
            jugadorOpuesto.addCarta(cartaPrincipal);

            jugadorPrincipal.removerCarta(cartaPrincipal);

            Jugador aux = jugadorPrincipal;
            jugadorPrincipal = jugadorOpuesto;
            jugadorOpuesto = aux;

        } else {
            jugadorPrincipal.moverCartaAlFondo(cartaPrincipal);

            jugadorOpuesto.moverCartaAlFondo(cartaSecundaria);

        }
    }

    public void imprimir(Jugador ff) {
        System.out.println(ff);
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
}
