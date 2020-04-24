
package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;

public abstract class Peli {
    protected IO io;
    protected Tuomari tuomari;

    public Peli(IO io) {
        this.io = io;
    }

    public Peli(IO io, Tuomari tuomari) {
        this.io = io;
        this.tuomari = tuomari;
    }

    public abstract void pelaa();

    protected boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
