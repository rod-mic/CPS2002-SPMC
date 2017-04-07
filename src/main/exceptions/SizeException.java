package main.exceptions;

/**
 * Created by rodemic on 07/04/2017.
 */
public class SizeException extends Throwable {
    public SizeException(String size){
        super(size);
    }
}
