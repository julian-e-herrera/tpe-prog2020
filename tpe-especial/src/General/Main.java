package General;
import java.util.ArrayList;

import Pocima.Pocima;
import Pocima.PocimaFija;
import Pocima.PocimaNormal;
import Pocima.PocimaSelectiva;
import Pocima.Cocktail;

public class Main {
    public static void main(String[] args) {

        String mazoPath = "src/superheroes.json";

        ArrayList<Pocima> pocimas = new ArrayList<Pocima>();


        PocimaFija vale4 = new PocimaFija("Quiero Vale 4", 4);
        PocimaSelectiva pocimaFuerza = new PocimaSelectiva("Pocima Selectiva Fuerza", "fuerza", 1.40);
        PocimaNormal fortalecedora = new PocimaNormal("Fortalecedora", 1.20);
        PocimaNormal fortalecedoraPlus = new PocimaNormal("Fortalecedora Plus", 1.50);
        PocimaNormal kriptonita = new PocimaNormal("Kriptonita", 0.75);
        PocimaNormal reductorPlomo = new PocimaNormal("Reductor de Plomo", 0.45);
        PocimaFija numeroMagico = new PocimaFija("Numero Magico", 23);
        PocimaSelectiva pocimaPeso = new PocimaSelectiva("Pocima Selectiva Peso", "peso", 1.43);

        Cocktail pruebaCocktail = new Cocktail("Cocktail");
        PocimaNormal fortalecedora2 = new PocimaNormal("Fortalecedora", 1.20);
        PocimaNormal kriptonita2 = new PocimaNormal("Kriptonita", 0.75);
        pruebaCocktail.agregarPocima(fortalecedora2);
        pruebaCocktail.agregarPocima(kriptonita2);

        Cocktail cocktailLetal = new Cocktail("Cocktail");
        PocimaFija pocimaMala = new PocimaFija("Muerte Asegurada", 1);
        cocktailLetal.agregarPocima(pocimaMala);

        pruebaCocktail.agregarPocima(cocktailLetal);

        pocimas.add(vale4);
        pocimas.add(pocimaFuerza);
        pocimas.add(pocimaPeso);
        pocimas.add(fortalecedora);
        pocimas.add(fortalecedoraPlus);
        pocimas.add(kriptonita);
        pocimas.add(reductorPlomo);
        pocimas.add(numeroMagico);
        pocimas.add(pruebaCocktail);


        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pablo");

        Juego prueba = new Juego(jugador1, jugador2, 40, mazoPath, pocimas);
        prueba.jugar();
    }
}
