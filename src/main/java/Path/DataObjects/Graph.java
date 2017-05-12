package Path.DataObjects;

/**
 * Created by thoma on 07/04/2017.
 */

import Objects.MapTypes.*;
import Objects.Position;

import java.util.ArrayList;
import java.util.Vector;

public class Graph {
    final private char[][] map;
    final private ArrayList<Node> listOfNodes;
    private Node rootNode;
    final private Node goal;

    public Graph(MapInterface m, Position position, Position treasure) {
        this.map = m.getMap();
        listOfNodes = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                Node n = new Node(new Position(i, j), map[i][j]);
                if (position.getRow() == i && position.getCol() == j) {
                    rootNode = n;
                    rootNode.setStart();
                }
                listOfNodes.add(n);
            }
        }

        goal = new Node(treasure,map[treasure.getRow()][treasure.getCol()]);

        Vector<Node> start = new Vector<>();
        Vector<Node> checked = new Vector<>();

        start.add(rootNode);
        checked.add(rootNode);

        setNodes(start, checked);
    }

    public Node getRootNode() {
        return rootNode;
    }

    //public Node getGoalNode() { return goal; }

    public ArrayList<Node> getListOfNodes(){ return listOfNodes; }

    public boolean setNodes(Vector<Node> currentLevel, Vector<Node> checked) {
        Vector<Node> nextLevel = new Vector<>();
        for (int i = 0; i < currentLevel.size(); i++) {
            Node n = currentLevel.elementAt(i);
            Position position = n.getPosition();

            if (position.getRow() - 1 >= 0) {
                Node n1 = getNodeByPosition(new Position(position.getRow()-1,position.getCol()));
                if (!checked.contains(n1) && !n1.isWaterTile()) {
                    n.addChildNode(n1);
                    n1.setParent(n);
                    nextLevel.add(n1);
                    checked.add(n1);
                }
            }
            if (position.getRow() + 1 < map.length) {
                Node n2 = getNodeByPosition(new Position(position.getRow()+1,position.getCol()));
                if (!checked.contains(n2) && !n2.isWaterTile()) {
                    n.addChildNode(n2);
                    n2.setParent(n);
                    nextLevel.add(n2);
                    checked.add(n2);
                }
            }
            if ( position.getCol() - 1 >= 0) {
                Node n3 = getNodeByPosition(new Position(position.getRow(),position.getCol()-1));
                if (!checked.contains(n3) && !n3.isWaterTile()) {
                    n.addChildNode(n3);
                    n3.setParent(n);
                    nextLevel.add(n3);
                    checked.add(n3);
                }
            }
            if (position.getCol() + 1 < map.length) {
                Node n4 = getNodeByPosition(new Position(position.getRow(),position.getCol()+1));
                if (!checked.contains(n4) && !n4.isWaterTile()) {
                    n.addChildNode(n4);
                    n4.setParent(n);
                    nextLevel.add(n4);
                    checked.add(n4);
                }
            }
        }
        if(nextLevel.size() != 0) return setNodes(nextLevel,checked);
        else return true;
    }

    public Node getNodeByPosition(Position p){
        Node n = new Node();
        boolean check = true;
        for(int i = 0; i < listOfNodes.size() && check; i++){
            Position p2 = listOfNodes.get(i).getPosition();
            if(p2.getRow() == p.getRow() && p2.getCol() == p.getCol()){
                n = listOfNodes.get(i);
                check = false;
            }
        }
        return n;
    }
}
