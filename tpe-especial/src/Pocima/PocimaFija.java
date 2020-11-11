package Pocima;
import General.Atributo;

public class PocimaFija extends Pocima{
    private int valor;

    public PocimaFija(String nombre, int valor) {
        super(nombre);
        this.valor = valor;
    }

    @Override
    public int calculaValor(Atributo ff) {
        return valor;
    }
}