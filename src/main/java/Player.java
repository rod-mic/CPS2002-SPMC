package main.java;

import main.exceptions.InvalidDirectionException;
import main.exceptions.InvalidPositionException;
import main.exceptions.WaterTileHitException;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Player {

    Position position;
    Position startPosition;

    Player(Map map){
        int size = map.getMapSize();
        boolean check = false;
        int x = 0;
        int y = 0;

        while(!check) {
            x = (int) Math.random() * size;
            y = (int) Math.random() * size;
            if (map.getTileType(new Position(x,y)) != 'G') check = false;
            else check = true;
        }

        startPosition = new Position(x,y);
        position = startPosition;
    }

    void move(char direction, Map map) throws InvalidDirectionException, InvalidPositionException, WaterTileHitException {
        int x = position.getX();
        int y = position.getY();
        boolean check;
        switch(direction) {
            case 'U':
                check = setPosition(new Position(x, y + 1), map);
                break;
            case 'D':
                check = setPosition(new Position(x, y - 1), map);
                break;
            case 'L':
                check = setPosition(new Position(x - 1, y), map);
                break;
            case 'R':
                check = setPosition(new Position(x + 1, y), map);
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
        else if(map.getTileType(position) == 'W'){
            moveToStart();
            throw new WaterTileHitException();
        }
    }

    private boolean setPosition(Position p, Map map){
        boolean check = checkPosition(p,map);

        if(check) position = p;
        return check;
    }

    boolean checkPosition(Position p, Map map) {
        int size = map.getMapSize();
        int x = p.getX();
        int y = p.getY();

        return !(x < 0 || x > size || y < 0 || y > size);
    }

    private void moveToStart() {
        position = startPosition;
    }
}
