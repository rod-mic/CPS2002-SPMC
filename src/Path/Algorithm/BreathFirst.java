package Algorithms;

import DataObjects.Node;
import Graph.Graph;

import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * Created by Thomas on 21/03/2017.
 */
public class BreathFirst extends Algorithm implements AlgoLayout{
    public BreathFirst(Graph g){
        super(g);
    }

    public Vector<Vector<Node>> getAllPaths(){
        Vector<Vector<Node>> allPaths = new Vector<>();
        Vector<Node> tempGoals = new Vector<>();
        for(int i = 0; i < 3; i++){
            tempGoals.add(goalNodes.elementAt(i));
        }
        for(int i = 0; i < 3; i++){
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
                removeGoal(path.lastElement());
                allPaths.add(path);
            }catch (NoSuchElementException e){
                if(goalNodes.size() == 1) System.out.println("Path to Node["+goalNodes.lastElement().getName()+"] was not found.\n\n");
                else if(goalNodes.size() == 2){
                    System.out.println("Path to Nodes["+goalNodes.elementAt(0).getName()+","+goalNodes.elementAt(1)+"] was not found.\n\n");
                }
                else if(goalNodes.size() == 3){
                    System.out.println("No paths were found.\n\n");
                }
                removeGoal(tempGoals.elementAt(i));
            }
        }
        for(int i = 0; i < 3; i++){
            if(goalNodes.contains(tempGoals.elementAt(i))) continue;
            else goalNodes.add(tempGoals.elementAt(i));
        }
        return allPaths;
    }

    public Vector<Node> getPath(Vector<Node> currentLevel, Vector<Node> path, Vector<Node> checked, Vector<Vector<Node>> pastLevels, int depth){
        Vector<Node> nextLevel = new Vector<>();
        for(int i = 0; i < currentLevel.size(); i++){
            Vector<Node> childs = currentLevel.elementAt(i).getChildNodes();
            for(int j = 0; j < childs.size(); j++){
                if(goalNodes.contains(childs.elementAt(j))){
                    path.add(childs.elementAt(j));
                    path.add(currentLevel.elementAt(i));
                    Node checkParent = currentLevel.elementAt(i);
                    for(int k = depth; k > 0; k--){
                        for(int l = 0; l < pastLevels.elementAt(k-1).size(); l++){
                            if(checkParent.getParentNodes().contains(pastLevels.elementAt(k-1).elementAt(l))) {
                                path.add(pastLevels.elementAt(k-1).elementAt(l));
                                checkParent = pastLevels.elementAt(k-1).elementAt(l);
                            }
                        }
                    }
                    return path;
                }
                else if(checked.contains(childs.elementAt(j))) continue;
                nextLevel.add(childs.elementAt(j));
                checked.add(childs.elementAt(j));
            }
        }
        pastLevels.add(nextLevel);
        if(nextLevel.size() == 0) return path;
        else return getPath(nextLevel,path,checked,pastLevels,depth+1);
    }

    private Vector<Node> reverseVector(Vector<Node> v){
        Vector<Node> result = new Vector<>();
        for(int i = v.size()-1; i >= 0; i--){
            result.add(v.elementAt(i));
        }
        return result;
    }
}
