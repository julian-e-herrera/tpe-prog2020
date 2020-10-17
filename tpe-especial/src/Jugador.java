import java.util.ArrayList;
import java.util.Collections;

public class Jugador {
        private String nombre;
        private boolean esMano;
        private ArrayList<Carta> mazo;

        public Jugador(String nombre) {
                this.nombre = nombre;
                esMano = false;
                mazo = new ArrayList<Carta>();
        }

        public boolean getMano() {
                return esMano;
        }

        public void setMano(boolean esMano) {
                this.esMano = esMano;
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

        public Atributo elegirAtributo(Carta ff) {
                int atributo;

                int atributos = ff.getCantAtributos();

                atributo = (int) (Math.random() * atributos);

                return ff.getAtributo(atributo);
        }
}
