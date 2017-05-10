import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by rodemic on 17/04/2017.
 */
public class LauncherTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    Launcher l = new Launcher();

    @Test
    public void IncorrectUserAmount() throws Exception {
        systemInMock.provideLines("9", "2", "20");
        String output = "Welcome to the game!\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "There can only be between 2 and 8 players. Try again: \n" +
                "How big  will the map be? (Between 5x5 and 50x50)\n";
        l.setup();
        assertEquals(output, systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void IncorrectMapSizeSmall() throws Exception {
        systemInMock.provideLines("2", "4", "5");
        String output = "Welcome to the game!\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "How big  will the map be? (Between 5x5 and 50x50)\n" +
                "The size must be between 5x5 and 50x50 tiles. Try again: \n";
        l.setup();
        assertEquals(output, systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void IncorrectMapSizeBig() throws Exception {
        systemInMock.provideLines("6", "6", "8");
        String output = "Welcome to the game!\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "How big  will the map be? (Between 8x8 and 50x50)\n" +
                "The size must be between 8x8 and 50x50 tiles. Try again: \n";
        l.setup();
        assertEquals(output, systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void IncorrectInput() throws Exception {
        systemInMock.provideLines("a", "6", "a", "8");
        String output = "Welcome to the game!\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "Incorrect input. Numbers only. Try again: \n" +
                "How big  will the map be? (Between 8x8 and 50x50)\n" +
                "Incorrect input. Numbers only. Try again: \n";
        l.setup();
        assertEquals(output, systemOutRule.getLogWithNormalizedLineSeparator());
    }

}