package com.CPS2002.assignment.Objects;

import com.CPS2002.assignment.Path.Algorithm.BreathFirst;
import com.CPS2002.assignment.Path.DataObjects.Graph;

import java.util.concurrent.ThreadLocalRandom;

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

    private void generate(){
        int xrand = ThreadLocalRandom.current().nextInt(0,size);
        int yrand = ThreadLocalRandom.current().nextInt(0,size);
        map[xrand][yrand] = 'T';
        int randomValue;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                randomValue = ThreadLocalRandom.current().nextInt(1,5);
                if(map[i][j] != 'T'){
                    if(randomValue == 5) map[i][j] = 'W';
                    else map[i][j] = 'G';
                }
            }
        }
    }

    int getMapSize(){ return size; }

    char getTileType(Position position){ return map[position.getX()][position.getY()];}

    boolean checkPath(Position position){
        Graph g = new Graph(map,position);
        BreathFirst b = new BreathFirst(g);
        return b.checkPath();
    }

    private void initMap(int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                map[i][j] = ' ';
            }
        }
    }
}
