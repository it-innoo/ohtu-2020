
package ohtu;

/**
 * The running score of each game is described in a manner peculiar to tennis:
 * scores from zero to three points are described as
 * "Love", "Fifteen", "Thirty", and "Forty" respectively.
 * 
 * @author jukka
 */
public enum Score {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"),
    DEUCE("Deuce"),
    ADVANTAGE("Advantage"),
    WIN("Win for");
    
    
    public final String label;
 
    private Score(String label) {
        this.label = label;
    }
    
    public Score next() {
        return values()[ordinal() + 1];
    }

    @Override
    public String toString() {
        return this.label;
    }
    
}
