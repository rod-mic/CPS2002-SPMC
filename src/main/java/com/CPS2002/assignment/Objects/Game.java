package com.CPS2002.assignment.Objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.lang.System.exit;

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
        generateHTMLFiles();
        return true;
    }

    public void generateHTMLFiles(){
        for(int i = 0;i<players.length;i++){
            String table = "";
            for(int j = 0;j < map.getMapSize();j++){
                table += "<tr>\n";
                for(int k = 0;k < map.getMapSize();k++){
                    Position p = new Position(j,k);
                    if(players[i].getStartPosition().equals(p)) {
                        switch(map.getTileType(p)){
                            case 'G': table += "<th class=\"grass\">&#9905;</th>\n";break;
                            case 'W': table += "<th class=\"water\">&#9905;</th>\n";break;
                            case 'T': table += "<th class=\"treasure\">&#9905;</th>\n";break;
                        }
                    }else if(players[i].getPreviousPositions().contains(p)){
                        switch(map.getTileType(p)){
                            case 'G': table += "<th class=\"grass\"></th>\n";break;
                            case 'W': table += "<th class=\"water\"></th>\n";break;
                            case 'T': table += "<th class=\"treasure\"></th>\n";break;
                        }
                    }else{
                        table += "<th class=\"unexplored\"></th>\n";
                    }
                }
                table += "</tr>\n";
            }
            Path templatePath = Paths.get("../html/template.html");
            String content = "";
            try {
                content = new String(Files.readAllBytes(templatePath));
                content = content.replace("$table",table);
            } catch (java.io.IOException e) {
                System.out.println("File htmlTemplate not found. Exiting Program");
                exit(1);
            }
            Path playerPath = Paths.get("../html/map_player_"+ Integer.toString(i) + ".html");
            try {
                Files.write(playerPath,content.getBytes(), StandardOpenOption.CREATE);
            } catch (IOException e) {
                System.out.println("File map_player_"+Integer.toString(i)+ ".html not found. Exiting Program");
                exit(1);
            }

        }
    }

    Map getMap(){
        return map;
    }
}
