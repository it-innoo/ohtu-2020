
package ohtu.intjoukkosovellus.io;

/**
 * IO rajapinta.
 * 
 * @author jukka
 */
public interface IO {
    
    int nextInt();
    
    int nextInt(String kehote);

    String nextLine();
    
    String nextLine(String kehote);
    
    void print(String rivi);
}
