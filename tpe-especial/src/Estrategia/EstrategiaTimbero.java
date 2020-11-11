package Estrategia;
// import General.Atributo;
import General.Carta;

public class EstrategiaTimbero implements Estrategia{

    public String elegirAtributo(Carta ff) {
        int atributo;

        int atributos = ff.getCantAtributos();

        atributo = (int) (Math.random() * atributos);

        return ff.getAtributo(atributo).getNombre();
}
}
