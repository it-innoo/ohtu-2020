
package ohtu.intjoukkosovellus.komento;

import java.util.HashMap;
import java.util.Map;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Komentotehdas {
    private final Map<String, Komento> komennot;
    private final Komento tuntematon;

    public Komentotehdas(IO io) {
        komennot = new HashMap<>();
        
        komennot.put("a", new A(io));
        komennot.put("b", new B(io));
        komennot.put("c", new C(io));
        
        komennot.put("lisää", new Lisaa(io));
        komennot.put("li", new Lisaa(io));
        
        komennot.put("poista", new Poista(io));
        komennot.put("p", new Poista(io));
        
        komennot.put("kuuluu", new Kuuluu(io));
        komennot.put("k", new Kuuluu(io));

        komennot.put("yhdiste", new Yhdiste(io));
        komennot.put("y", new Yhdiste(io));

        komennot.put("leikkaus", new Leikkaus(io));
        komennot.put("l", new Leikkaus(io));

        komennot.put("erotus", new Erotus(io));
        komennot.put("e", new Erotus(io));

        komennot.put("lopeta", new Lopeta(io));
        komennot.put("quit", new Lopeta(io));
        komennot.put("q", new Lopeta(io));
        tuntematon = new Tuntematon(io);
    }

    public Komento hae(String operaatio) {
        return komennot.getOrDefault(operaatio, tuntematon);
    }
}
