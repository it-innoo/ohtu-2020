package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class PahaYksinpeli extends Yksinpeli {

    public PahaYksinpeli(IO io, Tuomari tuomari) {
        super(io, tuomari);
        this.tekoaly = new TekoalyParannettu(20);
    }

}
