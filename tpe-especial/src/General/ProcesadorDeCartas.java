package General;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ProcesadorDeCartas {

    private ArrayList<Carta> mazoCartas;
    private String path;

    public ProcesadorDeCartas(String mazoPath) {
        mazoCartas = new ArrayList<Carta>();
        this.path = mazoPath;
        procesar(path);
    }

    public void procesar(String jsonFile) {

        // me trae el json entero
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

    public ArrayList<Carta> devolverMazoFiltrado() {
        return new ArrayList<Carta>(mazoCartas);
    }
}
