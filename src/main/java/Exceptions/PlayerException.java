package Exceptions;

/**
 * Created by thoma on 13/05/2017.
 */
public class PlayerException extends Exception {
    public String errorMessage;

    public PlayerException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
