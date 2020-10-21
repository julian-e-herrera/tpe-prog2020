import java.util.ArrayList;

public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorAuxiliar;
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


    public void jugar() {

        jugadorAuxiliar = iniciarJuego();
        jugadorOpuesto = encontrarOpuesto(jugadorAuxiliar);
        
        jugadorAuxiliar.mezclar();
        jugadorOpuesto.mezclar();
        int i = 1;
        
        while ((i <= rondas) && (jugadorAuxiliar.getLargoMazo() > 0) && (jugadorOpuesto.getLargoMazo() > 0)) {
            
            System.out.println("----------------- " + " ronda " + i + " -----------------");

            Atributo atributo = jugadorAuxiliar.elegirAtributo(jugadorAuxiliar.getPrimerCarta());
            Atributo atributoOpuesto = jugadorOpuesto.getPrimerCarta().getAtributo(atributo);

            System.out.println("El jugador " + jugadorAuxiliar.getNombre() + " Selecciona competir por el atributo " + atributo.getNombre());
            System.out.println("La carta de " + jugadorAuxiliar.getNombre() + " es " + jugadorAuxiliar.getPrimerCarta().getNombre()+ " con " + atributo.getNombre() + " " + atributo.getValor());
            System.out.println("La carta de " + jugadorOpuesto.getNombre() + " es " + jugadorOpuesto.getPrimerCarta().getNombre()+ " con " + atributoOpuesto.getNombre() + " " + atributoOpuesto.getValor());
            
            int resultado = jugadorAuxiliar.getPrimerCarta().compare(atributo, atributoOpuesto);
            declararGanadorDeRonda(resultado);
            

            System.out.println("Gana la ronda " + jugadorAuxiliar.getNombre());
            System.out.println(jugadorAuxiliar.getNombre() + " posee ahora " + jugadorAuxiliar.getLargoMazo() + " cartas y " + jugadorOpuesto.getNombre() + " posee ahora " + jugadorOpuesto.getLargoMazo() + " cartas.");

            //María posee ahora 12 cartas y Juan posee ahora 8 cartas
            i++;
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

    public void declararGanadorDeRonda(int resultado) {

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

            Jugador aux = jugadorAuxiliar;
            jugadorAuxiliar = jugadorOpuesto;
            jugadorOpuesto = aux;

        } else {
            jugadorAuxiliar.moverCartaAlFondo(cartaPrincipal);

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
