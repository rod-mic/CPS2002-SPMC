package com.CPS2002.assignment.Tests;

import com.CPS2002.assignment.Exceptions.InvalidDirectionException;
import com.CPS2002.assignment.Exceptions.InvalidPositionException;
import com.CPS2002.assignment.Objects.Map;
import com.CPS2002.assignment.Objects.Player;
import com.CPS2002.assignment.Objects.Position;
import org.omg.CORBA.DynAnyPackage.Invalid;

import static org.junit.Assert.*;

/**
 * Created by thoma on 17/04/2017.
 */
public class PlayerTest {

    Map m;
    Player p;

    @org.junit.Before
    public void Before() {
        m.setMapSize(6,2);
        p = new Player(m);
    }

    @org.junit.Test
    public void checkAddPosition(){
        Position ps = new Position(0,1);
        assertEquals(true,p.addPosition(ps));
    }

    @org.junit.Test
    public void getPreviousPosition(){
        assertNotNull(p.getPreviousPositions());
    }

    @org.junit.Test
    public void checkMove(){
        assertEquals(true,p.move('U'));
    }

    @org.junit.Test
    public void checkDirectionTestUp() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(5,0));
            p.checkDirection('U',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestDown() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(5,0));
            p.checkDirection('D',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestLeft() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(0,5));
            p.checkDirection('L',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestRight() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(5,0));
            p.checkDirection('R',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestInvalid() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(5,5));
            p.checkDirection('U',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

    @org.junit.Test
    public void checkDirectionTestWork() throws InvalidPositionException, InvalidDirectionException{
        try{
            p.setPosition(new Position(5,5));
            p.checkDirection('U',m);
            fail();
        }catch(InvalidPositionException e){
            final String expected = "The player has hit the top wall";
            assertEquals(expected,e.getMessage());
        }
    }

}
