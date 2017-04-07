package Path.DataObjects;

/**
 * Created by Thomas on 21/03/2017.
 */

import java.util.Set;
import java.util.Vector;

public class Node {
    private String name;
    private boolean start = false;
    private boolean waterTile = false;
    private boolean treasureTile = false;
    private Vector<Node> parentNodes;
    private Vector<Node> childNodes;

    public Node(){};

    public Node(String name){
        this.name = name;
        parentNodes = new Vector<>();
        childNodes = new Vector<>();
    }


    public void setName(String n){
        name = n;
    }

    public void setStart(){
        start = true;
        name = "*";
    }
    public void setTreasureTile(){
        treasureTile = true;
        name = "X";
    }

    public void setWaterTile(){
        waterTile = true;
        name = "!";
    }

    public void addChildNodes(Node n){
        childNodes.add(n);
        n.addParentNodes(this);
    }

    public void addParentNodes(Node n){
        parentNodes.add(n);
    }

    public Vector<Node> getParentNodes(){
        return parentNodes;
    }

    public String getName(){
        return name;
    }

    public boolean getStart(){
        return start;
    }

    public boolean isWaterTile() { return waterTile; }

    public boolean isTreasureTile() { return treasureTile; }

    public Vector<Node> getChildNodes(){
        return childNodes;
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

    public void setValues(char tile){
        if(tile == 'W') setWaterTile();
        else if(tile == 'T') setTreasureTile();
    }

}
