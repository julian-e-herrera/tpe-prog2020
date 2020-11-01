import java.util.ArrayList;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorPrincipal;
    private Jugador jugadorOpuesto;
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

    public Juego(Jugador j1, Jugador j2, int rondas, String mazoPath, ArrayList<Pocima> pocimas) {

        jugador1 = j1;
        jugador2 = j2;

        jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

        this.rondas = rondas;

        //uso las pocimas dadas para que el mazo se encargue
        mazoDeCartas = new Mazo(mazoPath, pocimas);
    }

    public void jugar() {

        jugadorPrincipal = iniciarJuego();
        jugadorOpuesto = encontrarOpuesto(jugadorPrincipal);

        jugadorPrincipal.mezclar();
        jugadorOpuesto.mezclar();
        int i = 1;

        while ((i <= rondas) && (jugadorPrincipal.getLargoMazo() > 0) && (jugadorOpuesto.getLargoMazo() > 0)) {

            System.out.println("----------------- " + " ronda " + i + " -----------------");

            Carta cartaPrincipal = jugadorPrincipal.getPrimerCarta();

            Atributo atributo = jugadorPrincipal.elegirAtributo(cartaPrincipal);
            Atributo atributoOpuesto = jugadorOpuesto.getPrimerCarta().getAtributo(atributo);

            // Mostrar por consola
            jugadorPrincipal.mostrarAtributoSeleccionado(atributo);
            jugadorPrincipal.mostrarCartaConValores(atributo);
            jugadorOpuesto.mostrarCartaConValores(atributoOpuesto);

            // que me devuelvan los valores calculados
            Atributo atributoPrincipal = jugadorPrincipal.getPrimerCarta().calcularAtributo(atributo);
            Atributo atributoSecundario = jugadorOpuesto.getPrimerCarta().calcularAtributo(atributoOpuesto);


            // no se porque estaba usando atributos ahora uso ints
            int resultado = atributoPrincipal.getValor() - atributoSecundario.getValor();

            declararGanadorDeRonda(resultado);

            // muestra por consola quien gano
            System.out.println("Gana la ronda " + jugadorPrincipal.getNombre());
            System.out.println(jugadorPrincipal.getNombre() + " posee ahora " + jugadorPrincipal.getLargoMazo()
                    + " cartas y " + jugadorOpuesto.getNombre() + " posee ahora " + jugadorOpuesto.getLargoMazo()
                    + " cartas.");

            i++;
        }

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
