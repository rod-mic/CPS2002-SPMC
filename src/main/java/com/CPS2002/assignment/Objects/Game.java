package com.CPS2002.assignment.Objects;

import com.CPS2002.assignment.Exceptions.InvalidDirectionException;
import com.CPS2002.assignment.Exceptions.InvalidPositionException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Game {
    int turn;
    Player[] players;
    private Map map;
    Scanner sc = new Scanner(System.in);

    public Game(Player[] players, Map map){
        turn = 0;
        this.players = players;
        this.map = map;
    }

    public void startGame(){
        boolean check;
        boolean checkWin = false;
        char[] direction = new char[players.length];
        ArrayList<Integer> winners = new ArrayList<Integer>();
        while(!checkWin) {
            for (int i = 0; i < players.length; i++) {
                System.out.print("Direction to move Player " + i + ": ");
                check = false;
                while (!check) {
                    direction[i] = sc.next().charAt(0);
                    try {
                        players[i].checkDirection(direction[i], map);
                        check = true;
                    } catch (InvalidDirectionException e) {

                        System.out.print(direction[i] +" is invalid. Please enter (U)p, (D)own, (L)eft or (R)ight. Direction: ");
                    } catch (InvalidPositionException e) {
                        System.out.print(e.getMessage() + "Direction: ");
                    }
                }
            }
            for (int i = 0; i < players.length; i++) {
                players[i].move(direction[i]);
                Position pos = players[i].getPosition();
                switch(map.getTileType(pos)){
                    case 'W':
                        System.out.println("Player "+i+" landed on a water tile. Going to starting position");
                        players[i].moveToStart();break;
                    case 'T':
                        winners.add(i);
                        checkWin = true;
                }
            }
            generateHTMLFiles();
        }
        if(winners.size() == 1)System.out.println("Player "+winners.get(0)+ " found the Treasure!");
        else {
            String print = "Players ";
            for(int i = 0;i<winners.size();i++){
                print += Integer.toString(winners.get(i));
            }
            System.out.println(print+ " found the Treasure!");
        }
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
            Path templatePath = Paths.get("src/main/html/template.html");
            String content = "";
            try {
                content = new String(Files.readAllBytes(templatePath));
                content = content.replace("$table",table);
            } catch (java.io.IOException e) {
                System.out.println("File htmlTemplate not found. Exiting Program");
                exit(1);
            }
            Path playerPath = Paths.get("player_html/map_player_"+ Integer.toString(i) + ".html");
            try {
                Files.write(playerPath,content.getBytes());
            } catch (Exception e) {
                System.out.println("Error while writing map_player_"+Integer.toString(i)+ ".html. Exiting Program");
                exit(1);
            }

        }
    }

    Map getMap(){
        return map;
    }
}
