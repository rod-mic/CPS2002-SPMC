import Exceptions.SizeException;
import Objects.Game;
import Objects.Map;
import Objects.Player;

import java.util.Scanner;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Launcher {

    public static void main(String[] args){
        Game game = setup();
        game.startGame();

    }
    public static Game setup(){
        boolean check = false;
        int numPlayer = 0;
        int mapSize;

        Player[] players;
        Map map = new Map();
        Game game;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Welcome to the game!");
        System.out.println("Choose map type: (1) Safe - (2) Hazardous");

        int choice = 0;
        while(!check){
            try{
                choice = Integer.parseInt(sc.nextLine());
                if(choice > 0 && choice < 3){
                    check = true;
                }
                else System.out.println("Invalid input");
            }catch(NumberFormatException e){
                System.out.println("Invalid input");
                check = false;
            }
        }check = false;

        System.out.println("How many users will be playing? (2-8 Players)");

        while(!check){
            try {
                numPlayer = Integer.parseInt(sc.nextLine());
                if(numPlayer < 2 || numPlayer > 8)throw new SizeException("2 and 8");
                check = true;
            }catch(NumberFormatException ex){
                System.out.println("Incorrect input. Numbers only. Try again: ");
                check = false;
            }catch(SizeException ex){
                System.out.println("There can only be between "+ex.getMessage()+" players. Try again: ");
                check = false;
            }
        }check = false;
        players = new Player[numPlayer];

        if(numPlayer < 5) System.out.println("How big  will the map be? (Between 5x5 and 50x50)");
        else System.out.println("How big  will the map be? (Between 8x8 and 50x50)");

        while(!check){
            try {
                mapSize = Integer.parseInt(sc.nextLine());
                if(!map.setMapSize(mapSize,numPlayer,choice)) {
                    if ((mapSize < 5 || mapSize > 50) && numPlayer < 5) throw new SizeException("5x5 and 50x50");
                    else if ((mapSize < 8 || mapSize > 50) && numPlayer > 4) throw new SizeException("8x8 and 50x50");
                }
                check = true;
            }catch(NumberFormatException ex){
                System.out.println("Incorrect input. Numbers only. Try again: ");
                check = false;
            }catch(SizeException ex){
                System.out.println("The size must be between "+ex.getMessage()+" tiles. Try again: ");
                check = false;
            }
        }

        for(int i = 0; i < numPlayer; i++){
            players[i] = new Player(map);
        }

        game = new Game(players,map);
        game.generateHTMLFiles();
        return game;
    }
}
