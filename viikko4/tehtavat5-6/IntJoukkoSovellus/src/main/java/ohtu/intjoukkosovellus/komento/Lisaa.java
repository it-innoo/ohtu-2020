
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Lisaa extends Komento {

    public Lisaa(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko = Sovellus.joukot.get(io.nextLine("Mihin joukkoon? "));

        int luku = io.nextInt("Mikä luku lisätään? ");

        joukko.lisaa(luku);
    }
    
}
