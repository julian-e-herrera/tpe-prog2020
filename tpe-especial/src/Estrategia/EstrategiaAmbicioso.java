package Estrategia;

import General.Atributo;
import General.Carta;

public class EstrategiaAmbicioso implements Estrategia {

    public EstrategiaAmbicioso() {
    }

    @Override
    public String elegirAtributo(Carta ff) {
        int valor = 0;
        Atributo aux = null;
        for (int i = 0; i < ff.getCantAtributos(); i++) {
            Atributo atributoSubi = ff.getAtributo(i);
            if (atributoSubi.getValor() > valor) {
                valor = atributoSubi.getValor();
                aux = atributoSubi;
            }
        }
        return aux.getNombre();
    }
}
