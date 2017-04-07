package com.CPS2002.assignment.Objects;

import com.CPS2002.assignment.Exceptions.InvalidDirectionException;
import com.CPS2002.assignment.Exceptions.InvalidPositionException;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Player {

    private Position position;
    private Position startPosition;
    final private ArrayList<Position> previousPositions = new ArrayList<>();

    public Player(Map map){
        int size = map.getMapSize();
        boolean check = false;
        int x;
        int y;

        while(!check) {
            x = ThreadLocalRandom.current().nextInt(0,size);
            y = ThreadLocalRandom.current().nextInt(0,size);
            Position pos = new Position(x,y);
            if (map.getTileType(pos) != 'G' || !map.checkPath(pos)) check = false;
            else{
                startPosition = pos;
                position = pos;
                addPosition(pos);
                check = true;
            }
        }
    }

    private void addPosition(Position p){
        previousPositions.add(p);
    }

    ArrayList<Position> getPreviousPositions(){
        return previousPositions;
    }

    void move(char direction) {
        int x = position.getX();
        int y = position.getY();
        Position pos = null;
        switch(direction) {
            case 'U':
                pos = new Position(x,y+1);
                setPosition(pos);
                break;
            case 'D':
                pos = new Position(x, y - 1);
                setPosition(pos);
                break;
            case 'L':
                pos = new Position(x - 1, y);
                setPosition(pos);
                break;
            case 'R':
                pos = new Position(x + 1, y);
                setPosition(pos);
                break;
        }
        addPosition(pos);
    }

    void checkDirection(char direction, Map map) throws InvalidPositionException, InvalidDirectionException{
        int x = position.getX();
        int y = position.getY();
        switch(direction) {
            case 'U':
                if (!checkPosition(new Position(x, y+1),map))
                    throw new InvalidPositionException("The player has hit the top wall");
                break;
            case 'D':
                if (!checkPosition(new Position(x, y-1),map))
                    throw new InvalidPositionException("The player has hit the bottom wall");
                break;
            case 'L':
                if (!checkPosition(new Position(x-1, y),map))
                    throw new InvalidPositionException("The player has hit the left wall");
                break;
            case 'R':
                if (!checkPosition(new Position(x+1, y),map))
                    throw new InvalidPositionException("The player has hit the upper wall");
                break;
            default: throw new InvalidDirectionException();
        }
    }

    private boolean checkPosition(Position p, Map map) {
        int size = map.getMapSize();
        int x = p.getX();
        int y = p.getY();

        return (x >= 0 && x < size && y >= 0 && y < size);
    }

    Position getStartPosition(){
        return startPosition;
    }

    void moveToStart() {
        position = startPosition;
    }

    Position getPosition() {
        return position;
    }

    private void setPosition(Position p){
        position = p;
    }
}
