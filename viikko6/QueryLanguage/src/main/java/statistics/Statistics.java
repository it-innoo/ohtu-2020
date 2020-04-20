package statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import statistics.matcher.Matcher;

public class Statistics {

    private final List<Player> players;

    public Statistics(PlayerReader playerReader) {
        players = playerReader.getPlayers();
    }

    public Player search(String name) {
        for (Player player : players) {
            if (player.getName().contains(name)) {
                return player;
            }
        }

        return null;
    }

    public List<Player> team(String teamName) {
        ArrayList<Player> playersOfTeam = new ArrayList<>();

        players.stream()
                .filter((player) -> (player.getTeam()
                .equals(teamName)))
                .forEachOrdered((player) -> {
                    playersOfTeam.add(player);
                });

        return playersOfTeam;
    }

    public List<Player> topScorers(int howMany) {
        Collections.sort(players);
        ArrayList<Player> topScorers = new ArrayList<>();
        Iterator<Player> playerIterator = players.iterator();

        while (howMany >= 0) {
            topScorers.add(playerIterator.next());
            howMany--;
        }

        return topScorers;
    }

    public List<Player> matches(Matcher matcher) {
        ArrayList<Player> matches = new ArrayList<>();

        players.stream().filter((player) -> (matcher.matches(player))).forEachOrdered((player) -> {
            matches.add(player);
        });

        return matches;
    }
}
