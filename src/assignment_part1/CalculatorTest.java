import static org.junit.Assert.*;

/**
 * Created by Thomas on 14/02/2017.
 */
public class CalculatorTest {

    Calculator c = new Calculator();

    @org.junit.Test
    public void add() {
        assertEquals(5, c.add(2,3));
    }

    @org.junit.Test
    public void subtract(){
        assertEquals(8, c.subtract(10,2));
    }

    @org.junit.Test
    public void multiply(){
        assertEquals(6, c.multiply(2,3));
    }

    @org.junit.Test
    public void divide(){
        assertEquals(10, c.divide(100,10));
    }

    @org.junit.Test
    public void divide_div0(){
        assertEquals(-999, c.divide(100,0));
    }
}