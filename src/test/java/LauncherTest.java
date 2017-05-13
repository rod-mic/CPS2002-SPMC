import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rodemic on 17/04/2017.
 */
public class LauncherTest {
    Launcher l = new Launcher();
    private final ByteArrayOutputStream ConsoleOut = new ByteArrayOutputStream();
    private final ByteArrayOutputStream ConsoleErr = new ByteArrayOutputStream();


    @Before
    public void consoleSetup() {
        System.setOut(new PrintStream(ConsoleOut));
        System.setErr(new PrintStream(ConsoleErr));
    }

    @Test
    public void CorrectIntegerInput() throws Exception {
        Scanner sc = new Scanner("0");
        assertEquals(0, l.getIntegerInput(0, 7, sc));
    }

    @Test
    public void OvermaxIntegerInput() throws Exception {
        Scanner sc = new Scanner("5\n3");
        String output = "The range is between 0 and 4. Try again: ";
        assertEquals(3, l.getIntegerInput(0, 4, sc));
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void UnderminIntegerInput() throws Exception {
        Scanner sc = new Scanner("1\n4");
        String output = "The range is between 2 and 4. Try again: ";
        assertEquals(4, l.getIntegerInput(2, 4, sc));
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void IncorrectIntegerInput() throws Exception {
        Scanner sc = new Scanner("ab\n4");
        String output = "Incorrect input. Numbers only. Try again: ";
        assertEquals(4, l.getIntegerInput(2, 4, sc));
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void MultipleIncorrectIntegerInput() throws Exception {
        Scanner sc = new Scanner("ab\n7\n4");
        String output = "Incorrect input. Numbers only. Try again: The range is between 2 and 4. Try again: ";
        assertEquals(4, l.getIntegerInput(2, 4, sc));
        assertEquals(output, ConsoleOut.toString());
    }

    @Test
    public void SingleplayerSmallGameSetup() throws Exception {
        Scanner sc = new Scanner("1\n1\n2\n5");
        String output = "Welcome to the game!\n" +
                "Choose game type: (1) Individual - (2) Collaborative\n" +
                "Choose map type: (1) Safe - (2) Hazardous\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "How big  will the map be? (Between 5x5 and 50x50)";
        l.setup(sc);
        assertEquals(output, ConsoleOut.toString().trim());
    }

    @Test
    public void CollaborativeSmallGameSetup() throws Exception {
        Scanner sc = new Scanner("2\n1\n4\n5\n2");
        String output = "Welcome to the game!\n" +
                "Choose game type: (1) Individual - (2) Collaborative\n" +
                "Choose map type: (1) Safe - (2) Hazardous\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "How big  will the map be? (Between 5x5 and 50x50)\n"+
                "How many teams will be playing? (2-3 Teams)";
        l.setup(sc);
        assertTrue(ConsoleOut.toString().contains(output));

    }

}