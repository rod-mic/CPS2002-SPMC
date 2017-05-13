import Exceptions.*;
import Objects.MapTypes.*;
import Objects.Position;
import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by thoma on 07/04/2017.
 */
public class MapTest {
    final private MapCreator mc = new MapCreator();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @org.junit.Test
    public void check_Map_Creator_default(){
        TestCase.assertNotNull(mc.createMap(5,3));
    }

    @org.junit.Test
    public void setMap_2player_goodSize_safeMap() {
        TestCase.assertNotNull(mc.createMap(6,2,1));
    }

    @org.junit.Test
    public void setMap_2player_goodSize_hazMap() {
        TestCase.assertNotNull(mc.createMap(6,2,2));
    }

    @org.junit.Test
    public void setMap_5player_goodSize_safeMap() {

        TestCase.assertNotNull(mc.createMap(9,5,1));
    }

    @org.junit.Test
    public void setMap_5player_goodSize_hazMap() {
        TestCase.assertNotNull(mc.createMap(9,5,2));
    }

    @org.junit.Test
    public void setMap_2player_badSize_safeMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_2player_badSize_hazMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_5player_badSize_safeMap() {

        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_5player_badSize_hazMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_below_Min_Player_safeMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_below_Min_Player_hazMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_above_Max_Player_safeMap() {

        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void setMap_above_Max_Player_hazMap() {
        exit.expectSystemExit();
        System.exit(0);
    }

    @org.junit.Test
    public void checkGenerate() {
        Map m = new Map();
        assertEquals(true,m.generate());
    }

    @org.junit.Test
    public void get_Map_Size_safeMap() {
        MapInterface sm = mc.createMap(6,3,1);
        assertEquals(6,sm.getMapSize());
    }

    @org.junit.Test
    public void get_Map_Size_hazMap() {
        MapInterface hm = mc.createMap(6,3,2);
        assertEquals(6,hm.getMapSize());
    }

    @org.junit.Test
    public void check_Treasure_Position_safeMap(){
        MapInterface sm = mc.createMap(6,3,1);
        TestCase.assertNotNull(sm.getTreasurePos());
    }

    @org.junit.Test
    public void check_Treasure_Position_hazMap(){
        MapInterface hm = mc.createMap(6,3,2);
        TestCase.assertNotNull(hm.getTreasurePos());
    }

    @org.junit.Test
    public void check_Tile_Type_safeMap(){
        MapInterface sm = mc.createMap(6,3,1);
        assertEquals('T',sm.getTileType(sm.getTreasurePos()));
    }

    @org.junit.Test
    public void check_Tile_Type_hazMap(){
        MapInterface hm = mc.createMap(6,3,2);
        assertEquals('T',hm.getTileType(hm.getTreasurePos()));
    }

    @org.junit.Test
    public void check_Init_map(){
        Map m = new Map();
        assertEquals(true, m.initMap(5));
    }

    @org.junit.Test
    public void checkOutPutMap() {
        Map m = new Map();
        assertEquals(true, m.outputMap());
    }

    @org.junit.Test
    public void checkAnyPathsTest_safeMap() {
        MapInterface sm = mc.createMap(6,3,1);
        assertEquals(true, sm.checkAnyPaths(3));
    }

    @org.junit.Test
    public void checkAnyPathsTest_hazMap() {
        MapInterface hm = mc.createMap(6,3,2);
        assertEquals(true, hm.checkAnyPaths(3));
    }

    @org.junit.Test
    public void checkPathTest_safeMap() {
        MapInterface sm = mc.createMap(6,3,1);
        assertNotNull(sm.checkPath(new Position(0, 1)));
    }

    @org.junit.Test
    public void checkPathTest_hazMap() {
        MapInterface hm = mc.createMap(6,3,2);
        assertNotNull(hm.checkPath(new Position(0, 1)));
    }

    @org.junit.Test
    public void checkGetMap() {
        Map m = new Map();
        m.initMap(5);
        assertNotNull(m.getMap());
    }
}
