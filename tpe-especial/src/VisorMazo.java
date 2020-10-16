import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VisorMazo {






        //-------------------------------------------------------------------------------------------------------
        // version fea, queda solo para referencia





    public static void mostrarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            //Se guardan todas las cartas en una especie de "array" de jsons
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            //Cartas : {"nombre":"Superman","atributos":{"altura":205,"peso":110,"fuerza":2000}}
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                //carta : {"nombre":"Hulk","atributos":{"altura":240,"peso":450,"fuerza":2500}}
                //getString devuelve el nombre o lo que le pidas dentro del array
                String nombreCarta = carta.getString("nombre");

                //guarda en un objeto todos los atributos
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                // System.out.println(atr);


                //boolean cosa = atributos.containsKey("atributos");
                //System.out.println(atributos);

                // atributos es otro json ej: {"altura":205,"peso":110,"fuerza":2000}

                //crea un string concatenado
                //  String atributosStr = "";
                // for (String nombreAtributo:atributos.keySet())
                //    atributosStr = atributosStr + nombreAtributo + ": " +
                //             atributos.getInt(nombreAtributo) + "; ";
                //System.out.println(nombreCarta+"\t\t\t"+atributosStr);
            }

            //deja de leer el json..?
            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //le das el path y te lo muestra
        String mazoPath = "./superheroes.json";
        VisorMazo.mostrarMazo(mazoPath);
    }

}

