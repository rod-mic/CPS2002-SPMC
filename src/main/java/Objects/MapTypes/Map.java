package Objects.MapTypes;

import Exceptions.PlayerException;
import Exceptions.SizeException;
import Objects.Position;
import Path.Algorithm.BreathFirst;
import Path.DataObjects.Graph;

/**
 * Created by rodemic on 07/04/2017.
 */

public class Map implements MapInterface{

    protected int size;
    protected int numOfPlayers;
    protected char[][] map;
    protected Position treasurePos;

    public Map(){}

    public void setMapProps(int size, int numOfPlayers) throws PlayerException, SizeException{
        if(numOfPlayers < 2) throw new PlayerException("Invalid amount of players");
        else if(numOfPlayers > 8) throw new PlayerException("Invalid amount of players");
        this.numOfPlayers = numOfPlayers;

        if(numOfPlayers < 5){
            if(size < 5) throw new SizeException("Invalid size");
            else if(size > 50) throw new SizeException("Invalid size");
        }
        else if(numOfPlayers > 4){
            if(size < 8) throw new SizeException("Invalid size");
            else if(size > 50) throw new SizeException("Invalid size");
        }
        this.size = size;
    }

    public boolean generate(){
        return true;
    }

    public int getMapSize(){ return size; }

    public Position getTreasurePos(){return treasurePos;}

    public char getTileType(Position position){ return map[position.getRow()][position.getCol()];}

    public boolean initMap(int size){
        map = new char[size][size];
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
