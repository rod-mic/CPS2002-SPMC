package com.CPS2002.assignment.Path.Algorithm;

import com.CPS2002.assignment.Path.DataObjects.Graph;
import com.CPS2002.assignment.Path.DataObjects.Node;

import java.util.Vector;

/**
 * Created by Thomas on 21/03/2017.
 */

public class Algorithm {
    Node rootNode;
    Node goal;

    Algorithm(Graph g){
        rootNode = g.getRootNode();
        goal = g.getGoalNode();
    }
}
