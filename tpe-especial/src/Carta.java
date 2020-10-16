import java.util.ArrayList;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> atributos;

    public Carta(String nombre) {
        atributos = new ArrayList<Atributo>();
        this.nombre = nombre;
    }

    public void agregarAtributo(Atributo ff) {
        if (!atributos.contains(ff)) {
            atributos.add(ff);
        }
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public boolean equals(Object obj) {
        try {
            Carta cartaAux = (Carta) obj;

            // si la carta tiene nombre y tienen la misma cantidad de atributos, comprueba
            // si
            if ((cartaAux.getNombre().length() != 0) && (cartaAux.getCantAtributos() == atributos.size())) {
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

    public boolean esMismoTipo(Carta ff) {
        if (ff.getCantAtributos() == atributos.size()) {
            for (int i = 0; i < atributos.size(); i++) {
                if (!(atributos.get(i).mismoTipo(ff.getAtributo(i)))) {
                    return false;
                }
            }
            return true;
        } else
            return false;
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
