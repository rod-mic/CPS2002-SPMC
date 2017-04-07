package main.Tests;

import main.exceptions.InvalidDirectionException;
import main.exceptions.InvalidPositionException;
import main.java.Map;
import main.java.Player;
import main.java.Position;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rodemic on 07/04/2017.
 */
public class PlayerTest {
    Player p;
    Map map;

    @org.junit.Test
    public void moveUp() throws Exception, InvalidPositionException {
        p.move('U',map);
    }

    @org.junit.Test
    public void moveDown() throws Exception, InvalidPositionException {
        p.move('D',map);
    }

    @org.junit.Test
    public void moveLeft() throws Exception, InvalidPositionException {
        p.move('L',map);
    }

    @org.junit.Test
    public void moveRight() throws Exception, InvalidPositionException {
        p.move('R',map);
    }

    @org.junit.Test(expected = InvalidDirectionException.class)
    public void moveInvalidDirection() throws Exception, InvalidPositionException {
        p.move('T',map);
    }

    @org.junit.Test
    public void checkPositionX_Min() throws Exception {
        Position position = new Position(-1,0);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionX_Max() throws Exception {
        //TODO
        map = new Map();
        Position position = new Position(0,0);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionY_Min() throws Exception {
        Position position = new Position(0,-1);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionY_Max() throws Exception {
        //TODO
        map = new Map();
        Position position = new Position(0,0);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionTrue() throws Exception {
        Position position = new Position(0,0);
        assertEquals(true,p.checkPosition(position,map));
    }
}