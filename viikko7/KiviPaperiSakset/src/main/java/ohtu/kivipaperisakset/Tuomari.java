package ohtu.kivipaperisakset;

// Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.

import ohtu.kivipaperisakset.io.IO;

public class Tuomari {

    private IO io;
    private int pelaajaPisteet;
    private int tietokonePisteet;
    private int tasapelit;

    public Tuomari(IO io) {
        this.io = io;
        this.pelaajaPisteet = 0;
        this.tietokonePisteet = 0;
        this.tasapelit = 0;
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            pelaajaPisteet++;
        } else {
            tietokonePisteet++;
        }
        io.print(this);
        io.print("");
    }

    public void pelaajaVoitti() {
        this.pelaajaPisteet++;
    }

    public void tietokoneVoitti() {
        this.tietokonePisteet++;
    }
    
    // sisäinen metodi, jolla tarkastetaan tuliko tasapeli
    private static boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    // sisäinen metodi joka tarkastaa voittaako eka pelaaja tokan
    private static boolean ekaVoittaa(String eka, String toka) {
        if ("k".equals(eka) && "s".equals(toka)) {
            return true;
        } else if ("s".equals(eka) && "p".equals(toka)) {
            return true;
        } else if ("p".equals(eka) && "k".equals(toka)) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "Pelitilanne: " + pelaajaPisteet + " - " + tietokonePisteet + "\n"
                + "Tasapelit: " + tasapelit;
        return s;
    }
}
