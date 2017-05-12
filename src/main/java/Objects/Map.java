package Objects;

import Path.Algorithm.BreathFirst;
import Path.DataObjects.Graph;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rodemic on 07/04/2017.
 */

public class Map implements MapInterface{

    protected int size;
    protected char[][] map;
    protected Position treasurePos;

    public Map(){}

    public boolean setMapSize(int s, int player){
        if(player >= 2 && player <= 4 && s >= 5){
            size = s;
            map = new char[size][size];
            initMap(size);
            boolean check = true;
            while(check){
                if(checkAnyPaths(player)) check = false;
            }
            return true;
        }
        else if(player >= 5 && player <= 8 && s >= 8){
            size = s;
            map = new char[size][size];
            initMap(size);
            boolean check = true;
            while(check){
                if(checkAnyPaths(player)) check = false;
            }
            return true;
        }
        else return false;
    }

    public boolean generate(){
        return true;
    }

    public int getMapSize(){ return size; }

    public Position getTreasurePos(){return treasurePos;}

    public char getTileType(Position position){ return map[position.getRow()][position.getCol()];}

    public boolean initMap(int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = ' ';
            }
        }
        return true;
    }

    public boolean outputMap(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }

    public boolean checkAnyPaths(int player){
        int possiblePaths = 0;
        for(int i = 0; i < size && possiblePaths < player; i++){
            for(int j = 0; j < size && possiblePaths < player; j++){
                if(map[i][j] == 'G'){
                    Position p = new Position(i,j);
                    if(checkPath(p)) possiblePaths++;
                }
            }
        }
        return possiblePaths == player;
    }

    public boolean checkPath(Position position){
        Graph g = new Graph(this,position,treasurePos);
        BreathFirst b = new BreathFirst(g);
        return b.checkPath();
    }

    public char[][] getMap(){ return map; }
}
