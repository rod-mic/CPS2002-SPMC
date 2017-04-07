package Path.Algorithm;

import Path.DataObjects.*;
import java.util.Vector;

/**
 * Created by Thomas on 21/03/2017.
 */
public class Algorithm {
    Node rootNode;
    Node goal;

    public Algorithm(Graph g){
        rootNode = g.getRootNode();
        goal = g.getGoalNode();
    }

    public String pathToString(Vector<Vector<Node>> allPaths){
        String result = "";
        for(int i = 0; i < allPaths.size(); i++){
            for(int j = 0; j < allPaths.elementAt(i).size()-1; j++){
                result += allPaths.elementAt(i).elementAt(j).getName() + " -> ";
            }
            result += allPaths.elementAt(i).lastElement().getName() + "\n";
        }
        return result;
    }
}
