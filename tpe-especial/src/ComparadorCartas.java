import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ComparadorCartas {
    private JsonObject atributos;

    public ComparadorCartas() {}

    public boolean esDelMismoTipo(JsonObject carta) {

        //le extraigo los atributos de la carta
        JsonObject atributosCarta = extraerAtributos(carta);

        // si son del mismo tamaño, son parecidas
        if (atributos.size() == atributosCarta.size()) {

            //agarra cada clave de atributo, ojo, LA CLAVE, no el valor
            for (String atributoKey : atributosCarta.keySet()) {

                //si mi lista de atributos no contiene la clave que le doy, ya se que no es del mismo tipo
                if (!(atributos.containsKey(atributoKey))) {
                    return false;
                }
            }
        } else return false;

        //si pasa por todo eso, entonces es del mismo tipo, NO IGUAL
        return true;
        //habra que verificar si hay repetidas? i dunno
    }

    public void setCarta(JsonObject carta) {
        atributos = extraerAtributos(carta);
    }

    public JsonObject extraerAtributos(JsonObject carta) {
        //de la carta, extraigo solo los atributos
        JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
        return atributos;
    }


}
