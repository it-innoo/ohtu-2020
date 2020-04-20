package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        System.out.println("\n=====\n");
        
        QueryBuilder query = new QueryBuilder();
        /*
        Matcher m = query.playsIn("NYR")
                .hasAtLeast(5, "goals")
                //.hasFewerThan(10, "goals")
                .build();
        */
        Matcher m = new And(
                new PlaysIn("NYR"),
                new HasAtLeast(5, "goals"),
                new HasFewerThan(10, "goals")
        );

        stats.matches(m).forEach((player) -> {
            System.out.println(player);
        });
    }
}
