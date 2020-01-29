package ohtuesimerkki;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

  Reader readerStub = new Reader() {

    public List<Player> getPlayers() {
      ArrayList<Player> players = new ArrayList<>();

      players.add(new Player("Semenko", "EDM", 4, 12));
      players.add(new Player("Lemieux", "PIT", 45, 54));
      players.add(new Player("Kurri", "EDM", 37, 53));
      players.add(new Player("Yzerman", "DET", 42, 56));
      players.add(new Player("Gretzky", "EDM", 35, 89));

      return players;
    }
  };

  Statistics stats;
  ArrayList<Player> empty = new ArrayList<>();

  @Before
  public void setUp() {
    // luodaan Statistics-olio joka käyttää "stubia"
    stats = new Statistics(readerStub);
  }

  @Test
  public void konstruktoriLuoPelaajaListan() {
    assertNotNull(stats);
  }

  @Test
  public void etsiiOikeanPelaajalistan() {
    assertNotNull(stats.team("EDM"));
    assertEquals(empty, stats.team("ANA"));
  }

  @Test
  public void listaaPelaajat() {
    assertNull(stats.search("Teemu Selänne"));

    assertSame("Kurri", stats.search("Kurri").getName());
  }

  @Test
  public void listaaTopit() {
    assertEquals(1, stats.topScorers(0).size());
  }
}
