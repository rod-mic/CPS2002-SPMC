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
    private int turn;
    final private Player[] players;
    final private Map map;
    final private Scanner sc = new Scanner(System.in);

    public Game(Player[] players, Map map){
        turn = 0;
        this.players = players;
        this.map = map;
    }

    public void movePlayers(char[] direction){
        for (int i = 0; i < players.length; i++) {
            players[i].move(direction[i]);
        }
    }

    public boolean checkWinner(Player p){
        Position pos = p.getPosition();
        if(map.getTileType(pos) == 'T'){
            return true;
        }
        else return false;
    }

    public boolean checkWater(Player p){
        Position pos = p.getPosition();
        if(map.getTileType(pos) == 'W'){
            return true;
        }
        else return false;
    }

    public void printWinners(ArrayList<Integer> winners){
        if(winners.size() == 1)System.out.println("Player "+winners.get(0)+ " found the Treasure!");
        else {
            String print = "Players ";
            for (Integer winner : winners) {
                print += (Integer.toString(winner)+" ");
            }
            System.out.println(print+ "found the Treasure!");
        }
    }

    public void cleanup(){
        for(int i = 0;i<players.length;i++){
            Path playerPath = Paths.get("player_html/map_player_"+ Integer.toString(i) + ".html");
            try {
                Files.delete(playerPath);
            } catch (Exception e) {
                System.out.println("Error while deleting map_player_"+Integer.toString(i)+ ".html. Exiting Program");
                exit(1);
            }
        }
    }

    public char getUserDirection(Player p){
        char direction;
        boolean check;

        do{
            check = true;

            direction = sc.next().charAt(0);

            try {
                p.checkDirection(direction, map);
            } catch (InvalidDirectionException e) {
                System.out.print(direction + " is invalid. Please enter (U)p, (D)own, (L)eft or (R)ight. Direction:");
                check = false;
            } catch (InvalidPositionException e) {
                System.out.print(e.getMessage() + ". Direction: ");
                check = false;
            }

        }while(!check);

        return direction;
    }

    public void startGame(){
        boolean checkWin = false;
        char[] direction = new char[players.length];
        ArrayList<Integer> winners = new ArrayList<>();
        while(!checkWin) {
            turn++;
            System.out.println("Turn "+turn);
            for (int i = 0; i < players.length; i++) {
                System.out.print("Direction to move Player " + i + ": ");
                getUserDirection(players[i]);
            }

            movePlayers(direction);

            for (int i = 0; i < players.length; i++) {
                Player p = players[i];
                if(checkWinner(p)){
                    checkWin = true;
                    winners.add(i);
                }else if(checkWater(p)){
                    System.out.println("Player "+i+" landed on a water tile. Going to starting position");
                    players[i].moveToStart();break;
                }
            }
            generateHTMLFiles();
        }

        printWinners(winners);
        cleanup();
    }

    public void generateHTMLFiles(){
        for(int i = 0;i<players.length;i++){
            String table = "";
            for(int j = 0;j < map.getMapSize();j++){
                table += "<tr>\n";
                for(int k = 0;k < map.getMapSize();k++){
                    Position p = new Position(j,k);
                    if(players[i].getPosition().equals(p)) {
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
}
