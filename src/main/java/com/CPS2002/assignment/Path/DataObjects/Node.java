package com.CPS2002.assignment.Path.DataObjects;
/**
 * Created by Thomas on 21/03/2017.
 */

import com.CPS2002.assignment.Objects.Position;

import java.util.ArrayList;

public class Node {
    private boolean start = false;
    private boolean waterTile = false;
    private boolean treasureTile = false;
    private Node parent;
    private ArrayList<Node> childNodes;
    private Position p;

    Node(){}

    Node(Position p, char tile){
        childNodes = new ArrayList<>();
        this.p = p;
        setValues(tile);
    }

    void setStart(){
        start = true;
    }

    private void setTreasureTile(){
        treasureTile = true;
    }

    private void setWaterTile(){
        waterTile = true;
    }


    void setParent(Node n){
        parent = n;
    }

    void addChildNode(Node n){
        childNodes.add(n);
    }

    public Node getParent(){
        return parent;
    }


    boolean isWaterTile() { return waterTile; }

    public boolean isTreasureTile() { return treasureTile; }

    Position getPosition(){ return p; }

    public ArrayList<Node> getChildNodes(){
        return childNodes;
    }

    private void setValues(char tile){
        if(tile == 'W') setWaterTile();
        else if(tile == 'T') setTreasureTile();
    }
}
