import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private ArrayList<Carta> mazoCartas;
    private ArrayList<Pocima> pocimas;

    public Mazo() {
        mazoCartas = new ArrayList<Carta>();
        pocimas = new ArrayList<Pocima>();
    }

    public Mazo(String mazoPath) {
        mazoCartas = new ArrayList<Carta>();
        pocimas = new ArrayList<Pocima>();
        this.procesar(mazoPath);
    }

    public Mazo(String mazoPath, ArrayList<Pocima> pocimas) {
        mazoCartas = new ArrayList<Carta>();
        this.pocimas = new ArrayList<Pocima>(pocimas);
        this.procesar(mazoPath);
    }

    protected ArrayList<Carta> getMazo() {
        return new ArrayList<Carta>(mazoCartas);
    }

    public boolean contieneCarta(Carta ff) {
        boolean contiene = false;

        for (Carta carta : mazoCartas) {
            if (carta.esIgual(ff)) {
                return true;
            }
        }
        return contiene;
    }

    public void procesar(String jsonFile) {

        // ni puta idea que hace esto, pero me trae el json entero
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            // Se guardan todas las cartas en una especie de "array" de jsons
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");

            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                // cartaAux es una carta creada donde le asigno el nombre

                // agarro los atributos del json
                JsonObject atributos = carta.getJsonObject("atributos");
                ArrayList<Atributo> atributosDeCarta = new ArrayList<Atributo>();
                // los recorro
                for (String atributo : atributos.keySet()) {

                    // asigno nombre, valor
                    Atributo atributoAux = new Atributo(atributo, atributos.getInt(atributo));
                    atributosDeCarta.add(atributoAux);
                }
                Carta cartaAux = new Carta(carta.getString("nombre"), atributosDeCarta);
                mazoCartas.add(cartaAux);
            }

            reader.close();

            filtrarPorCarta(mazoCartas.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void filtrarPorCarta(Carta cartaReferencia) {
        ArrayList<Carta> mazoFiltrado = new ArrayList<Carta>();
        for (Carta carta : mazoCartas) {
            if (cartaReferencia.equals(carta)) {
                mazoFiltrado.add(carta);
            }
        }
        mazoCartas.clear();

        for (Carta carta : mazoFiltrado) {
            mazoCartas.add(carta);
        }
    }

    public void repartirCartas(Jugador j1, Jugador j2) {

        Collections.shuffle(mazoCartas);

        if (pocimas.size() > 0) {
            repartirPociones();
        }

        // si el mazo es par...
        if (mazoCartas.size() % 2 == 0) {

            for (int i = 0; i < mazoCartas.size() / 2; i++) {
                j1.addCarta(mazoCartas.get(i));
            }
            for (int i = mazoCartas.size() / 2; i < mazoCartas.size(); i++) {
                j2.addCarta(mazoCartas.get(i));
            }
        } else {
            // aca el j1 recibe una carta más porque la cantidad de cartas es impar
            int mitadYPoquito = Math.round(mazoCartas.size() / 2);

            for (int i = 0; i < mitadYPoquito; i++) {
                j1.addCarta(mazoCartas.get(i));
            }
            for (int i = mitadYPoquito; i < mazoCartas.size(); i++) {
                j2.addCarta(mazoCartas.get(i));
            }
        }

    }

    private void repartirPociones() {
        int posicionElegida;

        for (Pocima pocima : pocimas) {
            posicionElegida = (int) (Math.random() * mazoCartas.size());

            Carta aux;
            aux = mazoCartas.get(posicionElegida);

            aux.setPocima(pocima);
        }
    }

}
