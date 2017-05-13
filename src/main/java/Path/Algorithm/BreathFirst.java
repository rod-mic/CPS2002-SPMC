package Path.Algorithm;

import Path.DataObjects.Graph;
import Path.DataObjects.Node;

import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * Created by Thomas on 21/03/2017.
 */
public class BreathFirst{
    final Node rootNode;

    public BreathFirst(Graph g){
        rootNode = g.getRootNode();
    }


     public Vector<Node> getPath(Vector<Node> currentLevel, Vector<Node> path, Vector<Node> checked, Vector<Vector<Node>> pastLevels, int depth){
        Vector<Node> nextLevel = new Vector<>();
        for(int i = 0; i < currentLevel.size(); i++){
            Vector<Node> childs = currentLevel.get(i).getChildNodes();
            for (Node child : childs) {
                if (child.isTreasureTile()) {
                    path.add(child);
                    path.add(currentLevel.elementAt(i));
                    Node checkParent = currentLevel.elementAt(i);
                    for (int k = depth; k > 0; k--) {
                        for (int l = 0; l < pastLevels.elementAt(k - 1).size(); l++) {
                            if (checkParent.getParent().equals(pastLevels.elementAt(k - 1).elementAt(l))) {
                                path.add(pastLevels.elementAt(k - 1).elementAt(l));
                                checkParent = pastLevels.elementAt(k - 1).elementAt(l);
                            }
                        }
                    }
                    return path;
                } else if (checked.contains(child)) continue;
                nextLevel.add(child);
                checked.add(child);
            }
        }
        pastLevels.add(nextLevel);
        if(nextLevel.size() == 0) return path;
        else return getPath(nextLevel,path,checked,pastLevels,depth+1);
    }

    public Vector<Node> reverseVector(Vector<Node> v){
        Vector<Node> result = new Vector<>();
        for(int i = v.size()-1; i >= 0; i--){
            result.add(v.elementAt(i));
        }
        return result;
    }

    public boolean checkPath(){
        Vector<Node> start = new Vector<>();
        Vector<Node> path = new Vector<>();
        Vector<Node> checked = new Vector<>();
        Vector<Vector<Node>> levels = new Vector<>();
        start.add(rootNode);
        checked.add(rootNode);
        levels.add(start);
        path = getPath(start, path, checked,levels,0);
        path = reverseVector(path);
        try{
            return (path.lastElement().isTreasureTile());
        }catch(NoSuchElementException e){
            return false;
        }
    }

    public Node getRootNode(){ return rootNode; }
}
