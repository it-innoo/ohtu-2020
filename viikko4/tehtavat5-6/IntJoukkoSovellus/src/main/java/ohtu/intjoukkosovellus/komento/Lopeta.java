
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.io.IO;

/**
 * Exit sovellus.
 * 
 * @author jukka
 */
public class Lopeta extends Komento {

    private static final int SUCCESS = 0;
    
    public Lopeta(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        io.print("Lopetetaan, moikka!");
        System.exit(SUCCESS);
    }
    
}
