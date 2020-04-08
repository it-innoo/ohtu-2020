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
    private final String player1Name;
    private final String player2Name;

    private final Map<Integer, String> points;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Score = LOVE;
        this.player2Score = LOVE;
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        points = new HashMap<>();
        points.put(LOVE, "Love");
        points.put(FIFTEEN, "Fifteen");
        points.put(THIRTY, "Thirty");
        points.put(FORTY, "Forty");
        points.put(DEUCE, "Deuce");
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
        score.append(tilanne());

        //score.append(tilanneJosTasan());
        /*
        if (player1Score == player2Score) {
            score.append(deuce());
            return score.toString();
        }
        if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score.append(avantage());
            return score.toString();
        }
         */
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

        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            score.append("Advantage player1");
            return score;
        }
        if (minusResult == -1) {
            score.append("Advantage player2");
            return score;
        }
        if (minusResult >= 2) {
            score.append("Win for player1");
            return score;
        }
        score.append("Win for player2");

        return score;
    }

    private StringBuilder tilanne() {
        StringBuilder score = new StringBuilder();

        
        if (player1Score == player2Score) {
            score.append(deuce());
            return score;
        }
        
        if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score.append(avantage());
            return score;
        }
        
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

    private StringBuilder tilanneJosTasan() {
        StringBuilder score = new StringBuilder();

        if (player1Score == player2Score) {
            score.append(deuce());
        }

        return score;
    }

    private StringBuilder tilannaJosDeuce() {
        StringBuilder score = new StringBuilder();

        if (player1Score >= DEUCE || player2Score >= DEUCE) {
            score.append(avantage());
        }
        return score;
    }

    private StringBuilder tilannaJosAlle40() {
        StringBuilder score = new StringBuilder();

        if (player1Score < FORTY && player2Score < FORTY) {
            for (int i = 1; i <= 2; i++) {
                if (i == 1) {
                    score.append(points.get(player1Score));
                } else {
                    score.append("-");
                    score.append(points.get(player2Score));
                }
            }
        }

        return score;
    }
}
