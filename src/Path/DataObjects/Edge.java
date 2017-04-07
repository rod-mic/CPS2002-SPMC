package DataObjects;

/**
 * Created by Thomas on 21/03/2017.
 */
public class Edge {
    private Node parentNode;
    private Node childNode;
    private double value;

    public Edge(){}

    public Edge(Node pn, Node cn, double v){
        parentNode = pn;
        childNode = cn;
        value = v;
    }

    public void setParent(Node pn){
        parentNode = pn;
    }

    public void setChild(Node cn){
        childNode = cn;
    }
    public void setValue(double v){
        value = v;
    }

    public Node getParent(){
        return parentNode;
    }

    public Node getChild(){
        return childNode;
    }

    public double getValue(){
        return value;
    }
}
