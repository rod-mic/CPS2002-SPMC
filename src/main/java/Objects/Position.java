package Objects;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Position {
    private int row;
    private int column;

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return column;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Position))return false;
        Position pos = (Position)other;
        return (pos.getRow() == getRow() && pos.getCol() == getCol());
    }
}
