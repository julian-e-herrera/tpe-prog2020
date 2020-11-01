package Pocima;
import General.Atributo;

public class PocimaFija extends Pocima{
    private int valor;

    public PocimaFija(String nombre, int valor) {
        super(nombre);
        this.valor = valor;
    }

    @Override
    public Atributo calculaValor(Atributo ff) {
        return new Atributo(ff.getNombre(), valor);
    }
}