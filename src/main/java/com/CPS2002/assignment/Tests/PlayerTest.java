package com.CPS2002.assignment.Tests;


import com.CPS2002.assignment.Exceptions.InvalidDirectionException;
import com.CPS2002.assignment.Exceptions.InvalidPositionException;
import com.CPS2002.assignment.Objects.Map;
import com.CPS2002.assignment.Objects.Player;
import com.CPS2002.assignment.Objects.Position;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rodemic on 07/04/2017.
 */
public class PlayerTest {
    private Player p;
    private Map map = new Map();

    @org.junit.Before
    public void Before(){
        map.setMapSize(5,4);
    }

    @org.junit.Test
    public void moveUp() throws Exception, InvalidPositionException {
        p = new Player(map);
        try{
            p.move('U',map);
        }catch(InvalidPositionException ex){
            System.out.println(ex);
        }
    }

    @org.junit.Test
    public void moveDown() throws Exception, InvalidPositionException {
        p = new Player(map);
        try{
            p.move('D',map);
        }catch(InvalidPositionException ex){
            System.out.println(ex);
        }
    }

    @org.junit.Test
    public void moveLeft() throws Exception, InvalidPositionException {
        p = new Player(map);
        try{
            p.move('L',map);
        }catch(InvalidPositionException ex){
            System.out.println(ex);
        }
    }

    @org.junit.Test
    public void moveRight() throws Exception, InvalidPositionException {
        p = new Player(map);
        try {
            p.move('R', map);
        }catch(InvalidPositionException ex){
            System.out.println(ex);
        }
    }

    @org.junit.Test(expected = InvalidDirectionException.class)
    public void moveInvalidDirection() throws Exception, InvalidPositionException {
        p = new Player(map);
        p.move('T',map);
    }

    @org.junit.Test
    public void checkPositionX_Min() throws Exception {
        Position position = new Position(-1,0);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionX_Max() throws Exception {
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
        Position position = new Position(0,0);
        assertEquals(false,p.checkPosition(position,map));
    }

    @org.junit.Test
    public void checkPositionTrue() throws Exception {
        Position position = new Position(0,0);
        assertEquals(true,p.checkPosition(position,map));
    }
}