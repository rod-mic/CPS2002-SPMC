package main.java;

import Path.Algorithm.BreathFirst;
import Path.DataObjects.Graph;

/**
 * Created by rodemic on 07/04/2017.
 */

public class Map {
    private int size;
    private char[][] map;

    public Map(){
    }

    public boolean setMapSize(int s, int player){
        if(player >= 2 && player <= 4 && s >= 5){
            size = s;
            map = new char[size][size];
            initMap(size);
            generate();
            return true;
        }
        else if(player >= 5 && player <= 8 && s >= 8){
            size = s;
            map = new char[size][size];
            initMap(size);
            generate();
            return true;
        }
        else return false;
    }

    public void generate(){
        int xrand = (int)(Math.random()*(size-1));
        int yrand = (int)(Math.random()*(size-1));
        map[xrand][yrand] = 'T';
        int randomValue;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                randomValue = (int)(Math.random()*6);
                System.out.println(randomValue);
                if(map[i][j] != 'T'){
                    if(randomValue == 5) map[i][j] = 'W';
                    else map[i][j] = 'G';
                }
            }
        }
    }

    public int getMapSize(){ return size; }

    public char getTileType(Position position){ return map[position.getX()][position.getY()];}

    public boolean checkPath(Position position){
        Graph g = new Graph(map,position);
        BreathFirst b = new BreathFirst(g);
        return b.checkPath();
    }

    public void initMap(int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = ' ';
            }
        }
    }
}
