package Objects;

import java.util.ArrayList;

/**
 * Created by rodemic on 11/05/2017.
 */
public class Team {
    private ArrayList<Position> previousPositions = new ArrayList<>();

    public boolean addPosition(Position p) {
        if(!previousPositions.contains(p))
            previousPositions.add(p);
        return true;
    }

    public ArrayList<Position> getPreviousPositions() {
        return previousPositions;
    }
}
