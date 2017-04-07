package com.CPS2002.assignment.Objects;

/**
 * Created by rodemic on 07/04/2017.
 */
//TODO
public class Game {
    int turn;
    Player[] players;
    private Map map;

    public Game(Player[] players, Map map){
        turn = 0;
        this.players = players;
        this.map = map;
    }

    boolean startGame(){
        return true;
    }

    public void generateHTMLFiles(){
        for(int i = 0;i<players.length;i++){
            String table = "";
            for(int j = 0;j < map.getMapSize();j++){
                table += "<tr>\n";
                for(int k = 0;k < map.getMapSize();k++){
                    Position p = new Position(j,k);
                    if(p == players[i].getStartPosition()){
                        table += "<th class=\"grass\">&#9905;</th>\n";
                    }else{
                        table += "<th class=\"unexplored\"></th>\n";
                    }
                }
                table += "</tr>\n";
            }
            System.out.println(table);
        }
    }

    Map getMap(){
        return map;
    }
}
