
public abstract class Pocima {
    private String nombre;

    public Pocima(String nombre) {
        this.nombre = nombre;
    }

    public abstract Atributo calculaValor(Atributo ff);

    public String getNombre() {
        return nombre;
    }
}