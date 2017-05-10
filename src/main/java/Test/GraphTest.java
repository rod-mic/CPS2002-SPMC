package Test;

import com.CPS2002.assignment.Objects.Map;
import com.CPS2002.assignment.Objects.Position;
import com.CPS2002.assignment.Path.DataObjects.Graph;
import com.CPS2002.assignment.Path.DataObjects.Node;

import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by thoma on 17/04/2017.
 */
public class GraphTest {

    Map m = new Map();
    Graph g;

    @org.junit.Before
    public void Before() {
        m.setMapSize(5, 2);
        m.generate();
        g = new Graph(m,new Position(0,1), m.getTreasurePos());
    }

    @org.junit.Test
    public void checkGraphConstructor(){
        Graph g = new Graph(m,new Position(2,1), m.getTreasurePos());
        assertNotNull(g.getListOfNodes());
        assertNotNull(g.getRootNode());
    }

    @org.junit.Test()
    public void checkSetNodes(){
        Vector<Node> start = new Vector<>();
        Vector<Node> checked = new Vector<>();

        start.add(g.getRootNode());

        assertEquals(true,g.setNodes(start,checked));
    }

    @org.junit.Test()
    public void checkNodebyPosition(){
        assertNotNull(g.getNodeByPosition(new Position(0,1)));
    }

    @org.junit.Test()
    public void checkGetListOfNodes(){
        assertNotNull(g.getListOfNodes());
    }


    @org.junit.Test()
    public void checkGetRootNode(){
        assertNotNull(g.getRootNode());
    }
}
