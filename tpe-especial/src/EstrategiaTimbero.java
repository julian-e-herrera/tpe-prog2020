public class EstrategiaTimbero extends Estrategia{

    public Atributo elegirAtributo(Carta ff) {
        int atributo;

        int atributos = ff.getCantAtributos();

        atributo = (int) (Math.random() * atributos);

        return ff.getAtributo(atributo);
}
}
