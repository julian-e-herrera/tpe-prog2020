public class CriterioNombre extends Criterio {
    private String nombre;

    public CriterioNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean cumple(Atributo ff) {
        return ff.getNombre().equals(nombre);
    }

}
