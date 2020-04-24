package ohtu.kivipaperisakset;

import java.util.Scanner;
import ohtu.kivipaperisakset.io.IO;
import ohtu.kivipaperisakset.io.Konsoli;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String PELI
            = "\nValitse pelataanko"
            + "\n (a) ihmistä vastaan "
            + "\n (b) tekoälyä vastaan"
            + "\n (c) parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan";

    private static final String OHJE
            = "peli loppuu kun pelaaja antaa virheellisen siirron"
            + " eli jonkun muun kuin k, p tai s";

    public static void main(String[] args) {

        IO io = new Konsoli();
        Tuomari tuomari = new Tuomari(io);

        while (true) {
            io.print(PELI);

            String valinta = io.lueRivi();

            if (valinta.endsWith("a")) {
                io.print(OHJE);
                Peli peli = new Kaksinpeli(io, tuomari);
                peli.pelaa();
            } else if (valinta.endsWith("b")) {
                io.print(OHJE);
                Peli peli = new Yksinpeli(io, tuomari);
                peli.pelaa();
            } else if (valinta.endsWith("c")) {
                io.print(OHJE);
                Peli peli = new PahaYksinpeli(io, tuomari);
                peli.pelaa();
            } else {
                break;
            }

        }
        io.print("");
        io.print("Kiitos!");
        io.print(tuomari);
    }
}
