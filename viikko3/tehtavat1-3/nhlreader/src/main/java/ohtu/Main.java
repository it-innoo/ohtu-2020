/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        //System.out.println(bodyText);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        //System.out.println("Oliot:");
        System.out.println("Players from FIN " + new java.util.Date());
        System.out.println("");

        List<Player> finPlayers = Arrays.asList(players);

        List<Player> listFins = finPlayers.stream()
                .filter(p -> "FIN".equals(p.getNationality()))      // we want finnish players
                .sorted(Comparator.comparingInt(Player::getPoints)  // sprt
		.reversed())                                        // by ascending order 
                .collect(Collectors.toList());                      // collect the output and convert
                                                                    //streams to a List

        listFins.forEach(System.out::println);                      //output : spring, node

    }
}
