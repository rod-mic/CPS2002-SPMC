/**
 * Created by rodemic on 04/04/2017.
 */
public class Calculator {
    //Methods

    public int add(int a, int b){
        return a+b;
    }
    public int subtract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b){
        if(b == 0) return -999;
        else return a/b;
    }

}

