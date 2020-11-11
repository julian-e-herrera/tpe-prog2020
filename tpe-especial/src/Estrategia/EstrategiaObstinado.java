package Estrategia;
import General.Carta;

public class EstrategiaObstinado implements Estrategia {
    private String atributo;

    public EstrategiaObstinado(String atributoNombre){
        atributo = atributoNombre;
    }

    @Override
    public String elegirAtributo(Carta ff) {
        return atributo;
    }
}