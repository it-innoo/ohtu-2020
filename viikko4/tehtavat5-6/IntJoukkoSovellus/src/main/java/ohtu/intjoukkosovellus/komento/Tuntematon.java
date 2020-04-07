
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Tuntematon extends Komento {

    public Tuntematon(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        io.print("sallitut komennot: "+ Sovellus.KOMENNOT);
    }
    
}
