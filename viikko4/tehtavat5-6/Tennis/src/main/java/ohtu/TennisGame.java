package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    enum Points {
        LOVE, FIFTEEN, THIRTY, FORTY, DEUCE, ADVANTAGE
    }

    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;
    private static final int DEUCE = 4;

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    private final Map<Integer, String> points;
    private final Map<Integer, String> game;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = LOVE;
        this.player2Score = LOVE;

        points = new HashMap<>();
        game = new HashMap<>();
        init();
    }

    private void init() {
        points.put(LOVE, "Love");
        points.put(FIFTEEN, "Fifteen");
        points.put(THIRTY, "Thirty");
        points.put(FORTY, "Forty");
        points.put(DEUCE, "Deuce");
        
        game.put(-2, "Win for " + player2Name);
        game.put(2, "Win for " + player1Name);
        game.put(1, "Advantage " + player1Name);
        game.put(-1, "Advantage " + player2Name);
    }
    
    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            player1Score++;
            return;
        }

        player2Score++;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        
        if (player1Score == player2Score) {
            score.append(deuce());
            return score.toString();
        }
        
        if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score.append(avantage());
            return score.toString();
        }
        score.append(tilanne());

        return score.toString();
    }

    private StringBuilder deuce() {
        StringBuilder score = new StringBuilder();

        if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score.append("Deuce");
            return score;
        }
        score.append(points.get(player1Score));
        score.append("-All");

        return score;
    }

    private StringBuilder avantage() {
        StringBuilder score = new StringBuilder();

        score.append(which());

        return score;
    }

    private String which() {
        int minusResult = player1Score - player2Score;
        minusResult = minusResult < -2 ? -2 : minusResult;
        minusResult = minusResult > 2 ? 2 : minusResult;

        return game.get(minusResult);
    }
    
    private StringBuilder tilanne() {
        StringBuilder score = new StringBuilder();

        
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                score.append(points.get(player1Score));
            } else {
                score.append("-");
                score.append(points.get(player2Score));
            }
        }
        return score;
    }
}
