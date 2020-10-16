import java.util.ArrayList;

public class Jugador {
        private String nombre;
        private boolean esMano;
        private ArrayList<Carta> mazo;

        public Jugador(String nombre){
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

        public int getLargoMazo(){
                return mazo.size();
        }

        public void removerPrimerCarta() {
                mazo.remove(getPrimerCarta());
        }

        public void removerCarta(Carta ff){
                mazo.remove(ff);
        }

        public void CartaAlFinalDelMazo(Carta ff) {

                Carta aux = ff;

                if (mazo.contains(ff)) {
                        mazo.remove(ff);
                }

                mazo.add(mazo.size(), aux);

        }

        public String elegirAtributo(Carta ff) {
                int atributo;

                int atributos = ff.getCantAtributos();

                atributo = (int) (Math.random() * atributos);
                
                return ff.getAtributo(atributo).getNombre();
        }
}
