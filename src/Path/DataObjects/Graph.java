package Path.DataObjects;

/**
 * Created by thoma on 07/04/2017.
 */

import java.util.*;
import main.java.*;

public class Graph {
    private Vector<Node> listOfNodes;
    private Node rootNode;
    private Node goal;
    private char[][] map;

    public Graph(char[][] map, Position position){
        this.map = map;
        rootNode = new Node();
        rootNode.setValues(map[position.getX()][position.getY()]);
        listOfNodes = new Vector<>();
        setNodes(position, rootNode);
    }

    public Node getRootNode(){
        return rootNode;
    }

    public Node getGoalNode(){
        for(int i = 0; i < listOfNodes.size(); i++){
            if(listOfNodes.elementAt(i).isTreasureTile()) return listOfNodes.elementAt(i);
        }
        return new Node();
    }

    public void setNodes(Position position, Node n) {
        if (listOfNodes.contains(n)) {
            if (position.getX() > 0 && position.getY() > 0) {
                Node n1 = new Node();
                n1.setValues(map[position.getX() - 1][position.getY()]);
                Node n2 = new Node();
                n2.setValues(map[position.getX()][position.getY() - 1]);

                n.addChildNode(n1);
                Position p1 = new Position(position.getX() - 1, position.getY());
                setNodes(p1, n1);
                n.addChildNode(n2);
                Position p2 = new Position(position.getX(), position.getY() - 1);
                setNodes(p2, n2);
            }
            if (position.getX() < map.length - 1 && position.getY() < map.length - 1) {
                Node n1 = new Node();
                n1.setValues(map[position.getX() + 1][position.getY()]);
                Node n2 = new Node();
                n2.setValues(map[position.getX()][position.getY() + 1]);

                n.addChildNode(n1);
                Position p1 = new Position(position.getX() + 1, position.getY());
                setNodes(p1, n1);
                n.addChildNode(n2);
                Position p2 = new Position(position.getX(), position.getY() + 1);
                setNodes(p2, n2);
            }
            if (position.getX() == map.length - 1 && position.getY() == 0) {
                Node n1 = new Node();
                n1.setValues(map[position.getX() - 1][position.getY()]);
                Node n2 = new Node();
                n2.setValues(map[position.getX()][position.getY() + 1]);

                n.addChildNode(n1);
                Position p1 = new Position(position.getX() - 1, position.getY());
                setNodes(p1, n1);
                n.addChildNode(n2);
                Position p2 = new Position(position.getX(), position.getY() + 1);
                setNodes(p2, n2);
            }
            if (position.getY() == map.length - 1 && position.getX() == 0) {
                Node n1 = new Node();
                n1.setValues(map[position.getX()][position.getY() - 1]);
                Node n2 = new Node();
                n2.setValues(map[position.getX() + 1][position.getY()]);

                n.addChildNode(n1);
                Position p1 = new Position(position.getX(), position.getY() - 1);
                setNodes(p1, n1);
                n.addChildNode(n2);
                Position p2 = new Position(position.getX() + 1, position.getY());
                setNodes(p2, n2);
            }
            listOfNodes.add(n);
        }
    }

    public void goThroughGraph(){
        for(int i = 0; i < listOfNodes.size(); i++){
            System.out.println(listOfNodes.elementAt(i).toString());
        }
    }

    public void showRoot(){
        System.out.println(rootNode.getName());
    }

    public void showGoals(){
        System.out.println(goal.getName());
    }
}
