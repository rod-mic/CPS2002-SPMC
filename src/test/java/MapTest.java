import Objects.Map;
import Objects.Position;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by thoma on 07/04/2017.
 */
public class MapTest {
    final private Map m = new Map();

    @org.junit.Test
    public void setMap_2player_goodSize() {
        assertEquals(true, m.setMapSize(6, 3,1));
    }

    @org.junit.Test
    public void setMap_5player_goodSize() {
        assertEquals(true, m.setMapSize(9, 5,1));
    }

    @org.junit.Test
    public void setMap_2player_badSize() {
        assertEquals(false, m.setMapSize(4, 3,1));
    }

    @org.junit.Test
    public void setMap_5player_badSize() {
        assertEquals(false, m.setMapSize(7, 6,2));
    }

    @org.junit.Test
    public void setMap_below_Min_Player() {
        assertEquals(false, m.setMapSize(5, 1, 2));
    }

    @org.junit.Test
    public void setMap_above_Max_Player() {
        assertEquals(false, m.setMapSize(8, 9,2));
    }

    @org.junit.Test
    public void get_map_size() {
        m.setMapSize(5, 4,1);
        assertEquals(5, m.getMapSize());
    }

    @org.junit.Test
    public void checkOutPutMap() {
        m.setMapSize(5, 2,1);
        assertEquals(true, m.outputMap());
    }

    @org.junit.Test
    public void checkGenerate() {
        m.setMapSize(5,2,1);
        assertEquals(true, m.generate(0,10));
    }

    @org.junit.Test
    public void checkMapSize() {
        m.setMapSize(6, 3,1);
        assertEquals(6, m.getMapSize());
    }

    @org.junit.Test
    public void checkGetTile() {
        m.setMapSize(5, 2,1);
        assertNotNull(m.getTileType(new Position(0, 1)));
    }

    @org.junit.Test
    public void checkAnyPathsTest() {
        m.setMapSize(5, 2,1);
        assertEquals(true, m.checkAnyPaths(2));
    }

    @org.junit.Test
    public void checkGetMap() {
        m.setMapSize(5, 2,1);
        assertNotNull(m.getMap());
    }

    @org.junit.Test
    public void checkPathTest() {
        m.setMapSize(5, 2,1);
        assertNotNull(m.checkPath(new Position(0, 1)));
    }

}
