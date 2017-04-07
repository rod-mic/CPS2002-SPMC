package main.Tests;

import main.java.Map;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by thoma on 07/04/2017.
 */
public class MapTest {
    Map m = new Map();

    @org.junit.Test
    public void setMap_2player_goodSize(){
        assertEquals(true, m.setMapSize(6,3));
    }

    @org.junit.Test
    public void setMap_5player_goodSize(){
        assertEquals(true, m.setMapSize(9,5));
    }

    @org.junit.Test
    public void setMap_2player_badSize(){
        assertEquals(false, m.setMapSize(4,3));
    }

    @org.junit.Test
    public void setMap_5player_badSize(){
        assertEquals(false, m.setMapSize(7,6));
    }

    @org.junit.Test
    public void setMap_below_Min_Player(){
        assertEquals(false, m.setMapSize(5,1));
    }

    @org.junit.Test
    public void setMap_above_Max_Player(){
        assertEquals(false, m.setMapSize(8,9));
    }
}
