
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 * Laskee kahden joukonyhdisteen.
 * 
 * @author jukka
 */
public class Yhdiste extends Komento {

    public Yhdiste(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko1 = Sovellus.joukot.get(io.nextLine("1. joukko? ? "));
        IntJoukko joukko2 = Sovellus.joukot.get(io.nextLine("2. joukko? ? "));

        io.print("A yhdiste B = "
                + IntJoukko.yhdiste(joukko1, joukko2).toString());
    }
    
}
