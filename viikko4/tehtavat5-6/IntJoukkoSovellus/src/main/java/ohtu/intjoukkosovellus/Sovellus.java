package ohtu.intjoukkosovellus;

import java.util.HashMap;
import java.util.Map;
import ohtu.intjoukkosovellus.io.IO;
import ohtu.intjoukkosovellus.io.KonsoliIO;
import ohtu.intjoukkosovellus.komento.Komentotehdas;

public class Sovellus {

    public static Map<String, IntJoukko> joukot;
    public static final String KOMENNOT
            = "Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y),"
            + "erotus(e), leikkaus(le) ja lopetus(quit)(q).\n "
            + "Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.";

    private static final String WELLCOME
            = "Tervetuloa joukkolaboratorioon!"
            + "Käytössäsi ovat joukot A, B ja C.";

    private final IO io;
    private final Komentotehdas komennot;

    public Sovellus() {
        io = new KonsoliIO();
        komennot = new Komentotehdas(io);

        joukot = new HashMap<>();
        joukot.put("A", new IntJoukko());
        joukot.put("B", new IntJoukko());
        joukot.put("C", new IntJoukko());
    }

    public void suorita() {
        io.print(WELLCOME);
        io.print(KOMENNOT);

        while (true) {
            String komento = io.nextLine();
            komennot.hae(komento.toLowerCase()).suorita();
        }
    }
}
