import Objects.Position;
import Path.DataObjects.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by thoma on 17/04/2017.
 */
public class NodeTest {

    private Node n = new Node();

    private Position p = new Position(1, 1);
    private Node n2 = new Node(p, 'G');

    @org.junit.Before
    public void Before() {
        n2.setStart();
        n.setParent(n2);
        n2.addChildNode(n);
        Position p2 = new Position(1, 2);
        n.setPosition(p2);
    }

    @org.junit.Test
    public void checkPositionConstructor2() {
        assertEquals(p, n2.getPosition());
    }

    @org.junit.Test
    public void checkTileConstructor2() {
        assertEquals(false, n2.isWaterTile());
        assertEquals(false, n2.isTreasureTile());
    }

    @org.junit.Test
    public void checkStart() {
        assertEquals(true, n.setStart());
    }

    @org.junit.Test
    public void checkTreasure() {
        assertEquals(true, n.setTreasureTile());
    }

    @org.junit.Test
    public void checkWater() {
        assertEquals(true, n.setWaterTile());
    }

    @org.junit.Test
    public void checkGetPosition() {
        Position p2 = new Position(1, 2);
        assertEquals(true, n.setPosition(p2));
    }

    @org.junit.Test
    public void checkParent() {
        assertEquals(true, n.setParent(n2));
    }

    @org.junit.Test
    public void checkChild() {
        assertEquals(true, n2.addChildNode(n));
    }

    @org.junit.Test
    public void checkGetParent() {
        assertEquals(n2, n.getParent());
    }

    @org.junit.Test
    public void getParentWhenNull() {
        assertNull(n2.getParent());
    }

    @org.junit.Test
    public void checkGetStart() {
        assertEquals(true, n2.getStart());
    }

    @org.junit.Test
    public void checkGetStartWhenFalse() {
        assertEquals(false, n.getStart());
    }

    @org.junit.Test
    public void checkIsWater() {
        assertEquals(false, n.isWaterTile());
    }

    @org.junit.Test
    public void checkIsTreasure() {
        assertEquals(false, n.isTreasureTile());
    }

    @org.junit.Test
    public void checkGetChildNodes() {
        assertNull(n.getChildNodes());
    }

    @org.junit.Test
    public void checkSetValues() {
        Node n3 = new Node();
        assertEquals(true, n3.setValues('T'));
    }

    @org.junit.Test
    public void checkShowChildPos() {
        assertEquals("1,2|", n2.showChildPos());
    }

}
