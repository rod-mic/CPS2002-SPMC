import Objects.Game;
import Objects.MapTypes.MapCreator;
import Objects.MapTypes.MapInterface;
import Objects.Observer.Player;
import Objects.Position;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rodemic on 17/04/2017.
 */
public class GameTest {
    private final ByteArrayOutputStream ConsoleOut = new ByteArrayOutputStream();
    private final ByteArrayOutputStream ConsoleErr = new ByteArrayOutputStream();
    Game g;
    Player[] p = new Player[2];
    MapInterface m;

    @Before
    public void setup() throws Exception {
        System.setOut(new PrintStream(ConsoleOut));
        System.setErr(new PrintStream(ConsoleErr));
        MapCreator mc = new MapCreator();
        m = mc.createMap(5,2,1);
        p[0] = new Player(m);
        p[1] = new Player(m);
        g = new Game(p, m);
    }


    @Test
    public void movePlayers() throws Exception {
        char[] direction = {'U', 'D'};
        g.movePlayers(direction);
    }

    @Test
    public void checkWinner() throws Exception {
        Position pos = p[0].getPosition();
        if (m.getTileType(pos) == 'T') assertEquals(true, g.checkWinner(p[0]));
        else assertEquals(false, g.checkWinner(p[0]));
    }

    @Test
    public void checkWater() throws Exception {
        Position pos = p[0].getPosition();
        if (m.getTileType(pos) == 'W') assertEquals(true, g.checkWater(p[0]));
        else assertEquals(false, g.checkWater(p[0]));
    }

    @Test
    public void printOneWinner() throws Exception {
        ArrayList<Integer> winners = new ArrayList<>();
        winners.add(1);
        String output = "Player 1 found the Treasure!";
        g.printWinners(winners);
        assertEquals(output, ConsoleOut.toString().trim());
    }

    @Test
    public void printMultipleWinners() throws Exception {
        ArrayList<Integer> winners = new ArrayList<>();
        winners.add(1);
        winners.add(2);
        winners.add(3);
        String output = "Players 1 2 3 found the Treasure!";
        g.printWinners(winners);
        assertEquals(output, ConsoleOut.toString().trim());
    }

    @Test
    public void InvalidDirectionUserInput() throws Exception {
        Scanner sc = new Scanner("F\nU");
        String output = "F is invalid. Please enter (U)p, (D)own, (L)eft or (R)ight. Direction:";
        Position pos = new Position(2, 2);
        Player pl = new Player(m);
        pl.setPosition(pos);
        g.getUserDirection(pl,sc);
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void InvalidPositionUserInput() throws Exception {
        Scanner sc = new Scanner("U\nD");
        String output = "The player has hit the top wall. Direction: ";
        Position pos = new Position(0, 0);
        Player pl = new Player(m);
        pl.setPosition(pos);
        g.getUserDirection(pl,sc);
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void CorrectUserInput() throws Exception {
        Scanner sc = new Scanner("D");
        String output = "";
        Position pos = new Position(0, 0);
        Player pl = new Player(m);
        pl.setPosition(pos);
        g.getUserDirection(pl,sc);
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void cleanup() throws Exception {
        g.generateHTMLFiles();
        g.cleanup();
    }

    @Test
    public void generateHTMLFiles() throws Exception {
        g.generateHTMLFiles();
    }
}