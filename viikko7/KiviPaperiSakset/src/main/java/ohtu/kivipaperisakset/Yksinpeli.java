package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;

public class Yksinpeli extends Peli {

    protected Tekoaly tekoaly;

    public Yksinpeli(IO io, Tuomari tuomari) {
        super(io, tuomari);
        this.tekoaly = new Tekoaly();
    }

    @Override
    public void pelaa() {

        String ekanSiirto = io.lueSiirto("Ensimmäisen pelaajan siirto: ");
        String tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);

            ekanSiirto = io.lueSiirto("Ensimmäisen pelaajan siirto: ");

            tokanSiirto = tekoaly.annaSiirto();
            io.print("Tietokone valitsi: " + tokanSiirto);
            tekoaly.asetaSiirto(ekanSiirto);

        }
    }
}
