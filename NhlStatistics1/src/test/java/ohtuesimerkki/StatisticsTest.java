/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author strajama
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPlayerByName() {
        Player semenko = stats.search("Semenko");
        assertEquals("Semenko", semenko.getName());
    }

    @Test
    public void searchPlayerNotInStats() {
        Player none = stats.search("none");
        assertEquals(null, none);
    }

    @Test
    public void teamSize() {
        List<Player> playersOfTeam = stats.team("PIT");
        // tiimissä EDM pitäisi olla yksi pelaaja
        assertEquals(1, playersOfTeam.size());
        // ja hänen nimensä pitäisi olla "Lemieux"
        assertEquals("Lemieux", playersOfTeam.get(0).getName());
    }

    @Test
    public void topScorerMinus() {
        List<Player> topScorers = stats.topScorers(-1);
        assertTrue(topScorers.isEmpty());
    }
    
    @Test
    public void topScorersSorted() {
        List<Player> topScorers = stats.topScorers(4);
        // ensimmäisenä tulisi olla Gretzky
        assertEquals("Gretzky", topScorers.get(0).getName());
        // ja hänellä 35+89 eli 124 pistettä
        assertEquals(124, topScorers.get(0).getPoints());
        //toisena Lemieux
        assertEquals("Lemieux", topScorers.get(1).getName());
        // ja pisteitä 45+54 eli 99
        assertEquals(99, topScorers.get(1).getPoints());
        // kolmantena Yzerman
        assertEquals("Yzerman", topScorers.get(2).getName());
        // ja pisteitä 42+56 eli 98
        assertEquals(98, topScorers.get(2).getPoints());
        // neljäntenä Kurri
        assertEquals("Kurri", topScorers.get(3).getName());
        // pisteitä 37+53 eli 90
        assertEquals(90, topScorers.get(3).getPoints());
        // viidentenä Semenko
        assertEquals("Semenko", topScorers.get(4).getName());
        // pisteitä 4+12=16
        assertEquals(16, topScorers.get(4).getPoints());
    }

}
