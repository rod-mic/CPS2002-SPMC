import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Thomas on 14/02/2017.
 */
public class CalculatorTest {

    Calculator c = new Calculator();

    @Test
    public void add() {
        assertEquals(5, c.add(2,3));
    }

    @Test
    public void subtract(){
        assertEquals(8, c.subtract(10,2));
    }

    @Test
    public void multiply(){
        assertEquals(6, c.multiply(2,3));
    }

    @Test
    public void divide(){
        assertEquals(10, c.divide(100,10));
    }

    @Test
    public void divide_div0(){
        assertEquals(-999, c.divide(100,0));
    }
}