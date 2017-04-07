package com.CPS2002.assignment.Path.DataObjects;

/**
 * Created by thoma on 07/04/2017.
 */

import com.CPS2002.assignment.Objects.Position;

import java.util.Vector;

public class Graph {
    private char[][] map;
    private Vector<Node> listOfNodes;
    private Node rootNode;
    private Node goal;

    public Graph(char[][] map, Position position, Position treasure) {
        this.map = map;
        listOfNodes = new Vector<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                Node n = new Node(new Position(i,j),map[i][j]);
                listOfNodes.add(n);
            }
        }

        rootNode = new Node(position,map[position.getX()][position.getY()]);
        rootNode.setStart();
        listOfNodes.add(rootNode);

        goal = new Node(treasure,map[treasure.getX()][treasure.getY()]);

        Vector<Node> start = new Vector<>();
        Vector<Node> checked = new Vector<>();

        start.add(rootNode);
        checked.add(rootNode);

        setNodes(start, checked);
    }

    public Node getRootNode() {
        return rootNode;
    }

    public Node getGoalNode() { return goal; }

    private void setNodes(Vector<Node> currentLevel, Vector<Node> checked) {
        Vector<Node> nextLevel = new Vector<>();
        for (int i = 0; i < currentLevel.size(); i++) {
            Node n = currentLevel.elementAt(i);
            Position position = n.getPosition();

            if (position.getX() - 1 >= 0) {
                Node n1 = getNodeByPosition(new Position(position.getX()-1,position.getY()));
                if (!checked.contains(n1) && !n1.isWaterTile()) {
                    n.addChildNode(n1);
                    nextLevel.add(n1);
                    checked.add(n1);
                }
            }
            if (position.getX() + 1 < map.length) {
                Node n2 = getNodeByPosition(new Position(position.getX()+1,position.getY()));
                if (!checked.contains(n2) && !n2.isWaterTile()) {
                    n.addChildNode(n2);
                    nextLevel.add(n2);
                    checked.add(n2);
                }
            }
            if ( position.getY() - 1 >= 0) {
                Node n3 = getNodeByPosition(new Position(position.getX(),position.getY()-1));
                if (!checked.contains(n3) && !n3.isWaterTile()) {
                    n.addChildNode(n3);
                    nextLevel.add(n3);
                    checked.add(n3);
                }
            }
            if (position.getY() + 1 < map.length) {
                Node n4 = getNodeByPosition(new Position(position.getX(),position.getY()+1));
                if (!checked.contains(n4) && !n4.isWaterTile()) {
                    n.addChildNode(n4);
                    nextLevel.add(n4);
                    checked.add(n4);
                }
            }
        }
        setNodes(nextLevel,checked);
    }

    public Node getNodeByPosition(Position p){
        for(int i = 0; i < listOfNodes.size(); i++){
            if(listOfNodes.elementAt(i).getPosition() == p) return listOfNodes.elementAt(i);
        }
        return new Node();
    }
}
