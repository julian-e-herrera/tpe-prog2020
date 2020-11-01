public class PocimaSelectiva extends Pocima {
    private String selector;
    private double porcentaje;

    public PocimaSelectiva(String nombre, String selector, double porcentaje) {
        super(nombre);
        this.selector = selector;
        this.porcentaje = porcentaje;
    }

    @Override
    public Atributo calculaValor(Atributo ff) {
        Atributo retorno;
        if (ff.getNombre().equals(selector)) {
            double resultado = ff.getValor() * porcentaje;
            int valorRedondeado = (int) resultado;
            retorno = new Atributo(ff.getNombre(), valorRedondeado);
        } else
            retorno = ff;
        return retorno;
    }
}
