
package ohtu;

/**
 * Ehto.
 * 
 * @author jukka
 */
public class Deuce implements Ehto {

    @Override
    public boolean test(int score1, int score2) {
        return score1 == score2;
    }
    
}
