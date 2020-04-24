
package ohtu.kivipaperisakset.io;

import java.util.Scanner;

public class Konsoli implements IO {

    private final Scanner lukija;

    public Konsoli() {
        lukija = new Scanner(System.in);
    }

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public String lueSiirto(String msg) {
        print(msg);
        return lukija.nextLine();
    }

    @Override
    public String lueRivi() {
        return lukija.nextLine();
    }
}
