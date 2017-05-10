import Objects.Map;
import Objects.Position;
import Path.Algorithm.BreathFirst;
import Path.DataObjects.Graph;
import Path.DataObjects.Node;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by thoma on 17/04/2017.
 */
public class BreathFirstTest {

    Map m = new Map();
    Graph g;
    BreathFirst b;

    @org.junit.Before
    public void Before() {
        m.setMapSize(5, 2);
        m.generate();
        g = new Graph(m, new Position(0, 1), m.getTreasurePos());
        b = new BreathFirst(g);
    }

    @org.junit.Test
    public void checkPathTest() {
        assertEquals(true, b.checkPath());
    }

    @org.junit.Test
    public void checkReverseVector() {
        Vector<Node> v = new Vector<>();
        Node n1 = new Node(new Position(0, 0), 'G');
        Node n2 = new Node(new Position(0, 1), 'T');
        Node n3 = new Node(new Position(0, 2), 'W');
        assertNotNull(b.reverseVector(v));
    }

    @org.junit.Test
    public void checkGetPathTest() {
        Vector<Node> start = new Vector<>();
        Vector<Node> path = new Vector<>();
        Vector<Node> checked = new Vector<>();
        Vector<Vector<Node>> levels = new Vector<>();
        start.add(b.getRootNode());
        checked.add(b.getRootNode());
        levels.add(start);
        assertNotNull(b.getPath(start, path, checked, levels, 0));
    }

    @org.junit.Test
    public void checkGetRootNode() {
        assertNotNull(b.getRootNode());
    }

}
