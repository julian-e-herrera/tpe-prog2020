public class CriterioAnd extends Criterio {
    private Criterio c1;
    private Criterio c2;

    public CriterioAnd(Criterio c1, Criterio c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public boolean cumple(Atributo ff){
        return((c1.cumple(ff)) && (c2.cumple(ff)));
    }

    // se ponen Sets para volver a usar el And en lugar de crear otra Instancia
    public void setC1(Criterio c1) {
        this.c1 = c1;
    }

    public void setC2(Criterio c2) {
        this.c2 = c2;
    }
}
