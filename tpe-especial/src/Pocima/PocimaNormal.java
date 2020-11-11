package Pocima;
import General.Atributo;

public class PocimaNormal extends Pocima {
    private double porcentaje;

    public PocimaNormal(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }

    @Override
    public int calculaValor(Atributo ff) {
        double resultado = ff.getValor() * porcentaje;
        int valorRedondeado = (int) resultado;

        return valorRedondeado;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
