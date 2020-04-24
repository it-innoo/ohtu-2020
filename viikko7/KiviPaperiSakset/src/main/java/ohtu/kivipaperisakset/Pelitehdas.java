
package ohtu.kivipaperisakset;

import java.util.HashMap;
import java.util.Map;
import ohtu.kivipaperisakset.io.IO;

public class Pelitehdas {
    private final Map<String, Peli> pelit;

    public Pelitehdas(IO io, Tuomari tuomari) {
        pelit = new HashMap<>();
        pelit.put("A", new Kaksinpeli(io, tuomari));
        pelit.put("B", new  Yksinpeli(io, tuomari));
        pelit.put("C", new PahaYksinpeli(io, tuomari));
    }

    public Peli hae(String peli) {
        return pelit.getOrDefault(peli, null);
    }
}
