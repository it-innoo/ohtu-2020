
package ohtu.intjoukkosovellus.komento;

import ohtu.intjoukkosovellus.Sovellus;
import ohtu.intjoukkosovellus.io.IO;

/**
 *
 * @author jukka
 */
public class A extends Komento {

    public A(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        
        System.out.println(Sovellus.joukot.values());
    }
    
}
