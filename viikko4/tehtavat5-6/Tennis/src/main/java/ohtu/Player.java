
package ohtu;

/**
 * Player score.
 * 
 * @author jukka
 */
public class Player {
    private String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = Score.LOVE;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", score=" + score + '}';
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    
}
