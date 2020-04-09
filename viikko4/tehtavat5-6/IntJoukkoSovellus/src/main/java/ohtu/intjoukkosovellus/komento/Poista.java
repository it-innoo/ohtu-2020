
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 * Poistaa alkion joukosta.
 * 
 * @author jukka
 */
public class Poista extends Komento {

    public Poista(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko = Sovellus.joukot.get(io.nextLine("Mistä joukosta? "));

        int luku = io.nextInt("Mikä luku poistetaan? ");

        joukko.poista(luku);
    }
    
}
