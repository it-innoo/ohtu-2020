
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Lopeta extends Komento {

    public Lopeta(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        io.print("Lopetetaan, moikka!");
        System.exit(0);
    }
    
}
