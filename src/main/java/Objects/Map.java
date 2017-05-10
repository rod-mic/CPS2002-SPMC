package Objects;

import Path.Algorithm.BreathFirst;
import Path.DataObjects.Graph;

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

    public boolean setMapSize(int s, int player, int choice){
        if(player >= 2 && player <= 4 && s >= 5){
            size = s;
            map = new char[size][size];
            initMap(size);
            boolean check = true;
            while(check){
                chooseMapType(choice);
                outputMap();
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
                chooseMapType(choice);
                outputMap();
                if(checkAnyPaths(player)) check = false;
            }
            return true;
        }
        else return false;
    }

    public boolean chooseMapType(int choice){
        int maxPercentWaterTile = 0;
        int minPercentWaterTile = 0;

        switch(choice){
            case 1: minPercentWaterTile = 0;
                    maxPercentWaterTile = 10;
                    break;
            case 2: minPercentWaterTile = 25;
                    maxPercentWaterTile = 35;
                    break;
            default: System.out.println("Invalid type");
        }
        generate(minPercentWaterTile,maxPercentWaterTile);
        return true;
    }

    public boolean generate(int minWater, int maxWater){
        //Setting Treasure Tile
        int xrand = ThreadLocalRandom.current().nextInt(0, size);
        int yrand = ThreadLocalRandom.current().nextInt(0, size);
        map[xrand][yrand] = 'T';
        treasurePos = new Position(xrand, yrand);

        //Setting Grass Tiles
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(map[i][j] != 'T') map[i][j] = 'G';
            }
        }

        //Setting Water Tiles
        int minWaterTiles = (size * size * minWater)/100;
        int maxWaterTiles = (size * size * maxWater)/100;
        int currentWaterTiles = 0;
        for(int i = 0; i < maxWaterTiles; i++){
            if(currentWaterTiles < minWaterTiles) {
                xrand = ThreadLocalRandom.current().nextInt(0, size);
                yrand = ThreadLocalRandom.current().nextInt(0, size);
                while(map[xrand][yrand] != 'G'){
                    xrand = ThreadLocalRandom.current().nextInt(0, size);
                    yrand = ThreadLocalRandom.current().nextInt(0, size);
                }
                map[xrand][yrand] = 'W';
                currentWaterTiles++;
            }
            else{
               int randomValue = ThreadLocalRandom.current().nextInt(0,2);
               if(randomValue == 1){
                   xrand = ThreadLocalRandom.current().nextInt(0, size);
                   yrand = ThreadLocalRandom.current().nextInt(0, size);
                   while(map[xrand][yrand] != 'G'){
                       xrand = ThreadLocalRandom.current().nextInt(0, size);
                       yrand = ThreadLocalRandom.current().nextInt(0, size);
                   }
                   map[xrand][yrand] = 'W';
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
