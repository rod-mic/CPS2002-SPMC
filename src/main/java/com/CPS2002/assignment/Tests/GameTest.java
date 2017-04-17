package com.CPS2002.assignment.Tests;

import com.CPS2002.assignment.Objects.Game;
import com.CPS2002.assignment.Objects.Map;
import com.CPS2002.assignment.Objects.Player;
import com.CPS2002.assignment.Objects.Position;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rodemic on 17/04/2017.
 */
public class GameTest {
    Game g;
    Player[] p = new Player[2];
    Map m;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Before
    public void setup() throws Exception{
        m = new Map();
        m.setMapSize(5,2);
        p[0] = new Player(m);
        p[1] = new Player(m);
        g = new Game(p,m);
    }


    @Test
    public void movePlayers() throws Exception {
        char[] direction = {'U','D'};
        g.movePlayers(direction);
    }

    @Test
    public void checkWinner() throws Exception {
        Position pos = p[0].getPosition();
        if(m.getTileType(pos) == 'T')assertEquals(true,g.checkWinner(p[0]));
        else assertEquals(false,g.checkWinner(p[0]));
    }

    @Test
    public void checkWater() throws Exception {
        Position pos = p[0].getPosition();
        if(m.getTileType(pos) == 'W')assertEquals(true,g.checkWater(p[0]));
        else assertEquals(false,g.checkWater(p[0]));
    }

    @Test
    public void printOneWinner() throws Exception {
        ArrayList<Integer> winners = new ArrayList<>();
        winners.add(1);
        String output = "Player 1 found the Treasure!";
        g.printWinners(winners);
        assertEquals(output,systemOutRule.getLog().trim());
    }

    @Test
    public void printMultipleWinners() throws Exception {
        ArrayList<Integer> winners = new ArrayList<>();
        winners.add(1);
        winners.add(2);
        winners.add(3);
        String output = "Players 1 2 3 found the Treasure!";
        g.printWinners(winners);
        assertEquals(output,systemOutRule.getLog().trim());
    }

    @Test
    public void cleanup() throws Exception {

    }

    @Test
    public void generateHTMLFiles1() throws Exception {

    }
}