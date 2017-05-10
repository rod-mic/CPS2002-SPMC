package Path.Algorithm;

import Path.DataObjects.Graph;
import Path.DataObjects.Node;

/**
 * Created by Thomas on 21/03/2017.
 */

class Algorithm {
    final Node rootNode;

    Algorithm(Graph g){
        rootNode = g.getRootNode();
    }
}
