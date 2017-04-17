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
    private Position treasurePos;

    public Map(){
    }

    public boolean setMapSize(int s, int player){
        if(player >= 2 && player <= 4 && s >= 5){
            size = s;
            map = new char[size][size];
            initMap(size);
            boolean check = true;
            while(check){
                generate();
                //outputMap();
                if(checkAnyPaths()) check = false;
            }
            return true;
        }
        else if(player >= 5 && player <= 8 && s >= 8){
            size = s;
            map = new char[size][size];
            initMap(size);
            boolean check = true;
            while(check){
                generate();
                //outputMap();
                if(checkAnyPaths()) check = false;
            }
            return true;
        }
        else return false;
    }

    public boolean generate(){
        int xrand = ThreadLocalRandom.current().nextInt(0,size);
        int yrand = ThreadLocalRandom.current().nextInt(0,size);
        map[xrand][yrand] = 'T';
        treasurePos = new Position(xrand,yrand);
        int randomValue;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                randomValue = ThreadLocalRandom.current().nextInt(1,6);
                if(map[i][j] != 'T'){
                    if(randomValue == 5) map[i][j] = 'W';
                    else map[i][j] = 'G';
                }
            }
        }
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

    public boolean checkAnyPaths(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] == 'G'){
                    Position p = new Position(i,j);
                    if(checkPath(p)) return true;
                }
            }
        }
        return false;
    }

    public boolean checkPath(Position position){
        Graph g = new Graph(this,position,treasurePos);
        BreathFirst b = new BreathFirst(g);
        return b.checkPath();
    }

    public char[][] getMap(){ return map; }
}
