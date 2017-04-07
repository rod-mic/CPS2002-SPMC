package com.CPS2002.assignment.Exceptions;

/**
 * Created by rodemic on 07/04/2017.
 */
public class InvalidDirectionException extends Exception {
    public InvalidDirectionException() {}

    public InvalidDirectionException(String message){
        super(message);
    }
}
