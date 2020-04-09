
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 * Laskee kahden joukon erotuksen.
 * 
 * @author jukka
 */
public class Erotus extends Komento {

    public Erotus(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko1 = Sovellus.joukot.get(io.nextLine("1. joukko? ? "));
        IntJoukko joukko2 = Sovellus.joukot.get(io.nextLine("2. joukko? ? "));

        io.print("A pois B = " + IntJoukko.erotus(joukko1, joukko2).toString());
    }
    
}
