package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;

public class Kaksinpeli extends Peli {

    public Kaksinpeli(IO io, Tuomari tuomari) {
        super(io, tuomari);
    }

    @Override
    public void pelaa() {

        String ekanSiirto = io.lueSiirto("Ensimmäisen pelaajan siirto: ");
        String tokanSiirto = io.lueSiirto("Toisen pelaajan siirto: ");

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);

            ekanSiirto = io.lueSiirto("Ensimmäisen pelaajan siirto: ");

            tokanSiirto = io.lueSiirto("Toisen pelaajan siirto: ");
        }
    }
}
