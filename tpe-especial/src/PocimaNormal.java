public class PocimaNormal extends Pocima {
    private double porcentaje;

    public PocimaNormal(String nombre, double porcentaje) {
        super(nombre);
        this.porcentaje = porcentaje;
    }

    @Override
    public Atributo calculaValor(Atributo ff) {
        double resultado = ff.getValor() * porcentaje;
        int valorRedondeado = (int) resultado;

        return new Atributo(ff.getNombre(), valorRedondeado);
    }
}
