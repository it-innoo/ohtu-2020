
package ohtu.intjoukkosovellus.io;

import java.util.Scanner;

/** 
 * Komentorivi IO.
 * 
 * @author jukka
 */
public final class KonsoliIO implements IO {

    private final Scanner lukija;

    public KonsoliIO() {
        lukija = new Scanner(System.in);
    }
    
    @Override
    public int nextInt() {
        return Integer.valueOf(lukija.nextLine());
    }

    @Override
    public int nextInt(String kehote) {
        print(kehote);
        return nextInt();
    }

    @Override
    public String nextLine() {
        return lukija.nextLine();
    }

    
    @Override
    public String nextLine(String kehote) {
        print(kehote);
        return nextLine();
    }
    
    @Override
    public void print(String m) {
        System.out.println(m);
    }

}
