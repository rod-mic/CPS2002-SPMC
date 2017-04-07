package main.exceptions;

/**
 * Created by rodemic on 07/04/2017.
 */
public class InvalidPositionException extends Throwable {
    public InvalidPositionException() {}

    public InvalidPositionException(String message){
        super(message);
    }
}
