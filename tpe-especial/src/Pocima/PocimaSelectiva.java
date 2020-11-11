package Pocima;

import General.Atributo;

public class PocimaSelectiva extends PocimaNormal {
    private String selector;

    public PocimaSelectiva(String nombre, String selector, double porcentaje) {
        super(nombre, porcentaje);
        this.selector = selector;
    }

    @Override
    public int calculaValor(Atributo ff) {
        int retorno = ff.getValor();
        if (ff.getNombre().equals(selector)) {
            retorno = super.calculaValor(ff);
        }
        return retorno;
    }
}
