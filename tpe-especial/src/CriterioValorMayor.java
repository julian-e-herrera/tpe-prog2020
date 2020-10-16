public class CriterioValorMayor extends Criterio{
    private double valor;

    public CriterioValorMayor(double valor) {
        this.valor = valor;
    }

    public boolean cumple(Atributo ff) {
        return ff.getValor() > valor;
    }

}