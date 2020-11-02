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

    public Atributo calculaValor(Atributo ff) {
        Atributo retorno = ff;
        for (Pocima pocima : pocimas) {
            retorno = pocima.calculaValor(retorno);
        }
        return retorno;
    }
}