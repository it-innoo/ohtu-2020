/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.IntJoukko;
import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class Erotus extends Komento {

    public Erotus(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        IntJoukko joukko1 = Sovellus.joukot.get(io.nextLine("1. joukko? ? "));
        IntJoukko joukko2 = Sovellus.joukot.get(io.nextLine("2. joukko? ? "));

        io.print("A pois B = " + IntJoukko.erotus(joukko1, joukko2).toString());
    }
    
}
