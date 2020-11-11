package General;


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


    //Se usa solamente en el Cocktail.
    public void setValor(int valor) {
        this.valor = valor;
    }
}
