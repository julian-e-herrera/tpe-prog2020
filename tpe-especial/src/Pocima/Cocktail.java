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

        for (Pocima pocima : pocimas) {
            //si ff tiene en base el numero 5, todos los calculos se hacen con el 5 o con el resultado anterior?
            retorno += pocima.calculaValor(ff);
        }
        return retorno;
    }
}