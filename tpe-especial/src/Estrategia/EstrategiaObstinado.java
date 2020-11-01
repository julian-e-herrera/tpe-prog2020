package Estrategia;
import General.Atributo;
import General.Carta;

public class EstrategiaObstinado extends Estrategia {
    private String atributo;

    public EstrategiaObstinado(String atributoNombre){
        atributo = atributoNombre;
    }

    @Override
    public Atributo elegirAtributo(Carta ff) {
        return ff.getAtributoPorNombre(atributo);
    }
}