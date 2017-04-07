package Algorithms;

import DataObjects.Node;
import Graph.Graph;

import java.util.Vector;

/**
 * Created by Thomas on 21/03/2017.
 */
public class Algorithm {
    Node rootNode;
    Vector<Node> goalNodes;

    public Algorithm(Graph g){
        rootNode = g.getRootNode();
        goalNodes = g.getGoalNodes();
    }

    public void removeGoal(Node n){
        for(int i = 0; i < goalNodes.size(); i++){
            if(n == goalNodes.elementAt(i)) goalNodes.remove(i);
        }
    }

    public String pathToString(Vector<Vector<Node>> allPaths){
        String result = "";
        for(int i = 0; i < allPaths.size(); i++){
            double cost = 0;
            for(int j = 0; j < allPaths.elementAt(i).size()-1; j++){
                result += allPaths.elementAt(i).elementAt(j).getName() + " -> ";
                cost += allPaths.elementAt(i).elementAt(j+1).getParentEdge().getValue();
            }
            cost = Math.round(cost * 10000.0) / 10000.0;
            result += allPaths.elementAt(i).lastElement().getName() + "\n||=> Final Cost["+cost+"].\n";
        }
        return result;
    }
}
