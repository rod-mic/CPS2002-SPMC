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

    public boolean setStart(){
        start = true;
        return true;
    }

    public boolean setTreasureTile(){
        treasureTile = true;
        return true;
    }

    public boolean setWaterTile(){
        waterTile = true;
        return true;
    }

    public boolean setPosition(Position p){
        this.p = p;
        return true;
    }

    public boolean setParent(Node n){
        parent = n;
        return true;
    }

    public boolean addChildNode(Node n){
        childNodes.add(n);
        return true;
    }

    public Node getParent(){ return parent; }

    public boolean getStart(){ return start; }

    public boolean isWaterTile() { return waterTile; }

    public boolean isTreasureTile() { return treasureTile; }

    public Position getPosition(){ return p; }

    public Vector<Node> getChildNodes(){
        return childNodes;
    }

    public boolean setValues(char tile){
        if(tile == 'W') setWaterTile();
        else if(tile == 'T') setTreasureTile();
        return true;
    }

    public String showChildPos(){
        String result = "";
        for(int i = 0; i < childNodes.size(); i++){
            result += childNodes.elementAt(i).getPosition().getX() + "," + childNodes.elementAt(i).getPosition().getY() + "|";
        }
        return result;
    }

}
