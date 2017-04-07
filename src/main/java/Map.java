package main.java;

/**
 * Created by rodemic on 07/04/2017.
 */

//TODO
public class Map {
    private int size;
    private char[][] map = new char[size][size];

    public Map(int s){
        size = s;
    }

    public boolean setMapSize(int s, int player){
        if(player >= 2 && player <= 4 && s >= 5){
            size = s;
            return true;
        }
        else if(player >= 5 && player <= 8 && s >= 8){
            size = s;
            return true;
        }
        else return false;
    }

    public void generate(){
        int xrand = (int)(Math.random()*size + 1);
        int yrand = (int)(Math.random()*size + 1);
        map[xrand][yrand] = 'T';

    }

    public int getMapSize(){ return size; }

    public char getTileType(int x, int y){ return map[x][y];}
}
