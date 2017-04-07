package com.CPS2002.assignment.Exceptions;

/**
 * Created by rodemic on 07/04/2017.
 */
public class WaterTileHitException extends Exception {

    public WaterTileHitException(){
        super("The player has hit a water tile");
    }
}
