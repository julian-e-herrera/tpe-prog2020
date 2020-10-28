import java.util.ArrayList;
import java.util.Comparator;

public class Carta implements Comparator<Atributo> {
    private String nombre;
    private ArrayList<Atributo> atributos;

    public Carta(String nombre, ArrayList<Atributo> atributosSueltos) {
        atributos = new ArrayList<Atributo>(atributosSueltos);
        this.nombre = nombre;
    }

    public Carta(){}

    public String getNombre() {
        return nombre;
    }

    @Override
    public int compare(Atributo a1, Atributo a2) {
        return a1.getValor() - a2.getValor();
    }

    public int getCantAtributos() {
        return atributos.size();
    }

    public ArrayList<Atributo> getAllAtributos() {
        return new ArrayList<Atributo>(atributos);
    }

    public Atributo getAtributo(int i) {
        return atributos.get(i);
    }

    public Atributo getAtributo(Atributo a) {
        //nunca te va a dar null, pero hay que poner algo xd
        Atributo aux = null;
        for (Atributo atributo : atributos) {
            if (a.equals(atributo)) {
                aux = atributo;
            }
        }
        return aux;
    }

    protected void setNombre(String nombre){
        this.nombre = nombre;
    }

    protected void setAtributos(ArrayList<Atributo> atributos){
        atributos.clear();
        atributos.addAll(atributos);
    }

    public Atributo getAtributoPorNombre(String nombre) {
        boolean encontrado = false;
        int i = 0;

        while ((!encontrado) && (i < atributos.size())) {
            Atributo subi = atributos.get(i);
            if (subi.getNombre().equals(nombre)) {
                encontrado = true;
            } else
                i++;
        }
        return atributos.get(i);
    }

    public boolean esIgual(Carta ff){
        return ((this.equals(ff)&& (ff.getNombre().equals(this.nombre))));
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Carta cartaAux = (Carta) obj;

            // si la carta tiene la misma cantidad de atributos, comprueba
            if ((cartaAux.getCantAtributos() == atributos.size())) {
                // si los nombres de los atributos son los mismos
                for (Atributo atributo : cartaAux.getAllAtributos()) {
                    if (!(atributos.contains(atributo))) {
                        return false;
                    }
                }
                return true;
            } else
                return false;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        String info = "nombre:" + nombre + " ";
        for (Atributo atributo : atributos) {
            info += atributo.getNombre() + ": " + atributo.getValor() + " ";
        }
        return info;
    }
}
