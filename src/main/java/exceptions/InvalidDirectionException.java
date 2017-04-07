package exceptions;

/**
 * Created by rodemic on 07/04/2017.
 */
public class InvalidDirectionException extends Exception {
    public InvalidDirectionException() {}

    public InvalidDirectionException(String message){
        super(message);
    }
}
