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
    private Vector<Node> parentNodes;
    private Vector<Node> childNodes;
    private Position p;

    public Node(){}

    public Node(Position p){
        parentNodes = new Vector<>();
        childNodes = new Vector<>();
        this.p = p;
    }

    public Node(Position p, char tile){
        parentNodes = new Vector<>();
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

    void addChildNode(Node n){
        childNodes.add(n);
        n.addParentNodes(this);
    }

    private void addParentNodes(Node n){
        parentNodes.add(n);
    }

    public Vector<Node> getParentNodes(){
        return parentNodes;
    }

    public boolean getStart(){
        return start;
    }

    public boolean isWaterTile() { return waterTile; }

    public boolean isTreasureTile() { return treasureTile; }

    public Position getPosition(){ return p; }

    public Vector<Node> getChildNodes(){
        return childNodes;
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

    void setValues(char tile){
        if(tile == 'W') setWaterTile();
        else if(tile == 'T') setTreasureTile();
    }

}
