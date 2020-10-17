

public class Atributo {
    private String nombre;
    private int valor;

    public Atributo(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public boolean comparar(Atributo ff, Criterio jj) {
        return jj.cumple(ff);
    }

    public boolean mismoTipo(Atributo ff) {
        if (ff.getNombre().equals(nombre)) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Atributo aux = (Atributo) obj;
            if ((aux.getNombre().equals(nombre))) {
                return true;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", " + "Valor: " + valor;
    }
}
