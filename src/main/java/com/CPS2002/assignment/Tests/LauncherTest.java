package com.CPS2002.assignment.Tests;

import com.CPS2002.assignment.Launcher;
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
    Launcher l = new Launcher();
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    public void IncorrectUserAmount() throws Exception {
        systemInMock.provideLines("9","2","50");
        String output = "Welcome to the game!\n" +
                "How many users will be playing? (2-8 Players)\n" +
                "There can only be between 2 and 8 players. Try again: \n" +
                "How big  will the map be? (Between 5x5 and 50x50)";
        l.setup();
        assertEquals(output,systemOutRule.getLog().trim());
    }

}