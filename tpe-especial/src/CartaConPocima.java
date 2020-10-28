
public class CartaConPocima extends Carta {
    private Pocima pocima;

    public CartaConPocima(Carta ff, Pocima pp){
        setAtributos(ff.getAllAtributos());
        setNombre(ff.getNombre());
        pocima = pp;
    }
    
    public Pocima getPocima() {
        return pocima;
    }

    public double calcularAtributo(){
        return pocima.calculaValor()
    }

}
