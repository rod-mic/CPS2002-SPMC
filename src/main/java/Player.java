package main.java;

import main.exceptions.*;
import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Player {

    Position position;
    Position startPosition;

    Player(){
        Map map = getMap();
        int size = map.getMapSize();
        boolean check = false;
        while(!check) {
            int x = (int) Math.random() * size;
            int y = (int) Math.random() * size;
            if (map.getTileType(x, y) != 'G') check = false;
            else check = true;
        }
    }

    void move(char direction) throws InvalidDirectionException, InvalidPositionException{
        int x = position.getX();
        int y = position.getY();
        boolean check = true;
        switch(direction) {
            case 'U':
                check = setPosition(new Position(x, y + 1));
                break;
            case 'D':
                check = setPosition(new Position(x, y - 1));
                break;
            case 'L':
                check = setPosition(new Position(x - 1, y));
                break;
            case 'R':
                check = setPosition(new Position(x + 1, y));
                break;
            default:
                throw new InvalidDirectionException();
        }
        if(!check){
            switch(direction) {
                case 'U':
                    throw new InvalidPositionException("The player has hit the top wall");
                case 'D':
                    throw new InvalidPositionException("The player has hit the bottom wall");
                case 'L':
                    throw new InvalidPositionException("The player has hit the left wall");
                case 'R':
                    throw new InvalidPositionException("The player has hit the upper wall");
            }
        }
    }

    boolean setPosition(Position p){
        boolean check = checkPosition(p);
        if(check) position = p;
        return check;
    }

    boolean checkPosition(Position p){
        int size = map.getMapSize();
        if(p.getX() < 0 || p.getX() > size || p.getY() < 0 || p.getY() > size) return false;
        else return true;
    }

    void moveToStart(){
        position = startPosition;
    }
}
