import Exceptions.InvalidDirectionException;
import Exceptions.InvalidPositionException;
import Objects.Map;
import Objects.Player;
import Objects.Position;

import static org.junit.Assert.*;

/**
 * Created by thoma on 17/04/2017.
 */
public class PlayerTest {

    Map m = new Map();
    Player p;

    @org.junit.Before
    public void Before() {
        m.setMapSize(6, 2,1);
        p = new Player(m);
    }

    @org.junit.Test
    public void checkAddPosition() {
        Position ps = new Position(0, 1);
        assertEquals(true, p.addPosition(ps));
    }

    @org.junit.Test
    public void getPreviousPosition() {
        assertNotNull(p.getPreviousPositions());
    }

    @org.junit.Test
    public void checkMoveUp() {
        assertEquals(true, p.move('U'));
    }

    @org.junit.Test
    public void checkMoveDown() {
        assertEquals(true, p.move('D'));
    }

    @org.junit.Test
    public void checkMoveLeft() {
        assertEquals(true, p.move('L'));
    }

    @org.junit.Test
    public void checkMoveRight() {
        assertEquals(true, p.move('R'));
    }

    @org.junit.Test
    public void checkDirectionTestUp() throws InvalidPositionException, InvalidDirectionException {
        try {
            p.setPosition(new Position(0, 0));
            p.checkDirection('U', m);
            fail();
        } catch (InvalidPositionException e) {
            final String expected = "The player has hit the top wall";
            assertEquals(expected, e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestDown() throws InvalidPositionException, InvalidDirectionException {
        try {
            p.setPosition(new Position(5, 5));
            p.checkDirection('D', m);
            fail();
        } catch (InvalidPositionException e) {
            final String expected = "The player has hit the bottom wall";
            assertEquals(expected, e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestLeft() throws InvalidPositionException, InvalidDirectionException {
        try {
            p.setPosition(new Position(0, 0));
            p.checkDirection('L', m);
            fail();
        } catch (InvalidPositionException e) {
            final String expected = "The player has hit the left wall";
            assertEquals(expected, e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestRight() throws InvalidPositionException, InvalidDirectionException {
        try {
            p.setPosition(new Position(5, 5));
            p.checkDirection('R', m);
            fail();
        } catch (InvalidPositionException e) {
            final String expected = "The player has hit the right wall";
            assertEquals(expected, e.getMessage());
        }
    }

    @org.junit.Test(expected = InvalidDirectionException.class)
    public void checkDirectionTestInvalid() throws InvalidPositionException, InvalidDirectionException {
        p.setPosition(new Position(5, 5));
        p.checkDirection('H', m);
    }

    @org.junit.Test
    public void checkDirectionTestWork() throws InvalidPositionException, InvalidDirectionException {
        p.setPosition(new Position(3, 3));
        assertEquals(true, p.checkDirection('U', m));
    }

    @org.junit.Test
    public void checkPositionTest() {
        Position ps = new Position(3, 3);
        assertEquals(true, p.checkPosition(ps, m));
    }

    @org.junit.Test
    public void checkGetStartPosition() {
        assertNotNull(p.getStartPosition());
    }

    @org.junit.Test
    public void checkMoveToStart() {
        assertEquals(true, p.moveToStart());
    }

    @org.junit.Test
    public void checkGetPosition() {
        assertNotNull(p.getPosition());
    }

    @org.junit.Test
    public void checkSetPosition() {
        Position ps = new Position(2, 3);
        assertEquals(true, p.setPosition(ps));
    }
}
