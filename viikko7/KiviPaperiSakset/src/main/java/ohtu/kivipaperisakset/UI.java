package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;

public class UI {

    private static final String PELI
            = "\nValitse pelataanko"
            + "\n (a) ihmistä vastaan "
            + "\n (b) tekoälyä vastaan"
            + "\n (c) parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan";

    private static final String OHJE
            = "peli loppuu kun pelaaja antaa virheellisen siirron"
            + " eli jonkun muun kuin k, p tai s";

    private final IO io;
    private final Tuomari tuomari;
    private final Pelitehdas pelit;

    public UI(IO io, Tuomari tuomari) {
        this.io = io;
        this.tuomari = tuomari;
        this.pelit = new Pelitehdas(io, tuomari);
    }

    public void launch() {
        io.print(PELI);
        String valinta = io.lueRivi();
        Peli peli = pelit.hae(valinta.toUpperCase());

        while (peli != null) {
            io.print(OHJE);

            peli.pelaa();

            valinta = io.lueRivi();
            peli = pelit.hae(valinta);
        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari);
    }
}
