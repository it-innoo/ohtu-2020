package ohtu;

/**
 * Test TennisGame.
 * 
 * @author jukka
 */
public class App {

    public static void main(String[] args) {
        TennisGameRefactored game = new TennisGameRefactored("player1", "player2");

        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());
        
        System.out.println("===== NEW GAME =====");
        game = new TennisGameRefactored("player1", "player2");
        System.out.println("");
        
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());

        game.wonPoint("player1");
        System.out.println(game.getScore());

        game.wonPoint("player2");
        System.out.println(game.getScore());
    }
}
