package com.CPS2002.assignment.Path.DataObjects;
/**
 * Created by Thomas on 21/03/2017.
 */

import com.CPS2002.assignment.Objects.Position;

import java.util.Vector;

public class Node {
    private boolean start = false;
    private boolean waterTile = false;
    private boolean treasureTile = false;
    private Node parent;
    private Vector<Node> childNodes;
    private Position p;

    public Node(){}

    public Node(Position p, char tile){
        childNodes = new Vector<>();
        this.p = p;
        setValues(tile);
    }

    public void setStart(){
        start = true;
    }

    public void setTreasureTile(){
        treasureTile = true;
    }

    public void setWaterTile(){
        waterTile = true;
    }

    public void setPosition(Position p){
        this.p = p;
    }

    public void setParent(Node n){
        parent = n;
    }

    public void addChildNode(Node n){
        childNodes.add(n);
    }

    public Node getParent(){
        return parent;
    }

    public boolean getStart(){ return start; }

    public boolean isWaterTile() { return waterTile; }

    public boolean isTreasureTile() { return treasureTile; }

    public Position getPosition(){ return p; }

    public Vector<Node> getChildNodes(){
        return childNodes;
    }

    void setValues(char tile){
        if(tile == 'W') setWaterTile();
        else if(tile == 'T') setTreasureTile();
    }

}
