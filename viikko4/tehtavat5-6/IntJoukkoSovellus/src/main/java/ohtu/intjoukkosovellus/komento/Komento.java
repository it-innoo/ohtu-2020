
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.io.IO;

/**
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
