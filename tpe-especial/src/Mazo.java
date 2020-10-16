import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Mazo {

    private ArrayList<Carta> mazoCartas;

    public Mazo() {
        mazoCartas = new ArrayList<Carta>();
    }

    public Mazo(String mazoPath) {
        mazoCartas = new ArrayList<Carta>();
        this.procesar(mazoPath);
    }

    public ArrayList<Carta> devolverMazo() {
        return new ArrayList<Carta>(mazoCartas);
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
                Carta cartaAux = new Carta(carta.getString("nombre"));

                // agarro los atributos del json
                JsonObject atributos = carta.getJsonObject("atributos");

                // los recorro
                for (String atributo : atributos.keySet()) {

                    // asigno nombre, valor
                    Atributo atributoAux = new Atributo(atributo, atributos.getInt(atributo));
                    cartaAux.agregarAtributo(atributoAux);
                }
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
            if (cartaReferencia.esMismoTipo(carta)) {
                mazoFiltrado.add(carta);
            }
        }
        mazoCartas.clear();

        for (Carta carta : mazoFiltrado) {
            mazoCartas.add(carta);
        }
    }

    public void repartirCartas(Jugador j1, Jugador j2) {

        // aca falta el shuffle de la interfaz, ni idea como se implementa...TODAVIA

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

}
