import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Thomas on 14/02/2017.
 */
public class MathUtilsTest {
/*    @Before
    public void test_Max(){
        m = new MathUtils();
    }

    @After
    public void test_Max(){
        m = null;
    }*/

    MathUtils m = new MathUtils();
    File f = new File("text.txt");


    @Test
    public void max_n(){
        assertEquals(0,m.max(""));
    }
    @Test
    public void max_1214(){
        assertEquals(1214,m.max("999,2,1214"));
    }

    @Test
    public void max_exception(){
        assertEquals(0,m.max((String)null));
    }

    @Test
    public void max_exception2(){
        assertEquals(0,m.max("123,afd,244"));
    }
    @Test
    public void max_5(){
        assertEquals(5,m.max("5,5,5,5,5,5,5,5,5,5,5,5,5,5"));
    }
    @Test
    public void max_123n(){
        assertEquals(-123,m.max("-1515,-123,-200"));
    }

    @Test
    public void max_n_File(){
        assertEquals(0,m.max(f));
    }
    @Test
    public void max_1214_File(){
        assertEquals(1214,m.max(f));
    }

    @Test
    public void max_exception_File(){
        assertEquals(0,m.max((File)null));
    }

    @Test
    public void max_exception2_File(){
        assertEquals(0,m.max(f));
    }
    @Test
    public void max_5_File(){
        assertEquals(5,m.max(f));
    }
    @Test
    public void max_123n_File(){
        assertEquals(-123,m.max(f));
    }

    @Test
    public void max_File_Exception(){
        File f2 = new File("text2.txt");
        assertEquals(0,m.max(f2));
    }
}