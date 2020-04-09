
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 * Laskee kahden joukon leikkauksen.
 * 
 * @author jukka
 */
public class Leikkaus extends Komento {

    public Leikkaus(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko1 = Sovellus.joukot.get(io.nextLine("1. joukko? ? "));
        IntJoukko joukko2 = Sovellus.joukot.get(io.nextLine("2. joukko? ? "));

        io.print("A leikkaus B = "
                + IntJoukko.leikkaus(joukko1, joukko2).toString());
    }
    
}
