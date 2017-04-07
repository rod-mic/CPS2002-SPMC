package DataObjects;

/**
 * Created by Thomas on 21/03/2017.
 */

import java.util.Set;
import java.util.Vector;

public class Node {
    private String name;
    private boolean start = false;
    private boolean goal = false;
    private Edge parentEdge;
    private Vector<Node> parentNodes;
    private Vector<Edge> edges;
    private Vector<Node> childNodes;
    private double costFromStart = -1;

    public Node(){};

    public Node(String name){
        this.name = name;
        parentEdge = new Edge();
        parentNodes = new Vector<>();
        edges = new Vector<>();
        childNodes = new Vector<>();
    }

    public void setParentEdge(Edge e){
        parentEdge = e;
        parentNodes.add(e.getParent());
    }

    public void setName(String n){
        name = n;
    }

    public void setStart(){
        start = true;
        name += "*";
        costFromStart = 0;
    }
    public void setGoal(){
        goal = true;
        name += "!";
    }

    public void setChildNodes(){
        for(int i = 0; i < edges.size();i++){
            childNodes.add(edges.elementAt(i).getChild());
        }
    }

    public Edge getParentEdge(){
        return parentEdge;
    }

    public Vector<Node> getParentNodes(){
        return parentNodes;
    }

    public double getCostFromStart(){ return costFromStart; }

    public Vector<Edge> getEdges(){
        return edges;
    }

    public String getName(){
        return name;
    }

    public boolean getStart(){
        return start;
    }

    public boolean getGoal(){
        return goal;
    }

    public Vector<Node> getChildNodes(){
        return childNodes;
    }

    public void addEdge(Edge e){
        edges.add(e);
        addChildNode(e.getChild());
    }

    public void addChildNode(Node n){
        childNodes.add(n);
    }

    public String getChildNames(){
        String result = "[ ";
        for(int i = 0; i < childNodes.size(); i++){
            result += childNodes.elementAt(i).getName() + " ";
        }
        result += "]";
        return result;
    }

    public boolean checkParent(){
        return parentNodes.size() != 0;
    }

    public boolean checkIfParent(Node n){
        for(int i = 0 ; i < parentNodes.size(); i++){
            if(n == parentNodes.elementAt(i)) return true;
        }
        return false;
    }

    public String toString(){
        return name + "->" + getChildNames();
    }

    public String getParentString(){
        String result = "[ ";
        for(int i = 0; i < parentNodes.size(); i++){
            result += parentNodes.elementAt(i).getName() + " ";
        }
        result += "]";
        return result;
    }
}
