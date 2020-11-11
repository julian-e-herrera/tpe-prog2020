package Pocima;
import General.Atributo;

public abstract class Pocima {
    private String nombre;

    public Pocima(String nombre) {
        this.nombre = nombre;
    }

    public abstract int calculaValor(Atributo ff);

    public String getNombre() {
        return nombre;
    }


    // public abstract Atributo calculaValor(Atributo ff);
}