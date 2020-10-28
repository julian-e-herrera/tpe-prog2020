import java.util.ArrayList;

public class JuegoConPocima {
    private ArrayList<Pocima> pocimas;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorAuxiliar;
    private Jugador jugadorOpuesto;
    private int rondas;
    private MazoConPocima mazoDeCartas;
    private ArrayList<Jugador> jugadores;

    public JuegoConPocima(Jugador j1, Jugador j2, int rondas, String mazoPath, ArrayList<Pocima> pocimas){
        jugador1 = j1;
        jugador2 = j2;
        jugadores = new ArrayList<Jugador>();
        jugadores.add(j1);
        jugadores.add(j2);

        this.rondas = rondas;
        mazoDeCartas = new MazoConPocima(mazoPath, pocimas);
    }

}
