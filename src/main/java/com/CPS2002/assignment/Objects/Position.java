package com.CPS2002.assignment.Objects;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Position {
    private int x;
    private int y;

    public Position(){}

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Position))return false;
        Position pos = (Position)other;
        return (pos.getX() == getX() && pos.getY() == getY());
    }
}
