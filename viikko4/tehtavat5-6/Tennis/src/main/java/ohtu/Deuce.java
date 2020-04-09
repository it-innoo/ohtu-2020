
package ohtu;

/**
 * Ehto.
 * 
 * @author jukka
 */
public class Deuce implements Ehto {

    @Override
    public boolean test(Score score1, Score score2) {
        return score1 == score2;
    }
    
}
