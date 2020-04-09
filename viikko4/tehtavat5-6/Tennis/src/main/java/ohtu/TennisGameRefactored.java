
package ohtu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Game
 * A game consists of a sequence of points played with the same player serving.
 * A game is won by the first player to have won at least four points in total
 * and at least two points more than the opponent. The running score of each game
 * is described in a manner peculiar to tennis: scores from zero to three points
 * are described as "love", "15", "30", and "40", respectively.
 * If at least three points have been scored by each player, making the player's scores equal
 * at 40 apiece, the score is not called out as "40–40", but rather as "deuce".
 * If at least three points have been scored by each side and a player has one more point
 * than his opponent, the score of the game is "advantage" for the player in the lead.
 * During informal games, "advantage" can also be called "ad in" or "van in" when
 * the serving player is ahead, and "ad out" or "van out" when the receiving player is ahead;
 * alternatively, either player may simply call out "my ad" or "your ad" during informal play.
 * 
 * @author jukka
 */
public class TennisGameRefactored {
    private final Player player1;
    private final Player player2;
    private final Map<String,Player> players;

    public TennisGameRefactored(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        players = new HashMap<>();
        players.put(player1Name, player1);
        players.put(player2Name, player2);
    }
    
    public void wonPoint(String playerName) {
        Player player = players.get(playerName);
        player.setScore(player.getScore().next());
    }
    
    public String getScore() {
        StringBuilder scoreboard = new StringBuilder();
        
        Ehto ehto = new Deuce();
        if (ehto.test(player1.getScore(), player2.getScore())) {
            
        }
        
        scoreboard.append(player1.getScore());
        scoreboard.append("-");
        scoreboard.append(player2.getScore());
        
        return scoreboard.toString();
    }
}
