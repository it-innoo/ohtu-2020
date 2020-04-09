
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.io.IO;

/**
 * Komento.
 * 
 * @author jukka
 */
public abstract class Komento {
    protected IO io;
    
    public Komento(IO io) {
        this.io = io;
    }

    public abstract void suorita();
}
