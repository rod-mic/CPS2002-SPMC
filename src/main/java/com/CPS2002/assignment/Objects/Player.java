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
        int row;
        int col;

        while(!check) {
            row = ThreadLocalRandom.current().nextInt(0,size);
            col = ThreadLocalRandom.current().nextInt(0,size);
            Position pos = new Position(row,col);
            if (map.getTileType(pos) != 'G' || !map.checkPath(pos)) check = false;
            else{
                startPosition = pos;
                position = pos;
                addPosition(pos);
                check = true;
            }
        }
    }

    public boolean addPosition(Position p){
        previousPositions.add(p);
        return true;
    }

    public ArrayList<Position> getPreviousPositions(){
        return previousPositions;
    }

    public boolean move(char direction) {
        int row = position.getRow();
        int col = position.getCol();
        Position pos = null;
        switch(direction) {
            case 'U':
                pos = new Position(row-1,col);
                setPosition(pos);
                break;
            case 'D':
                pos = new Position(row+1, y);
                setPosition(pos);
                break;
            case 'L':
                pos = new Position(row, col - 1);
                setPosition(pos);
                break;
            case 'R':
                pos = new Position(row, col + 1);
                setPosition(pos);
                break;
        }
        addPosition(pos);
        return true;
    }

    public boolean checkDirection(char direction, Map map) throws InvalidPositionException, InvalidDirectionException{
        int row = position.getRow();
        int col = position.getCol();
        switch(direction) {
            case 'U':
                if (!checkPosition(new Position(row-1, col),map))
                    throw new InvalidPositionException("The player has hit the top wall");
                break;
            case 'D':
                if (!checkPosition(new Position(row+1, col),map))
                    throw new InvalidPositionException("The player has hit the bottom wall");
                break;
            case 'L':
                if (!checkPosition(new Position(row, col-1),map))
                    throw new InvalidPositionException("The player has hit the left wall");
                break;
            case 'R':
                if (!checkPosition(new Position(row, col+1),map))
                    throw new InvalidPositionException("The player has hit the right wall");
                break;
            default: throw new InvalidDirectionException();
        }
        return true;
    }

    public boolean checkPosition(Position p, Map map) {
        int size = map.getMapSize();
        int row = p.getRow();
        int col = p.getCol();

        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    public Position getStartPosition(){
        return startPosition;
    }

    public void moveToStart() {
        position = startPosition;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position p){
        position = p;
    }
}
