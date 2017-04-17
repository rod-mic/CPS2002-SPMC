package com.CPS2002.assignment.Tests;

import com.CPS2002.assignment.Objects.Position;

import static org.junit.Assert.assertEquals;

/**
 * Created by thoma on 17/04/2017.
 */
public class PositionTest {
    Position p = new Position(0,1);

    @org.junit.Test
    public void checkGetX(){assertEquals(0,p.getX());}

    @org.junit.Test
    public void checkGetY(){assertEquals(1,p.getY());}

    @org.junit.Test
    public void checkEqualsWhenNull(){
        String s = new String();
        assertEquals(false, p.equals(s));
    }

    @org.junit.Test
    public void checkEqualsWhenEqual(){
        Position p2 = new Position(0,1);
        assertEquals(true, p.equals(p2));
    }

    @org.junit.Test
    public void checkEqualsWhenNotEqual(){
        Position p2 = new Position(0,6);
        assertEquals(false, p.equals(p2));
    }



}
