package General;

import java.util.ArrayList;
import java.util.Collections;

import Estrategia.Estrategia;
import Estrategia.EstrategiaTimbero;

public class Jugador {
        private String nombre;
        private ArrayList<Carta> mazo;
        private Estrategia estrategiaJugador;

        public Jugador(String nombre) {
                this.nombre = nombre;
                mazo = new ArrayList<Carta>();
                estrategiaJugador = new EstrategiaTimbero();
        }

        public Jugador(String nombre, Estrategia ff) {
                this.nombre = nombre;
                mazo = new ArrayList<Carta>();
                estrategiaJugador = ff;
        }

        public void cambiarEstrategia(Estrategia ff) {
                estrategiaJugador = ff;
        }

        public String getNombre() {
                return nombre;
        }

        public void addCarta(Carta ff) {
                mazo.add(ff);
        }

        public Carta getPrimerCarta() {
                return mazo.get(0);
        }

        public int getLargoMazo() {
                return mazo.size();
        }

        public void removerPrimerCarta() {
                mazo.remove(0);
        }

        public void removerCarta(Carta ff) {
                mazo.remove(ff);
        }

        public void moverCartaAlFondo(Carta ff) {

                mazo.remove(ff);
                mazo.add(ff);

        }

        public void mezclar() {
                Collections.shuffle(mazo);
        }

        @Override
        public String toString() {
                return nombre + ", " + "Cantidad de cartas: " + this.getLargoMazo();
        }

        public String mostrarAtributoSeleccionado(String ff) {
                String retorno = "El jugador " + this.getNombre() + " selecciona competir por el atributo "
                                + ff ;

                return retorno;
        }

        public String mostrarCartaConValores(String ff) {
                Atributo atributoPrincipal = this.getPrimerCarta().getAtributoPorNombre(ff);

                String retorno = "La carta de " + this.getNombre() + " es " + this.getPrimerCarta().getNombre()
                                + " con " + ff + " " + atributoPrincipal.getValor();

                if (this.getPrimerCarta().getPocima() != null) {
                        retorno += ", se aplicó pócima " + "'" + this.getPrimerCarta().getPocima().getNombre() + "'"
                                        + " valor resultante "
                                        + getPrimerCarta().getPocima().calculaValor(atributoPrincipal);
                }

                return retorno;
        }

        public String elegirAtributo() {
                Carta ff = this.getPrimerCarta();
                return estrategiaJugador.elegirAtributo(ff);
        }
}
