package Objects.Observer;

import Exceptions.InvalidDirectionException;
import Exceptions.InvalidPositionException;
import Objects.MapTypes.MapInterface;
import Objects.Position;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rodemic on 12/05/2017.
 */
public class Player extends PlayerObserver{
    private Position position;
    private Position startPosition;
    Team team;

    private ArrayList<Position> previousPositions = new ArrayList<>();

    public Player(MapInterface map) {
        int size = map.getMapSize();
        boolean check = false;
        int row;
        int col;

        while (!check) {
            row = ThreadLocalRandom.current().nextInt(0, size);
            col = ThreadLocalRandom.current().nextInt(0, size);
            Position pos = new Position(row, col);
            if (map.getTileType(pos) != 'G' || !map.checkPath(pos)) check = false;
            else {
                startPosition = pos;
                position = pos;
                Update(pos);
                check = true;
            }
        }
    }

    private void Update(Position pos) {
        team.addPosition(pos);
    }

    public boolean move(char direction) {
        int row = position.getRow();
        int col = position.getCol();
        Position pos = null;
        switch (direction) {
            case 'U':
                pos = new Position(row - 1, col);
                setPosition(pos);
                break;
            case 'D':
                pos = new Position(row + 1, col);
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
        team.addPosition(pos);
        return true;
    }

    public boolean checkDirection(char direction, MapInterface map) throws InvalidPositionException, InvalidDirectionException {
        int row = position.getRow();
        int col = position.getCol();
        switch (direction) {
            case 'U':
                if (!checkPosition(new Position(row - 1, col), map))
                    throw new InvalidPositionException("The player has hit the top wall");
                break;
            case 'D':
                if (!checkPosition(new Position(row + 1, col), map))
                    throw new InvalidPositionException("The player has hit the bottom wall");
                break;
            case 'L':
                if (!checkPosition(new Position(row, col - 1), map))
                    throw new InvalidPositionException("The player has hit the left wall");
                break;
            case 'R':
                if (!checkPosition(new Position(row, col + 1), map))
                    throw new InvalidPositionException("The player has hit the right wall");
                break;
            default:
                throw new InvalidDirectionException();
        }
        return true;
    }

    public boolean checkPosition(Position p, MapInterface map) {
        int size = map.getMapSize();
        int row = p.getRow();
        int col = p.getCol();

        return (row >= 0 && row < size && col >= 0 && col < size);
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public boolean moveToStart() {
        position = startPosition;
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public boolean setPosition(Position p) {
        position = p;
        return true;
    }

    public void Update(){
        previousPositions = team.getPreviousPositions();
    }

    public ArrayList<Position> getPreviousPositions() {
        return previousPositions;
    }
}
