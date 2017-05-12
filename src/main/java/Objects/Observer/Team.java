package Objects.Observer;

import Objects.Position;

import java.util.ArrayList;

/**
 * Created by rodemic on 12/05/2017.
 */
public class Team extends SubjectTeam {
    private ArrayList<Position> previousPositions = new ArrayList<>();

    public void addPosition(Position p) {
        if(!previousPositions.contains(p))
            previousPositions.add(p);
        Notify();
    }
    public ArrayList<Position> getPreviousPositions(){
        return previousPositions;
    }
}
