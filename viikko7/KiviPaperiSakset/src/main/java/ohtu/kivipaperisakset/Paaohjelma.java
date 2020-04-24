package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.io.Konsoli;

public class Paaohjelma {

    public static void main(String[] args) {

        IO io = new Konsoli();
        Tuomari tuomari = new Tuomari(io);
        UI ui = new UI(io, tuomari);
        ui.launch();
    }
}
