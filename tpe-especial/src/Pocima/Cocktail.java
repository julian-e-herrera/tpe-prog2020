package Pocima;

import java.util.ArrayList;
import General.Atributo;

public class Cocktail extends Pocima {
    private ArrayList<Pocima> pocimas;

    public Cocktail(String nombre) {
        super(nombre);
        pocimas = new ArrayList<Pocima>();
    }

    public void agregarPocima(Pocima ff) {
        pocimas.add(ff);
    }

    public int calculaValor(Atributo ff) {
        int retorno = 0;
        Atributo aux = new Atributo(ff.getNombre(), ff.getValor());

        for (Pocima pocima : pocimas) {
            retorno = pocima.calculaValor(aux);
            aux.setValor(retorno);
        }
        return retorno;
    }
}
