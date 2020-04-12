
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Kuuluu extends Komento {

    public Kuuluu(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko = Sovellus.joukot.get(io.nextLine("Mistä joukosta? "));

        int luku = io.nextInt("Mikä luku ? ");

        boolean kuuluuko = joukko.kuuluu(luku);
        if (kuuluuko) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }
    
}
