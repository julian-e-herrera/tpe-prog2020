package General;

import java.util.ArrayList;

import Pocima.Pocima;

public class Carta {
    private String nombre;
    private ArrayList<Atributo> atributos;
    private Pocima pocima;

    public Carta(String nombre, ArrayList<Atributo> atributosSueltos) {
        atributos = new ArrayList<Atributo>(atributosSueltos);
        this.nombre = nombre;
        pocima = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPocima(Pocima pocima) {
        this.pocima = pocima;
    }

    public Pocima getPocima() {
        return pocima;
    }

    public int getCantAtributos() {
        return atributos.size();
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

    public int calcularAtributo(String ff) {
        //si no tiene pocima, que devuelva el valor original, si tiene, que lo calcule
        Atributo atributo = this.getAtributoPorNombre(ff);
        int aux = atributo.getValor();

        if (pocima != null) {
            aux = pocima.calculaValor(atributo);
        }
        return aux;
    }

    public boolean esIgual(Carta ff) {
        return ((this.equals(ff) && (ff.getNombre().equals(this.nombre))));
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Carta cartaAux = (Carta) obj;

            // si la carta tiene la misma cantidad de atributos, comprueba
            if ((cartaAux.getCantAtributos() == atributos.size())) {

                // si los nombres de los atributos son los mismos
                for (Atributo atributo : atributos) {
                    if (!(cartaAux.contieneAtributo(atributo))) {
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

    public boolean contieneAtributo(Atributo ff) {
        return this.atributos.contains(ff);
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
